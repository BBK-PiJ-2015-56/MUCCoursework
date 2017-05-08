# MUCCoursework
This is the MUC 16/17 coursework for Peter Domokos

The Github url is: https://github.com/BBK-PiJ-2015-56/MUCCoursework

Comments:
 - The instrumented unit testing is incomplete, as I ran into many problems with understanding how to use contexts appropriately. I have not therefore impmeneted the MainActivityTest class that I created.

 -Firebase output: - see folder Firebase screenshots
                   - the gaps in seconds are when I have paused the app then resumed it, as I set it so it will only send it when it is receiving location updates. 
                   

 Circl CI output:
1. SEE APKs fo debug build and xml file for unit tests in CircleCI artifactsfolder
2. SEE screenshots in circle ci screenshots folder
3. SEE copies of artifacts below(TEST ARTIFACTS, BUILD ARTIFACTS, TEST BUILD ARTIFACTS)

TEST ARTIFACTS
<testsuite name="peterdomokos.muccoursework.FirebaseCommunicatorTest" tests="6" failures="0" errors="0" skipped="0" time="10.398" timestamp="2017-05-08T14:41:49" hostname="localhost">
<properties>
<property name="device" value="circleci-android22(AVD) - 5.1.1"/>
<property name="flavor" value=""/>
<property name="project" value="app"/>
</properties>
<testcase name="formatLocationForFirebaseGivesLongLatAndFloorString" classname="peterdomokos.muccoursework.FirebaseCommunicatorTest" time="0.328"/>
<testcase name="formatLocationForFirebaseGivesDefaultMessageWhenNull" classname="peterdomokos.muccoursework.FirebaseCommunicatorTest" time="0.0"/>
<testcase name="isWithinRangeReturnsTrueWhenDistanceLessThanRange" classname="peterdomokos.muccoursework.IADistanceComparatorTest" time="0.0"/>
<testcase name="isWithinRangeReturnsFalseWhenDistanceis3" classname="peterdomokos.muccoursework.IADistanceComparatorTest" time="0.126"/>
<testcase name="isWithinRangeReturnsFalseWhenDistanceGreaterThan3" classname="peterdomokos.muccoursework.IADistanceComparatorTest" time="0.0"/>
<testcase name="testOnRequestPermissionsResultReturnsGrantedToast" classname="peterdomokos.muccoursework.MainActivityTest" time="8.867"/>
</testsuite>

BUILD ARTIFACTS
Collecting 8 build artifacts
Unknown option: no-notice
Unknown option: no-notice
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed

100   304    0     0  100   304      0   6036 --:--:-- --:--:-- --:--:--  6080
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed

100   779    0     0  100   779      0   9767 --:--:-- --:--:-- --:--:--  9860
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed

100 1099k    0     0  100 1099k      0  11.5M --:--:-- --:--:-- --:--:-- 11.6M
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed

100 1099k    0     0  100 1099k      0  6704k --:--:-- --:--:-- --:--:-- 6744k
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed

100 6196k    0     0  100 6196k      0  22.7M --:--:-- --:--:-- --:--:-- 22.7M
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed

100 5663k    0     0  100 5663k      0  19.1M --:--:-- --:--:-- --:--:-- 19.2M
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed

100 6196k    0     0  100 6196k      0  16.4M --:--:-- --:--:-- --:--:-- 16.4M
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed

100 5663k    0     0  100 5663k      0  15.1M --:--:-- --:--:-- --:--:-- 15.1M


8 artifacts uploaded.

(./gradlew assemble)
To honour the JVM settings for this build a new JVM will be forked. Please consider using the daemon: https://docs.gradle.org/2.14.1/userguide/gradle_daemon.html.
> Loading> Loading > settings> Loading> Configuring> Configuring > 0/2 projects> Configuring > 0/2 projects > root project> Configuring > 0/2 projects > root project > Resolving dependencies ':classpat> Configuring > 0/2 projects > root project> Configuring > 0/2 projects> Configuring > 1/2 projects > :app> Configuring > 1/2 projects > :app > Resolving dependencies ':app:classpath'> Configuring > 1/2 projects > :app> Configuring > 1/2 projects> Configuring > 2/2 projects> Configuring > 2/2 projects > Resolving dependencies ':app:_debugApk'> Configuring > 2/2 projectsIncremental java compilation is an incubating feature.
> Configuring > 2/2 projects> Configuring > 2/2 projects > Resolving dependencies ':app:_debugUnitTestApk'> Configuring > 2/2 projects> Configuring > 2/2 projects > Resolving dependencies ':app:releaseWearApp'> Configuring > 2/2 projects> Configuring > 2/2 projects > Resolving dependencies ':app:_debugAndroidTestAp> Configuring > 2/2 projects> Configuring:app:preBuild UP-TO-DATE
> Building 1% > :app:preDebugBuild:app:preDebugBuild UP-TO-DATE
:app:checkDebugManifest
:app:preReleaseBuild UP-TO-DATE
> Building 4% > :app:prepareComAndroidSupportAnimatedVectorDrawable2531Library:app:prepareComAndroidSupportAnimatedVectorDrawable2531Library
> Building 4%> Building 6% > :app:prepareComAndroidSupportAppcompatV72531Library:app:prepareComAndroidSupportAppcompatV72531Library
> Building 6%> Building 7% > :app:prepareComAndroidSupportDesign2531Library:app:prepareComAndroidSupportDesign2531Library
:app:prepareComAndroidSupportRecyclerviewV72531Library
:app:prepareComAndroidSupportSupportCompat2531Library
> Building 10% > :app:prepareComAndroidSupportSupportCoreUi2531Library:app:prepareComAndroidSupportSupportCoreUi2531Library
:app:prepareComAndroidSupportSupportCoreUtils2531Library
:app:prepareComAndroidSupportSupportFragment2531Library
:app:prepareComAndroidSupportSupportMediaCompat2531Library
:app:prepareComAndroidSupportSupportV42531Library
> Building 17% > :app:prepareComAndroidSupportSupportVectorDrawable2531Library:app:prepareComAndroidSupportSupportVectorDrawable2531Library
:app:prepareComAndroidSupportTransition2531Library
> Building 19% > :app:prepareComGoogleAndroidGmsPlayServicesBasement1024Library:app:prepareComGoogleAndroidGmsPlayServicesBasement1024Library
:app:prepareComGoogleAndroidGmsPlayServicesTasks1024Library
:app:prepareComGoogleFirebaseFirebaseAnalytics1024Library
:app:prepareComGoogleFirebaseFirebaseAnalyticsImpl1024Library
:app:prepareComGoogleFirebaseFirebaseCommon1024Library
:app:prepareComGoogleFirebaseFirebaseCore1024Library
:app:prepareComGoogleFirebaseFirebaseDatabase1024Library
> Building 28%:app:prepareComGoogleFirebaseFirebaseDatabaseConnection1024Library
:app:prepareComGoogleFirebaseFirebaseIid1024Library
> Building 30% > :app:prepareComIndooratlasAndroidIndooratlasAndroidSdk241Libra:app:prepareComIndooratlasAndroidIndooratlasAndroidSdk241Library
> Building 30%:app:prepareDebugDependencies
:app:compileDebugAidl
:app:compileDebugRenderscript
> Building 35% > :app:generateDebugBuildConfig:app:generateDebugBuildConfig
> Building 35%:app:generateDebugResValues
:app:processDebugGoogleServices
Parsing json file: /home/ubuntu/MUCCoursework/app/google-services.json
> Building 37% > :app:processDebugGoogleServices:app:generateDebugResources
> Building 40% > :app:mergeDebugResources:app:mergeDebugResources
> Building 40%> Building 41% > :app:processDebugManifest:app:processDebugManifest
> Building 41%> Building 42% > :app:processDebugResources:app:processDebugResources
> Building 42%:app:generateDebugSources
:app:incrementalDebugJavaCompilationSafeguard
:app:compileDebugJavaWithJavac
:app:compileDebugJavaWithJavac - is not incremental (e.g. outputs have changed, no previous execution, etc.).
> Building 46% > :app:compileDebugJavaWithJavac> Building 46%:app:compileDebugNdk UP-TO-DATE
:app:compileDebugSources
:app:mergeDebugShaders
:app:compileDebugShaders
:app:generateDebugAssets
> Building 53% > :app:mergeDebugAssets:app:mergeDebugAssets
> Building 54% > :app:transformClassesWithDexForDebug:app:transformClassesWithDexForDebug
> Building 54%:app:mergeDebugJniLibFolders
> Building 57% > :app:transformNative_libsWithMergeJniLibsForDebug:app:transformNative_libsWithMergeJniLibsForDebug
> Building 57%:app:processDebugJavaRes UP-TO-DATE
> Building 59% > :app:transformResourcesWithMergeJavaResForDebug:app:transformResourcesWithMergeJavaResForDebug
> Building 59%> Building 60% > :app:validateSigningDebug:app:validateSigningDebug
> Building 60%> Building 62% > :app:packageDebug:app:packageDebug
> Building 62%:app:assembleDebug
:app:checkReleaseManifest
:app:prepareReleaseDependencies
:app:compileReleaseAidl
:app:compileReleaseRenderscript
> Building 69% > :app:generateReleaseBuildConfig:app:generateReleaseBuildConfig
:app:generateReleaseResValues
:app:processReleaseGoogleServices
Parsing json file: /home/ubuntu/MUCCoursework/app/google-services.json
:app:generateReleaseResources
> Building 74% > :app:mergeReleaseResources:app:mergeReleaseResources
> Building 74%> Building 75% > :app:processReleaseManifest:app:processReleaseManifest
> Building 75%> Building 76% > :app:processReleaseResources:app:processReleaseResources
> Building 76%:app:generateReleaseSources
:app:incrementalReleaseJavaCompilationSafeguard
:app:compileReleaseJavaWithJavac
:app:compileReleaseJavaWithJavac - is not incremental (e.g. outputs have changed, no previous execution, etc.).
> Building 80% > :app:compileReleaseJavaWithJavac> Building 80%:app:compileReleaseNdk UP-TO-DATE
:app:compileReleaseSources
> Building 84% > :app:lintVitalRelease:app:lintVitalRelease
> Building 84%:app:mergeReleaseShaders
:app:compileReleaseShaders
:app:generateReleaseAssets
:app:mergeReleaseAssets
> Building 90% > :app:transformClassesWithDexForRelease:app:transformClassesWithDexForRelease
> Building 90%:app:mergeReleaseJniLibFolders
> Building 92% > :app:transformNative_libsWithMergeJniLibsForRelease:app:transformNative_libsWithMergeJniLibsForRelease
:app:processReleaseJavaRes UP-TO-DATE
> Building 95% > :app:transformResourcesWithMergeJavaResForRelease:app:transformResourcesWithMergeJavaResForRelease
> Building 96% > :app:packageRelease:app:packageRelease
> Building 96%:app:assembleRelease
:app:assemble

BUILD SUCCESSFUL

Total time: 1 mins 39.657 secs




TEST BUILD ARTIFACTS

./gradlew connectedAndroidTest
To honour the JVM settings for this build a new JVM will be forked. Please consider using the daemon: https://docs.gradle.org/2.14.1/userguide/gradle_daemon.html.
> Loading> Loading > settings> Loading> Configuring> Configuring > 0/2 projects> Configuring > 0/2 projects > root project> Configuring > 0/2 projects > root project > Resolving dependencies ':classpat> Configuring > 0/2 projects > root project> Configuring > 0/2 projects> Configuring > 1/2 projects > :app> Configuring > 1/2 projects > :app > Resolving dependencies ':app:classpath'> Configuring > 1/2 projects > :app> Configuring > 1/2 projects> Configuring > 2/2 projects> Configuring > 2/2 projects > Resolving dependencies ':app:_debugApk'> Configuring > 2/2 projects> Configuring > 2/2 projects > Resolving dependencies ':app:_debugCompile'> Configuring > 2/2 projects> Configuring > 2/2 projects > Resolving dependencies ':app:_releaseApk'> Configuring > 2/2 projects > Resolving dependencies ':app:_releaseCompile'> Configuring > 2/2 projectsIncremental java compilation is an incubating feature.
> Configuring > 2/2 projects> Configuring > 2/2 projects > Resolving dependencies ':app:_debugUnitTestApk'> Configuring > 2/2 projects> Configuring > 2/2 projects > Resolving dependencies ':app:releaseWearApp'> Configuring > 2/2 projects> Configuring > 2/2 projects > Resolving dependencies ':app:_debugAndroidTestAp> Configuring > 2/2 projects> Configuring> Building 0%> Building 0% > :app:preBuild:app:preBuild UP-TO-DATE
:app:preDebugBuild UP-TO-DATE
:app:checkDebugManifest
:app:preReleaseBuild UP-TO-DATE
> Building 4% > :app:prepareComAndroidSupportAnimatedVectorDrawable2531Library:app:prepareComAndroidSupportAnimatedVectorDrawable2531Library UP-TO-DATE
> Building 5% > :app:prepareComAndroidSupportAppcompatV72531Library:app:prepareComAndroidSupportAppcompatV72531Library UP-TO-DATE
> Building 5%:app:prepareComAndroidSupportDesign2531Library UP-TO-DATE
:app:prepareComAndroidSupportRecyclerviewV72531Library UP-TO-DATE
:app:prepareComAndroidSupportSupportCompat2531Library UP-TO-DATE
:app:prepareComAndroidSupportSupportCoreUi2531Library UP-TO-DATE
:app:prepareComAndroidSupportSupportCoreUtils2531Library UP-TO-DATE
:app:prepareComAndroidSupportSupportFragment2531Library UP-TO-DATE
:app:prepareComAndroidSupportSupportMediaCompat2531Library UP-TO-DATE
:app:prepareComAndroidSupportSupportV42531Library UP-TO-DATE
:app:prepareComAndroidSupportSupportVectorDrawable2531Library UP-TO-DATE
> Building 17% > :app:prepareComAndroidSupportTransition2531Library:app:prepareComAndroidSupportTransition2531Library UP-TO-DATE
:app:prepareComGoogleAndroidGmsPlayServicesBasement1024Library UP-TO-DATE
:app:prepareComGoogleAndroidGmsPlayServicesTasks1024Library UP-TO-DATE
:app:prepareComGoogleFirebaseFirebaseAnalytics1024Library UP-TO-DATE
> Building 21% > :app:prepareComGoogleFirebaseFirebaseAnalyticsImpl1024Library:app:prepareComGoogleFirebaseFirebaseAnalyticsImpl1024Library UP-TO-DATE
:app:prepareComGoogleFirebaseFirebaseCommon1024Library UP-TO-DATE
:app:prepareComGoogleFirebaseFirebaseCore1024Library UP-TO-DATE
:app:prepareComGoogleFirebaseFirebaseDatabase1024Library UP-TO-DATE
:app:prepareComGoogleFirebaseFirebaseDatabaseConnection1024Library UP-TO-DATE
:app:prepareComGoogleFirebaseFirebaseIid1024Library UP-TO-DATE
:app:prepareComIndooratlasAndroidIndooratlasAndroidSdk241Library UP-TO-DATE
:app:prepareDebugDependencies
> Building 31% > :app:compileDebugAidl:app:compileDebugAidl UP-TO-DATE
:app:compileDebugRenderscript UP-TO-DATE
> Building 33% > :app:generateDebugBuildConfig:app:generateDebugBuildConfig UP-TO-DATE
> Building 33%:app:generateDebugResValues UP-TO-DATE
:app:processDebugGoogleServices
Parsing json file: /home/ubuntu/MUCCoursework/app/google-services.json
:app:generateDebugResources
> Building 37% > :app:mergeDebugResources:app:mergeDebugResources UP-TO-DATE
> Building 37%> Building 39% > :app:processDebugManifest:app:processDebugManifest UP-TO-DATE
> Building 39%> Building 40% > :app:processDebugResources:app:processDebugResources UP-TO-DATE
:app:generateDebugSources UP-TO-DATE
:app:incrementalDebugJavaCompilationSafeguard UP-TO-DATE
> Building 43% > :app:compileDebugJavaWithJavac:app:compileDebugJavaWithJavac UP-TO-DATE
> Building 43%:app:compileDebugNdk UP-TO-DATE
:app:compileDebugSources UP-TO-DATE
:app:mergeDebugShaders UP-TO-DATE
:app:compileDebugShaders UP-TO-DATE
:app:generateDebugAssets UP-TO-DATE
> Building 50%:app:mergeDebugAssets UP-TO-DATE
> Building 51% > :app:transformClassesWithDexForDebug:app:transformClassesWithDexForDebug UP-TO-DATE
:app:mergeDebugJniLibFolders UP-TO-DATE
:app:transformNative_libsWithMergeJniLibsForDebug UP-TO-DATE
:app:processDebugJavaRes UP-TO-DATE
> Building 56% > :app:transformResourcesWithMergeJavaResForDebug:app:transformResourcesWithMergeJavaResForDebug UP-TO-DATE
:app:validateSigningDebug
> Building 58% > :app:packageDebug:app:packageDebug UP-TO-DATE
:app:assembleDebug UP-TO-DATE
:app:preDebugAndroidTestBuild UP-TO-DATE
> Building 62% > :app:prepareComAndroidSupportTestEspressoEspressoCore222Librar:app:prepareComAndroidSupportTestEspressoEspressoCore222Library
> Building 62%:app:prepareComAndroidSupportTestEspressoEspressoIdlingResource222Library
:app:prepareComAndroidSupportTestExposedInstrumentationApiPublish05Library
:app:prepareComAndroidSupportTestRules05Library
> Building 66% > :app:prepareComAndroidSupportTestRunner05Library:app:prepareComAndroidSupportTestRunner05Library
:app:prepareDebugAndroidTestDependencies
:app:compileDebugAndroidTestAidl
> Building 70% > :app:processDebugAndroidTestManifest:app:processDebugAndroidTestManifest
> Building 70%:app:compileDebugAndroidTestRenderscript
:app:generateDebugAndroidTestBuildConfig
:app:generateDebugAndroidTestResValues
:app:generateDebugAndroidTestResources
> Building 75% > :app:mergeDebugAndroidTestResources:app:mergeDebugAndroidTestResources
> Building 75%> Building 77% > :app:processDebugAndroidTestResources:app:processDebugAndroidTestResources
> Building 77%:app:generateDebugAndroidTestSources
:app:incrementalDebugAndroidTestJavaCompilationSafeguard
> Building 80% > :app:compileDebugAndroidTestJavaWithJavac:app:compileDebugAndroidTestJavaWithJavac
> Building 80%:app:compileDebugAndroidTestNdk UP-TO-DATE
:app:compileDebugAndroidTestSources
:app:mergeDebugAndroidTestShaders
:app:compileDebugAndroidTestShaders
:app:generateDebugAndroidTestAssets
:app:mergeDebugAndroidTestAssets
> Building 88% > :app:transformClassesWithDexForDebugAndroidTest:app:transformClassesWithDexForDebugAndroidTest
> Building 88%:app:mergeDebugAndroidTestJniLibFolders
> Building 90% > :app:transformNative_libsWithMergeJniLibsForDebugAndroidTest:app:transformNative_libsWithMergeJniLibsForDebugAndroidTest
:app:processDebugAndroidTestJavaRes UP-TO-DATE
> Building 93% > :app:transformResourcesWithMergeJavaResForDebugAndroidTest:app:transformResourcesWithMergeJavaResForDebugAndroidTest
> Building 93%:app:validateSigningDebugAndroidTest
> Building 95% > :app:packageDebugAndroidTest:app:packageDebugAndroidTest
> Building 95%:app:assembleDebugAndroidTest
> Building 97% > :app:connectedDebugAndroidTest:app:connectedDebugAndroidTest
> Building 97%:app:connectedAndroidTest

BUILD SUCCESSFUL

Total time: 4 mins 14.794 secs
