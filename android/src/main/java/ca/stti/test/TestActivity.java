package ca.stti.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class TestActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Navistream Test", "Message from :core: \"" + Library.getString() + "\"");
    }
}
