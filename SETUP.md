# Firebase and Google Sign-In Setup Guide

This guide walks you through setting up Firebase and Google Sign-In for the Salni Android app.

## Step 1: Create Firebase Project

1. Visit [Firebase Console](https://console.firebase.google.com/)
2. Click "Create a project" or "Add project"
3. Enter project name: `salni-app` (or your preferred name)
4. Enable Google Analytics (optional)
5. Click "Create project"

## Step 2: Add Android App to Firebase

1. In Firebase Console, click "Add app" and select Android
2. Register app with these details:
   - **Android package name**: `com.mhrlive.salni`
   - **App nickname**: `Salni` (optional)
   - **Debug signing certificate SHA-1**: (optional for development)

3. Download `google-services.json`
4. Replace the placeholder file at `app/google-services.json` with the downloaded file

## Step 3: Enable Authentication

1. In Firebase Console, go to "Authentication" in the left sidebar
2. Click "Get started" if this is your first time
3. Go to "Sign-in method" tab
4. Find "Google" provider and click on it
5. Toggle "Enable" switch
6. Configure OAuth consent screen:
   - **Project support email**: Your email
   - **App name**: Salni
   - **Developer email**: Your email
7. Save the configuration

## Step 4: Get Web Client ID

1. In Firebase Console, go to "Project settings" (gear icon)
2. Select your Android app
3. Scroll down to find "Web client ID" in the configuration
4. Copy this ID (format: `xxxx.apps.googleusercontent.com`)

## Step 5: Update App Configuration

1. Open `app/src/main/res/values/strings.xml`
2. Find this line:
   ```xml
   <string name="default_web_client_id">123456789-zyxwvutsrqponmlkjihgfedcba.apps.googleusercontent.com</string>
   ```
3. Replace the placeholder with your actual Web client ID from Step 4

## Step 6: Build and Test

1. Connect Android device or start emulator
2. Build and install the app:
   ```bash
   ./gradlew installDebug
   ```
3. Launch the app and test Google Sign-In

## Troubleshooting

### Common Issues

1. **"Sign-in failed"**: Check that Web client ID is correct
2. **"App not authorized"**: Ensure package name matches Firebase configuration
3. **"Network error"**: Check internet connection and Firebase configuration

### Debug Steps

1. Check Firebase Console logs
2. Verify `google-services.json` is in the correct location
3. Ensure all dependencies are properly synced
4. Check that Google Sign-In is enabled in Firebase Console

### SHA-1 Certificate (Production)

For production releases, you'll need to add SHA-1 fingerprint:

1. Generate SHA-1 fingerprint:
   ```bash
   keytool -list -v -keystore ~/.android/debug.keystore -alias androiddebugkey -storepass android -keypass android
   ```
2. Copy SHA-1 fingerprint
3. In Firebase Console, go to Project Settings > Your App
4. Add the SHA-1 fingerprint
5. Download updated `google-services.json`

## Security Notes

- Never commit actual `google-services.json` to public repositories
- Use different Firebase projects for development and production
- Regularly review authentication logs in Firebase Console
- Keep dependencies updated for security patches