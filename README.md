# CampUtter Android App

This project wraps the CampUtter prototype in a native Android WebView and bundles the website inside the APK.

## What was added for phones
- Native Android app shell
- Bottom navigation on small screens so every CampUtter tab remains reachable
- Full-screen responsive WebView
- JavaScript, DOM storage and external HTTPS map/routing requests enabled
- CampUtter launcher icon

## Build with Android Studio
1. Open this folder in Android Studio.
2. Allow Gradle sync to finish.
3. Choose **Build > Build App Bundle(s) / APK(s) > Build APK(s)**.
4. The debug APK appears under `app/build/outputs/apk/debug/app-debug.apk`.

## Build with GitHub Actions
The included `.github/workflows/build-apk.yml` builds an installable debug APK automatically and uploads it as the `CampUtter-APK` artifact.

## Presentation accounts
- 1093681 — Abdelrahman Mahmoud
- 1099242 — Salma Mahmoud
