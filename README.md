# TurboTube

Proyecto Android inicial de TurboTube.

## Qué hace
- Abre la aplicación oficial de YouTube si está instalada.
- Si no está instalada, abre YouTube en el navegador.
- Permite buscar vídeos en YouTube.

## Crear el APK
El repositorio incluye una acción de GitHub que compila un APK de depuración al subir cambios.

1. Abre la pestaña **Actions** del repositorio.
2. Si GitHub pide habilitar workflows, pulsa **I understand my workflows, go ahead and enable them**.
3. Espera a que termine **Build TurboTube APK**.
4. Abre la ejecución completada y descarga **TurboTube-debug-apk** en la sección **Artifacts**.
5. Descomprime el ZIP descargado y encontrarás `app-debug.apk`.

Este APK es de prueba. No está publicado en Google Play.

## Requisitos para compilar localmente
Android Studio y JDK 17.

## Limitaciones
- No reproduce vídeos dentro de Android Auto ni habilita vídeo mientras se conduce.
- No solicita ni almacena contraseñas de Google.
- El inicio de sesión, las recomendaciones y la reproducción se gestionan en YouTube oficial.
