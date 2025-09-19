#!/bin/bash

# Build verification script for Salni Android app
# This script checks if the project structure is correct and dependencies are properly configured

echo "🔍 Salni App Build Verification"
echo "================================"

# Check if required files exist
echo "📁 Checking project structure..."

REQUIRED_FILES=(
    "app/build.gradle"
    "app/src/main/AndroidManifest.xml"
    "app/src/main/java/com/mhrlive/salni/LoginActivity.kt"
    "app/src/main/java/com/mhrlive/salni/MainActivity.kt"
    "app/src/main/res/layout/activity_login.xml"
    "app/src/main/res/layout/activity_main.xml"
    "app/src/main/res/values/strings.xml"
    "app/google-services.json"
)

for file in "${REQUIRED_FILES[@]}"; do
    if [ -f "$file" ]; then
        echo "✅ $file"
    else
        echo "❌ $file (missing)"
    fi
done

echo ""
echo "🔧 Configuration checks..."

# Check if default_web_client_id is configured
if grep -q "123456789-zyxwvutsrqponmlkjihgfedcba.apps.googleusercontent.com" app/src/main/res/values/strings.xml; then
    echo "⚠️  default_web_client_id is still using placeholder (needs Firebase configuration)"
else
    echo "✅ default_web_client_id appears to be configured"
fi

# Check if google-services.json contains placeholder data
if grep -q "salni-demo-project" app/google-services.json; then
    echo "⚠️  google-services.json is still using placeholder data (needs Firebase configuration)"
else
    echo "✅ google-services.json appears to be configured"
fi

echo ""
echo "📋 Next steps:"
echo "1. Follow SETUP.md to configure Firebase"
echo "2. Replace google-services.json with actual Firebase configuration"
echo "3. Update default_web_client_id in strings.xml"
echo "4. Run './gradlew build' to compile the app"
echo "5. Run './gradlew installDebug' to install on device/emulator"

echo ""
echo "📚 Documentation:"
echo "• README.md - Project overview and features"
echo "• SETUP.md - Detailed Firebase setup instructions"