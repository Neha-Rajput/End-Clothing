# End-Clothing

## Introduction
Here is the simple android application in kotlin which is showing the list of products via calling an simple network request and showing list data in recyclerview.


## Tools 

* Macbook Pro 15
* Android Studio (version 4.2).
* If kotlin plugin is not installed in Android Studio.
* install Kotlin plugin in Android Studio.

 File-> Setting-> plugin -> MarketPlace -> type kotlin in search bar -> Install -> Apply-> ok.
 
* Minimum SDK version 21.
* Compile SDK version 30.
* Testing Mobile Device (Android version 10).

## Architecture - MVI
MVI stands for Model-View-Intent. This pattern has been introduced recently in Android. It works based on the principle of unidirectional and cylindrical flow inspired by the Cycle.js framework.

Let’s see what is the role of each component of MVI.

*Model: Unlike other patterns, In MVI Model represents the state of the UI. i.e for example UI might have different states like Data Loading, Loaded, Change in UI with user Actions, Errors, User current screen position states. Each state is stored as similar to the object in the model.
View: The View in the MVI is our Interfaces which can be implemented in Activities and fragments. It means to have a container which can accept the different model states and display it as a UI. They use observable intents(Note: This doesn't represent the Android traditional Intents) to respond to user actions.
*Intent: Even though this is not an Intent as termed by Android from before. The result of the user actions is passed as an input value to Intents. In turn, we can say we will be sending models as inputs to the Intents which can load it through Views.
How does the MVI work?
User does an action which will be an Intent → Intent is a state which is an input to model → Model stores state and send the requested state to the *View → View Loads the state from Model → Displays to the user. If we observe, the data will always flow from the user and end with the user through intent. It cannot be the other way, Hence its called Unidirectional architecture. If the user does one more action the same cycle is repeated, hence it is Cyclic.


## Declaring dependencies


## Retrofit2
Retrofit is used for calling networking API through request URL and getting result in a response in gson. 
Retrofit is a REST Client for Java and Android. It makes it relatively easy to retrieve and upload JSON (or other structured data) via a REST based webservice. In Retrofit you configure which converter is used for the data serialization.
```
   retrofit2:'com.squareup.retrofit2:retrofit:(insert version)'
   Gson: 'com.squareup.retrofit2:converter-gson :(insert version)'
   Jackson: 'com.squareup.retrofit2:converter-jackson: (insert version)'
   Moshi: 'com.squareup.retrofit2:converter-moshi:(insert version)'
```

## Dependency injection
*KOIN
Koin is a dependency injection framework that conforms to this need. It is a lightweight framework, easy to learn, and does not have much boilerplate code. Let's see how we can use this framework to manage dependencies in our Android applications

 implementation "org.koin:koin-android:$koin_version"
 implementation "org.koin:koin-android-scope:$koin_version"
 implementation "org.koin:koin-android-viewmodel:$koin_version"

## Lifecycle and Viewmodel

Lifecycle-aware components perform actions in response to a change in the lifecycle status of another component, such as activities and fragments. These components help you produce better-organized, and often lighter-weight code, that is easier to maintain.

```
lifecycleExt: "androidx.lifecycle:lifecycle-extensions:(insert version)"
lifecycleAnnotation :"androidx.lifecycle:lifecycle-compiler:(insert version)"
liveData kotlin : "androidx.lifecycle:lifecycle-livedata-ktx:(insert version)"
lifecycleViewModel kotlin : "androidx.lifecycle:lifecycle-viewmodel-ktx:(insert version)"

```
## Room

 The Room persistence library provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of      SQLite.
 
```
    Room :"androidx.room:room-runtime:(insert version)"
    Room compiler: "androidx.room:room-compiler:(insert version)"
```
## Navigation Component

Navigation refers to the interactions that allow users to navigate across, into, and back out from the different pieces of content within your app. 

```
Navigation  : "androidx.navigation:navigation-fragment-ktx:(insert version)"
             "androidx.navigation:navigation-ui-ktx:(insert version)"
```
## Piccaso

A powerful image downloading and caching library for Android.

```
"com.squareup.picasso:picasso:(insert version)"
```

## Testing
Testing your app is an integral part of the app development process. By running tests against your app consistently, you can verify your app's correctness, functional behavior, and usability before you release it publicly.

``` 
junit = "junit:junit:${Versions.junitVersion}"
androidxTestRunner : "androidx.test:runner:${Versions.androidxTestRunnerVersion}"
androidxTestRules : "androidx.test:rules:${Versions.androidxTestRunnerVersion}"
junitTestExt : "androidx.test.ext:junit-ktx:${Versions.junitExtVersion}"
espressoCore : "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
mockK : "io.mockk:mockk:${Versions.mockKVersion}"
coreTesting : "androidx.arch.core:core-testing:${Versions.coreTestingVersion}"
robolectric :"org.robolectric:robolectric:${Versions.robolectricVersion}"
```

## Get Clone and run project in Android Studio
Use Git commands for clone code from the repository.
Clone
Use git clone command to clone repository
```
https://github.com/Neha-Rajput/WeatherForecastApp.git
```
After successful cloning of project open the project in Android Studio.

Android Studio -> File -> Open
select file "Weather app" -> OK

Run Project 
Android Studio -> Run -> Run "app"

Select emulator or connect a real Android device and if you run the app in real Android Device make debugging mode ON.

Mobile Debugging select below option in phone.

Setting -> Additional Setting -> Developer Option - > USB Debugging 

make USB Debuggin ON.

Finally App run in you phone and its look like:

