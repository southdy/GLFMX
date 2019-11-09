package com.kylin;

import android.app.NativeActivity;

public class PlayerActivity extends NativeActivity {
    static {
        System.loadLibrary("kylin");
    }
}
