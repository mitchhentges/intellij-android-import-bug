package ca.stti.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

// "Android" still builds fine when core isn't "Android Gradle"
public class TestActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Navistream Test", "Message from :core: \"" + Library.string() + "\"");
    }
}
