# IntelliJ Android Gradle Plugin Import Bug

## The bug

When a **pure Java** subproject (hereby called "core") is in the same base project as an **Android** subproject
(hereby called "android"), "core" will be imported into IntelliJ as "Android-Gradle" and "Java-Gradle".
Pure Java projects should **_only_ be imported as "Java-Gradle"**

![Screenshot](android-gradle-screenshot.png)

## The repercussions

* "core"-only builds can take over **5x** longer than they need to, because they do irrelevant android-related processing[1].
This is incredibly relevant if most of the project is in pure-Java, and unit tests need to be run frequently

[1] By removing the "Android-Gradle" row from "Modules", "core" build times went from 12s to 1.5s for the business app I'm developing

## How to reproduce

1. Open IntelliJ/Android Studio
2. Import the root `build.gradle` from this repository
3. Ignore the errors about "source sets", it's because "Create separate module per source set" is enabled by default when importing
4. Check "Project Structure", then look at Modules|core: there's an "Android-Gradle" section (which shouldn't be there)
5. Run the tests in "core" (Right click on core|src|test|java, hit "Run 'All Tests'", (should perform "Make", but also "Gradle build", which is bad)

## Workaround/How to feel the speed

1. Go to "Project Structure", Delete "Android-Gradle" from Modules|core
2. Run the tests in "core" again. IntelliJ should only do a "Make", and run the tests immediately
3. If the Android subproject is built, it will still work, despite "core" not being "Android-Gradle"

## Video

[Two minute demonstration](https://raw.githubusercontent.com/mitchhentges/intellij-android-import-bug/master/Video.webm)