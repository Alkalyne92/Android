package com.example.leamariette.myapplication;


import android.util.Log;
import android.webkit.JavascriptInterface;

/**
 * Created by leamariette on 14/03/2017.
 */

class JsInterface {

    @JavascriptInterface
        public void test() {
        Log.d("JS", "toto");
    }
}
