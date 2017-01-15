package com.lazada.picturetest.injection.module;

import android.content.Context;

import com.lazada.picturetest.injection.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Harol Higuera on 1/15/17.
 */

@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context){
        this.context = context;
    }


    @Provides
    @ApplicationScope
    public Context ContextModule() {
        return context;
    }
}
