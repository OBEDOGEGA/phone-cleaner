# Smart Cleaner Pro App - Complete Architecture Specification

## Overview
Smart Cleaner Pro is an Android application designed to optimize phone performance through comprehensive cleaning, memory boosting, and system analysis features. The app follows MVVM architecture with clean separation of concerns, utilizing modern Android development practices including Hilt for dependency injection, Room for data persistence, and AdMob for monetization.

## Architecture Overview

### MVVM Architecture Layers

#### 1. Data Layer
**Purpose**: Handles data persistence, remote services, and business logic implementation.

**Components**:
- **Local Data**:
  - `PhoneCleanerDatabase`: Room database with entities for cleaning history, user preferences, whitelisted apps, and ad impressions
  - `CleaningHistoryDao`, `UserPreferenceDao`, `WhitelistedAppDao`, `AdImpressionDao`: Data access objects
- **Remote Data**:
  - `AdManager`: Comprehensive ad management with retry logic, frequency capping, and multiple ad formats
  - `ConsentManager`: GDPR compliance with UMP SDK
  - `AppOpenAdManager`: Lifecycle-aware app open ads
- **Repository Layer**:
  - `CleanRepositoryImpl`: Implements junk file scanning and cleaning operations
  - `BoostRepositoryImpl`: Memory optimization operations
  - `AnalyzeRepositoryImpl`: App analysis functionality
- **Workers**:
  - `MemoryBoostWorker`: Background memory optimization tasks

#### 2. Domain Layer
**Purpose**: Contains business logic and use case implementations.

**Components**:
- **Models**:
  - `JunkItem`: Represents cleanable files with metadata
  - `AppInfo`: Application information for app manager
  - `RunningApp`: Active application data
  - `DuplicateFile`, `LargeFile`: Specialized file types
- **Repository Interfaces**:
  - `ICleanRepository`, `IBoostRepository`, `IAnalyzeRepository`: Define data operations contracts
- **Use Cases**:
  - `CleanUseCaseImpl`: Orchestrates cleaning operations
  - `BoostUseCaseImpl`: Memory boost operations
  - `AnalyzeUseCaseImpl`: App analysis operations

#### 3. Presentation Layer
**Purpose**: Handles UI logic and user interactions.

**Components**:
- **Activities**:
  - `MainActivity`: Main app container with bottom navigation and ad integration
  - `OnboardingActivity`: User onboarding flow
- **Fragments**:
  - **Dashboard**: System overview (battery, storage, performance metrics)
  - **Cleaner Flow**: `ScanFragment` → `ResultsFragment` → `CleanFragment` → `SummaryFragment`
  - **Memory Booster**: Running app management and memory optimization
  - **Tools**: Duplicate finder, large file scanner
  - **App Manager**: Installed app analysis and management
  - **Settings**: User preferences and configuration
- **ViewModels**:
  - `DashboardViewModel`: System metrics and stats
  - `CleanerViewModel`: Cleaning workflow state management
  - `MemoryBoosterViewModel`: RAM optimization
  - `ToolsViewModel`: File analysis operations
  - `AppManagerViewModel`: App management operations
- **Adapters**: RecyclerView adapters for displaying lists (apps, files, results)

## Data Flow Architecture

### Cleaning Flow
1. **Scan Phase**: `ScanFragment` → `CleanerViewModel.startScanning()` → `CleanUseCase.scanForJunk()` → `CleanRepository.scanForJunk()`
2. **Results Phase**: Display scanned junk items with selection UI
3. **Clean Phase**: `CleanFragment` → `CleanerViewModel.startCleaning()` → `CleanUseCase.cleanJunk()` → `CleanRepository.cleanJunk()`
4. **Summary Phase**: Display cleaning results and save to `CleaningHistory`

### Memory Boost Flow
1. **Analysis**: Scan running processes and memory usage
2. **Optimization**: Kill background processes and clear memory
3. **Results**: Display freed memory and performance improvements

### Ad Integration Points

#### AdManager Architecture
- **Ad Types Supported**:
  - Banner Ads: Persistent bottom banner with refresh
  - Interstitial Ads: Full-screen ads with frequency capping (3/session, 3min cooldown)
  - Rewarded Ads: User-opt-in ads for feature unlocks
  - Rewarded Interstitial Ads: Alternative rewarded format
  - Native Ads: In-feed content ads
  - App Open Ads: Launch screen ads with lifecycle management

- **Key Features**:
  - Retry logic with exponential backoff (max 3 retries)
  - Ad impression tracking in local database
  - Consent management integration
  - Feature unlock callbacks

#### Feature Unlock System
- **Premium Features**:
  - Deep Clean: Advanced cleaning algorithms
  - Duplicate Photo Finder: Image deduplication
  - Privacy Eraser Pro: Advanced data cleanup
  - Custom Themes: UI customization
  - Cloud Backup: Data synchronization

- **Unlock Mechanism**:
  - 24-hour temporary unlocks via rewarded ads
  - SharedPreferences-based expiration tracking
  - Analytics integration for usage tracking

## Database Schema Design

### Room Entities

```kotlin
@Entity(tableName = "cleaning_history")
data class CleaningHistory(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val timestamp: Long,
    val cleanedSize: Long,
    val cleanedItems: Int,
    val duration: Long
)

@Entity(tableName = "user_preference")
data class UserPreference(
    @PrimaryKey val key: String,
    val value: String
)

@Entity(tableName = "whitelisted_app")
data class WhitelistedApp(
    @PrimaryKey val packageName: String,
    val appName: String,
    val isWhitelisted: Boolean = false
)

@Entity(tableName = "ad_impression")
data class AdImpression(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val adId: String,
    val timestamp: Long,
    val impressionType: String
)
```

## Core Features Implementation Plan

### 1. System Dashboard
- **Battery Monitoring**: Real-time battery level and health status
- **Storage Analysis**: Used/total storage calculation
- **Performance Metrics**: Mock weekly performance indicators
- **Quick Actions**: One-tap access to main features

### 2. Smart Cleaning System
- **Multi-Category Scanning**:
  - Cache files from apps and system
  - Residual/temp files (.temp, .log, .cache, .tmp, .bak)
  - APK installation files
  - Empty directory cleanup
  - Thumbnail cache clearing
- **Selective Cleaning**: User choice of items to clean
- **Progress Tracking**: Real-time cleaning progress with animations
- **History Tracking**: Cleaning session persistence

### 3. Memory Booster
- **Process Analysis**: Running app enumeration with memory usage
- **Smart Killing**: Background process termination (excluding system/whitelisted apps)
- **Memory Metrics**: Before/after RAM statistics
- **Scheduled Boosting**: WorkManager-based background optimization

### 4. Advanced Tools
- **Duplicate File Finder**: MD5-based file deduplication
- **Large File Scanner**: Size-based file identification
- **App Manager**: Installed app analysis with size/permission details
- **Privacy Tools**: Browser history, call logs, SMS cleanup (premium)

### 5. Ad Monetization Strategy
- **Banner Ads**: Main screen persistent monetization
- **Interstitial Ads**: Feature transitions (every 3 tabs)
- **Rewarded Ads**: Premium feature unlocks
- **Native Ads**: Integrated content in results lists
- **App Open Ads**: Session start monetization

## Component Specifications

### ViewModel Specifications
Each ViewModel follows consistent patterns:
- LiveData/StateFlow for UI state management
- Coroutine-based async operations
- Error handling with try/catch blocks
- Resource cleanup in `onCleared()`

### Repository Specifications
- Interface-based design for testability
- Flow-based reactive data streams
- IO dispatcher for disk operations
- Comprehensive error handling

### Fragment Specifications
- ViewBinding for type-safe view access
- Lifecycle-aware observer registration
- Navigation component integration
- Permission handling with modern APIs

### Dependency Injection
- Hilt modules for each layer (RepositoryModule, ViewModelModule)
- Singleton scope for shared services (AdManager, Database)
- ViewModel scope for UI-specific dependencies

## Missing Components & Implementation Gaps

### Identified Gaps
1. **Battery Optimization**: Currently only monitoring, no active optimization
2. **Deep Clean Algorithm**: Basic file scanning, needs advanced pattern recognition
3. **Duplicate Detection**: Framework exists but implementation may be incomplete
4. **Cloud Backup**: UI placeholders but no backend integration
5. **Analytics Integration**: Logging framework but no real analytics service
6. **Push Notifications**: No notification system for scheduled cleanings
7. **Widget Support**: No home screen widgets for quick actions

### Recommended Additions
1. **Advanced Scanning**: Machine learning-based junk detection
2. **Scheduled Tasks**: Automated cleaning at specified intervals
3. **Backup/Restore**: Local and cloud data management
4. **Security Scanner**: Malware detection and privacy analysis
5. **Performance Monitoring**: Real-time CPU/memory graphs
6. **Theme System**: Dark/light mode with custom themes
7. **Multi-language**: Localization support

## Technical Considerations

### Performance Optimization
- Background scanning with progress updates
- Memory-efficient file scanning with pagination
- Database optimization with indexes and transactions
- Ad loading optimization with pre-caching

### Security & Privacy
- Runtime permissions for storage access
- GDPR compliance with consent management
- Secure ad impression tracking
- No sensitive data collection

### Testing Strategy
- Unit tests for ViewModels and Use Cases
- Integration tests for Repository layer
- UI tests for critical user flows
- Mock implementations for external services

### Maintenance & Scalability
- Modular architecture for feature additions
- Interface-based design for easy mocking
- Comprehensive logging for debugging
- Code documentation and architecture diagrams

## Implementation Roadmap

### Phase 1: Core Features Completion
- Complete duplicate file finder implementation
- Implement battery optimization features
- Add scheduled cleaning functionality
- Enhance app manager with more details

### Phase 2: Advanced Features
- Implement deep clean algorithms
- Add cloud backup integration
- Develop security scanner
- Create home screen widgets

### Phase 3: Monetization & Analytics
- Optimize ad placements and frequency
- Implement comprehensive analytics
- Add A/B testing framework
- Develop user engagement features

### Phase 4: Polish & Performance
- Performance profiling and optimization
- UI/UX improvements based on user feedback
- Comprehensive testing coverage
- App store optimization

This architecture provides a solid foundation for a professional phone cleaning application with room for expansion and monetization opportunities.