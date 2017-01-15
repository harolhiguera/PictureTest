package com.lazada.picturetest.application;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by Harol Higuera on 1/15/17.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());
    }
}
