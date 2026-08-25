package com.huellitasfelices.parqueadero

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LicenseGateActivity : AppCompatActivity() {

    private val asfalto = Color.parseColor("#14171C")
    private val panel = Color.parseColor("#1C2128")
    private val ambar = Color.parseColor("#FFB300")
    private val tinta = Color.parseColor("#EEF0F3")
    private val tinta2 = Color.parseColor("#9AA5B2")
    private val rojo = Color.parseColor("#FF5A5A")
    private val verde = Color.parseColor("#25D366")
    private val verdeTexto = Color.parseColor("#06301A")

    private val whatsappSoporte = "573114980095"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mostrarCargando()
        val clave = LicenseManager.obtenerClave(this)
        if (clave.isNullOrBlank()) {
            mostrarActivacion(null)
        } else {
            validar(clave)
        }
    }

    private fun validar(clave: String) {
        LicenseManager.verificar(clave, LicenseManager.deviceId(this)) { resultado ->
            runOnUiThread {
                if (resultado != null) {
                    LicenseManager.guardarResultado(this, resultado)
                    if (resultado.valido) entrar() else mostrarBloqueo(resultado.mensaje, false)
                } else if (LicenseManager.dentroDeGracia(this)) {
                    entrar()
                } else {
                    mostrarBloqueo("No se pudo validar la licencia. Conéctate a internet e intenta de nuevo.", true)
                }
            }
        }
    }

    private fun entrar() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("clave_licencia", LicenseManager.obtenerClave(this))
        startActivity(intent)
        finish()
    }

    // ---------- Construcción de pantallas (nativas, sin WebView) ----------

    private fun dp(v: Int) = (v * resources.displayMetrics.density).toInt()

    private fun contenedorBase(): LinearLayout {
        val root = LinearLayout(this)
        root.orientation = LinearLayout.VERTICAL
        root.setBackgroundColor(asfalto)
        root.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        root.gravity = Gravity.CENTER
        root.setPadding(dp(28), dp(28), dp(28), dp(28))
        return root
    }

    private fun titulo(texto: String): TextView {
        val t = TextView(this)
        t.text = texto
        t.setTextColor(tinta)
        t.textSize = 22f
        t.setTypeface(t.typeface, Typeface.BOLD)
        t.gravity = Gravity.CENTER
        return t
    }

    private fun cuerpo(texto: String): TextView {
        val t = TextView(this)
        t.text = texto
        t.setTextColor(tinta2)
        t.textSize = 14f
        t.gravity = Gravity.CENTER
        val lp = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        lp.topMargin = dp(10)
        lp.bottomMargin = dp(10)
        t.layoutParams = lp
        return t
    }

    private fun espaciador(alturaDp: Int): View {
        val v = View(this)
        v.layoutParams = LinearLayout.LayoutParams(0, dp(alturaDp))
        return v
    }

    private fun mostrarCargando() {
        val root = contenedorBase()
        root.addView(ProgressBar(this))
        root.addView(espaciador(14))
        root.addView(cuerpo("Verificando licencia…"))
        setContentView(root)
    }

    private fun mostrarActivacion(error: String?) {
        val root = contenedorBase()
        root.addView(titulo("Activar Parqueadero"))
        root.addView(cuerpo("Ingresa la clave de licencia que te entregó el desarrollador."))

        val input = EditText(this)
        input.hint = "PQ-XXXXXXXX"
        input.setTextColor(tinta)
        input.setHintTextColor(tinta2)
        input.setBackgroundColor(panel)
        input.setPadding(dp(14), dp(14), dp(14), dp(14))
        input.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS
        input.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        root.addView(input)
        root.addView(espaciador(14))

        if (error != null) {
            val e = cuerpo(error)
            e.setTextColor(rojo)
            root.addView(e)
        }

        val activar = Button(this)
        activar.text = "Activar"
        activar.setBackgroundColor(ambar)
        activar.setTextColor(asfalto)
        activar.setOnClickListener {
            val clave = input.text.toString().trim().uppercase()
            if (clave.isBlank()) return@setOnClickListener
            mostrarCargando()
            LicenseManager.verificar(clave, LicenseManager.deviceId(this)) { resultado ->
                runOnUiThread {
                    if (resultado != null) {
                        LicenseManager.guardarResultado(this, resultado)
                        if (resultado.valido) {
                            LicenseManager.guardarClave(this, clave)
                            entrar()
                        } else {
                            mostrarActivacion(resultado.mensaje)
                        }
                    } else {
                        mostrarActivacion("No se pudo conectar. Verifica tu internet e intenta de nuevo.")
                    }
                }
            }
        }
        root.addView(activar)
        setContentView(root)
    }

    private fun mostrarBloqueo(mensaje: String, esProblemaDeConexion: Boolean) {
        val root = contenedorBase()
        root.addView(titulo(if (esProblemaDeConexion) "Sin conexión" else "Acceso bloqueado"))
        val m = cuerpo(mensaje)
        m.setTextColor(if (esProblemaDeConexion) tinta2 else rojo)
        root.addView(m)
        root.addView(espaciador(14))

        val reintentar = Button(this)
        reintentar.text = "Reintentar"
        reintentar.setBackgroundColor(panel)
        reintentar.setTextColor(tinta)
        reintentar.setOnClickListener {
            val clave = LicenseManager.obtenerClave(this)
            if (clave.isNullOrBlank()) mostrarActivacion(null) else {
                mostrarCargando()
                validar(clave)
            }
        }
        root.addView(reintentar)
        root.addView(espaciador(10))

        if (!esProblemaDeConexion) {
            val whats = Button(this)
            whats.text = "Contactar por WhatsApp"
            whats.setBackgroundColor(verde)
            whats.setTextColor(verdeTexto)
            whats.setOnClickListener {
                val texto = "Hola, mi licencia de Parqueadero está bloqueada ($mensaje). Quiero renovarla."
                val uri = Uri.parse("https://wa.me/$whatsappSoporte?text=${Uri.encode(texto)}")
                startActivity(Intent(Intent.ACTION_VIEW, uri))
            }
            root.addView(whats)
        }
        setContentView(root)
    }
}
