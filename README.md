# Salni - Android Kotlin App with Google Sign-In

An Android application built with Kotlin that provides Google account authentication functionality.

## Features

- ✅ Google Sign-In integration
- ✅ Firebase Authentication
- ✅ Modern Android development practices
- ✅ Clean architecture with proper error handling
- ✅ Material Design UI

## Project Structure

```
app/
├── src/main/
│   ├── java/com/mhrlive/salni/
│   │   ├── LoginActivity.kt      # Google Sign-In implementation
│   │   └── MainActivity.kt       # Main app screen after login
│   ├── res/
│   │   ├── layout/
│   │   │   ├── activity_login.xml    # Login screen UI
│   │   │   └── activity_main.xml     # Main screen UI
│   │   ├── values/
│   │   │   ├── strings.xml       # App strings and configuration
│   │   │   ├── colors.xml        # Color definitions
│   │   │   └── themes.xml        # Material Design themes
│   │   └── drawable/             # App icons and graphics
│   └── AndroidManifest.xml       # App permissions and activities
├── build.gradle                  # App-level dependencies
└── google-services.json          # Firebase configuration
```

## Setup Instructions

### 1. Firebase Configuration

1. Go to [Firebase Console](https://console.firebase.google.com/)
2. Create a new project or select existing one
3. Add an Android app with package name: `com.mhrlive.salni`
4. Download the `google-services.json` file
5. Replace the placeholder file at `app/google-services.json`

### 2. Google Sign-In Configuration

1. In Firebase Console, go to Authentication > Sign-in method
2. Enable Google sign-in provider
3. Configure OAuth consent screen
4. Get the Web client ID from Firebase settings
5. Update `default_web_client_id` in `app/src/main/res/values/strings.xml`

### 3. Build and Run

```bash
# Install dependencies and build
./gradlew build

# Run on connected device/emulator
./gradlew installDebug
```

## Key Components

### LoginActivity
- Implements Google Sign-In flow
- Handles Firebase authentication
- Provides user feedback during login process
- Navigates to MainActivity on successful login

### MainActivity
- Displays user information after login
- Shows profile picture, name, email, and user ID
- Provides sign-out functionality
- Returns to LoginActivity when signed out

## Dependencies

- **Firebase Authentication**: User authentication
- **Google Play Services Auth**: Google Sign-In
- **Material Design Components**: Modern UI
- **View Binding**: Type-safe view references
- **Kotlin Coroutines**: Asynchronous programming

## Security Considerations

- The app uses Firebase Authentication for secure user management
- Google Sign-In provides OAuth 2.0 authentication
- User tokens are managed automatically by Firebase
- No sensitive data is stored locally

## Next Steps

1. Replace placeholder `google-services.json` with actual Firebase configuration
2. Update Web client ID in strings.xml
3. Add app icon and customize branding
4. Implement additional features as needed
5. Test on physical devices
6. Configure release build signing

## License

This project is created for demonstration purposes.