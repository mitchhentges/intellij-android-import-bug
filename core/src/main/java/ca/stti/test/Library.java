package ca.stti.test;

// Core being an "Android Gradle" module slows down core-only builds significantly
//   (especially when there's more code)

// Should only do "Make", not "gradle build using tasks"
public class Library {
    public static String string() {
        return "from :core";
    }
}
