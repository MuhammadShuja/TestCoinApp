package com.test.coinapp;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

public class CoinApp extends Application {
    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    public static Context getAppContext() {
        return mContext;
    }

    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
}
