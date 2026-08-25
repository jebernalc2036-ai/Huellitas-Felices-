# Los métodos que JavaScript llama en el WebView (window.AndroidDownload,
# window.AndroidShare, window.AndroidPagos) no se referencian desde código
# Kotlin/Java: R8 los vería como "no usados" y los eliminaría o renombraría,
# rompiendo la app en silencio. Esta regla los protege.
-keepclassmembers class * {
    @android.webkit.JavascriptInterface <methods>;
}

-keepattributes JavascriptInterface
-keepattributes *Annotation*
-keepattributes Signature
-keepattributes InnerClasses
-keepattributes EnclosingMethod
