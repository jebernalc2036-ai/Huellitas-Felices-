package com.huellitasfelices.parqueadero

import android.content.Context
import android.provider.Settings
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

data class ResultadoLicencia(
    val valido: Boolean,
    val estado: String,
    val vence: String?,
    val diasGracia: Int,
    val mensaje: String
)

object LicenseManager {
    private const val PREFS = "licencia_prefs"
    private const val K_CLAVE = "clave"
    private const val K_ESTADO = "estado"
    private const val K_MENSAJE = "mensaje"
    private const val K_DIAS_GRACIA = "dias_gracia"
    private const val K_ULTIMA_VALIDACION = "ultima_validacion"
    private const val K_ULTIMO_VALIDO = "ultimo_valido"

    private fun prefs(ctx: Context) = ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE)

    fun deviceId(ctx: Context): String =
        Settings.Secure.getString(ctx.contentResolver, Settings.Secure.ANDROID_ID) ?: "desconocido"

    fun obtenerClave(ctx: Context): String? = prefs(ctx).getString(K_CLAVE, null)

    fun guardarClave(ctx: Context, clave: String) {
        prefs(ctx).edit().putString(K_CLAVE, clave).apply()
    }

    fun guardarResultado(ctx: Context, r: ResultadoLicencia) {
        prefs(ctx).edit()
            .putString(K_ESTADO, r.estado)
            .putString(K_MENSAJE, r.mensaje)
            .putInt(K_DIAS_GRACIA, r.diasGracia)
            .putLong(K_ULTIMA_VALIDACION, System.currentTimeMillis())
            .putBoolean(K_ULTIMO_VALIDO, r.valido)
            .apply()
    }

    fun dentroDeGracia(ctx: Context): Boolean {
        val p = prefs(ctx)
        if (!p.getBoolean(K_ULTIMO_VALIDO, false)) return false
        val ultima = p.getLong(K_ULTIMA_VALIDACION, 0L)
        if (ultima == 0L) return false
        val diasGracia = p.getInt(K_DIAS_GRACIA, 5)
        val limite = ultima + diasGracia * 24L * 60 * 60 * 1000
        return System.currentTimeMillis() < limite
    }

    fun verificar(clave: String, deviceId: String, callback: (ResultadoLicencia?) -> Unit) {
        Thread {
            var conexion: HttpURLConnection? = null
            try {
                val url = URL("${BuildConfig.SUPABASE_URL}/rest/v1/rpc/verificar_licencia")
                val conn = url.openConnection() as HttpURLConnection
                conexion = conn
                conn.requestMethod = "POST"
                conn.doOutput = true
                conn.connectTimeout = 6000
                conn.readTimeout = 6000
                conn.setRequestProperty("Content-Type", "application/json")
                conn.setRequestProperty("apikey", BuildConfig.SUPABASE_ANON_KEY)
                conn.setRequestProperty("Authorization", "Bearer ${BuildConfig.SUPABASE_ANON_KEY}")

                val cuerpo = JSONObject().put("p_clave", clave).put("p_device", deviceId).toString()
                OutputStreamWriter(conn.outputStream).use { it.write(cuerpo) }

                val codigo = conn.responseCode
                if (codigo !in 200..299) {
                    callback(null)
                    return@Thread
                }
                val texto = BufferedReader(InputStreamReader(conn.inputStream)).use { it.readText() }
                val json = JSONObject(texto)
                callback(
                    ResultadoLicencia(
                        valido = json.optBoolean("valido", false),
                        estado = json.optString("estado", "desconocido"),
                        vence = if (json.isNull("vence")) null else json.optString("vence"),
                        diasGracia = json.optInt("dias_gracia", 5),
                        mensaje = json.optString("mensaje", "")
                    )
                )
            } catch (e: Exception) {
                callback(null)
            } finally {
                conexion?.disconnect()
            }
        }.start()
    }
}
