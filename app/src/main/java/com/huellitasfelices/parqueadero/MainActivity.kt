package com.huellitasfelices.parqueadero

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.os.Message
import android.util.Base64
import android.view.ViewGroup
import android.webkit.JavascriptInterface
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private var filePathCallback: ValueCallback<Array<Uri>>? = null

    private val filePicker: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            val uris = if (result.resultCode == Activity.RESULT_OK) {
                WebChromeClient.FileChooserParams.parseResult(result.resultCode, result.data)
            } else null
            filePathCallback?.onReceiveValue(uris)
            filePathCallback = null
        }

    private fun abrirExterno(uri: Uri) {
        try {
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "No hay una app instalada para abrir este enlace", Toast.LENGTH_SHORT).show()
        }
    }

    inner class DescargaBridge {
        @JavascriptInterface
        fun guardar(nombre: String, mime: String, base64: String) {
            try {
                val bytes = Base64.decode(base64, Base64.DEFAULT)
                val carpeta = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
                carpeta?.mkdirs()
                val archivo = File(carpeta, nombre)
                FileOutputStream(archivo).use { it.write(bytes) }
                runOnUiThread {
                    Toast.makeText(
                        this@MainActivity,
                        "Guardado en Archivos > Android/data/${packageName}/files/Download",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } catch (e: Exception) {
                runOnUiThread {
                    Toast.makeText(this@MainActivity, "No se pudo guardar el archivo", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    inner class PagosBridge {
        @JavascriptInterface
        fun pagar(monto: String, numero: String, paquete: String) {
            runOnUiThread {
                try {
                    val clipboard = getSystemService(ClipboardManager::class.java)
                    clipboard.setPrimaryClip(ClipData.newPlainText("Monto", monto))
                    val destino = if (numero.isNotBlank()) " al enviar a $numero" else ""
                    Toast.makeText(
                        this@MainActivity,
                        "Monto $monto copiado · Pégalo$destino",
                        Toast.LENGTH_LONG
                    ).show()
                } catch (e: Exception) {
                    // Si falla el portapapeles, igual abrimos la app para que el operario digite el valor.
                }

                val intentApp = packageManager.getLaunchIntentForPackage(paquete)
                if (intentApp != null) {
                    startActivity(intentApp)
                    return@runOnUiThread
                }
                try {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$paquete")))
                } catch (e: ActivityNotFoundException) {
                    abrirExterno(Uri.parse("https://play.google.com/store/apps/details?id=$paquete"))
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        webView = WebView(this)
        webView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        setContentView(webView)

        with(webView.settings) {
            javaScriptEnabled = true
            domStorageEnabled = true
            databaseEnabled = true
            setSupportMultipleWindows(true)
            javaScriptCanOpenWindowsAutomatically = true
            allowFileAccess = true
            cacheMode = android.webkit.WebSettings.LOAD_DEFAULT
        }

        webView.addJavascriptInterface(DescargaBridge(), "AndroidDownload")
        webView.addJavascriptInterface(PagosBridge(), "AndroidPagos")

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
                val uri = request.url
                return when (uri.scheme) {
                    "http", "https", "tel", "mailto", "sms", "whatsapp" -> {
                        abrirExterno(uri)
                        true
                    }
                    else -> false
                }
            }

            override fun onPageFinished(view: WebView, url: String?) {
                super.onPageFinished(view, url)
                val clave = intent.getStringExtra("clave_licencia") ?: ""
                val js = "if(window.iniciarSync)window.iniciarSync(" +
                    "${org.json.JSONObject.quote(clave)}," +
                    "${org.json.JSONObject.quote(BuildConfig.SUPABASE_URL)}," +
                    "${org.json.JSONObject.quote(BuildConfig.SUPABASE_ANON_KEY)});"
                view.evaluateJavascript(js, null)
            }
        }

        webView.webChromeClient = object : WebChromeClient() {
            override fun onCreateWindow(
                view: WebView,
                isDialog: Boolean,
                isUserGesture: Boolean,
                resultMsg: Message
            ): Boolean {
                val ventanaTemporal = WebView(view.context)
                ventanaTemporal.webViewClient = object : WebViewClient() {
                    override fun shouldOverrideUrlLoading(v: WebView, request: WebResourceRequest): Boolean {
                        abrirExterno(request.url)
                        return true
                    }
                }
                val transport = resultMsg.obj as WebView.WebViewTransport
                transport.webView = ventanaTemporal
                resultMsg.sendToTarget()
                return true
            }

            override fun onShowFileChooser(
                view: WebView,
                callback: ValueCallback<Array<Uri>>,
                params: FileChooserParams
            ): Boolean {
                filePathCallback = callback
                return try {
                    filePicker.launch(params.createIntent())
                    true
                } catch (e: ActivityNotFoundException) {
                    filePathCallback = null
                    false
                }
            }
        }

        webView.loadUrl("file:///android_asset/index.html")
    }

    override fun onDestroy() {
        webView.destroy()
        super.onDestroy()
    }

    @Suppress("DEPRECATION")
    override fun onBackPressed() {
        if (::webView.isInitialized && webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
