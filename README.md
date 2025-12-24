# Phone Cleaner Pro

Phone Cleaner Pro is an Android application designed to help users optimize their device's performance by cleaning junk files, boosting memory, and providing system insights.

## Features

- **Junk File Cleaner**: Scan and remove cache files, residual data, APK files, empty folders, and thumbnails.
- **Memory Booster**: Boost RAM by closing background processes.
- **Duplicate File Finder**: Identify and remove duplicate files.
- **Large File Scanner**: Find and manage large files.
- **Battery and Storage Dashboard**: Monitor battery health and storage usage.
- **App Manager**: View and manage installed applications.
- **Onboarding Experience**: Guided setup for new users.
- **Ad Integration**: Monetization through interstitial ads.

## Architecture

The app follows Clean Architecture principles with MVVM pattern:

- **Presentation Layer**: Activities, Fragments, ViewModels, and Adapters.
- **Domain Layer**: Use Cases and Business Logic.
- **Data Layer**: Repositories, Room Database, and Remote Services.

### Technologies Used

- **Kotlin**: Primary programming language.
- **Android Jetpack**: ViewModel, LiveData, Navigation, Room, WorkManager.
- **Hilt**: Dependency Injection.
- **Coroutines**: Asynchronous programming.
- **MPAndroidChart**: For displaying charts.
- **Lottie**: Animations.
- **AdMob**: Advertising.

## Setup Instructions

1. Clone the repository:
   ```
   git clone https://github.com/your-repo/phone-cleaner.git
   cd phone-cleaner
   ```

2. Open the project in Android Studio.

3. Ensure you have the Android SDK installed.

4. Build and run the app on an emulator or device.

### Requirements

- Android Studio Arctic Fox or later.
- Minimum SDK: 24 (Android 7.0)
- Target SDK: 34 (Android 14)

## Building and Running

- To build the project: `./gradlew build`
- To run unit tests: `./gradlew test`
- To run instrumentation tests: `./gradlew connectedAndroidTest`
- To install on device: `./gradlew installDebug`

## Contributing

1. Fork the repository.
2. Create a feature branch.
3. Make your changes.
4. Run tests.
5. Submit a pull request.

## License

This project is licensed under the MIT License.