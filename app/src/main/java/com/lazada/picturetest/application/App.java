package com.lazada.picturetest.application;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import android.support.v4.app.Fragment;

import com.lazada.picturetest.injection.component.ApplicationComponent;
import com.lazada.picturetest.injection.component.DaggerApplicationComponent;
import com.lazada.picturetest.injection.module.ContextModule;

import timber.log.Timber;

/**
 * Created by Harol Higuera on 1/15/17.
 */

public class App extends Application {

    private ApplicationComponent applicationComponent;
    public static Resources resources;



    public static App get(Activity activity) {
        return (App) activity.getApplication();
    }

    public static App get(Fragment fragment) {
        return (App) fragment.getActivity().getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        applicationComponent = DaggerApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

        resources = getResources();
    }

    public ApplicationComponent component() {
        return applicationComponent;
    }

}
