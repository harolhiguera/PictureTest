package com.lazada.picturetest.injection.module;

import android.content.Context;

import com.lazada.picturetest.injection.quialifier.CacheForApiService;
import com.lazada.picturetest.injection.quialifier.FileForApiService;
import com.lazada.picturetest.injection.quialifier.HttpLoggingInterceptorForApiService;
import com.lazada.picturetest.injection.quialifier.OkHttpForApiService;
import com.lazada.picturetest.injection.scope.ApplicationScope;

import java.io.File;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * Created by Harol Higuera on 1/15/17.
 */
@Module(includes = ContextModule.class)
public class ApiServiceNetworkModule {


    @Provides
    @ApplicationScope
    @HttpLoggingInterceptorForApiService
    public HttpLoggingInterceptor loggingInterceptor() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.d("ApiService Working: " + message);
            }
        });

        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return interceptor;

    }

    @Provides
    @ApplicationScope
    @CacheForApiService
    public Cache cache(@FileForApiService File cacheFile) {
        return new Cache(cacheFile, 10 * 1000 * 1000); // 10Mb Cache
    }

    @Provides
    @ApplicationScope
    @FileForApiService
    public File cacheFile(Context context) {
        return new File(context.getCacheDir(), "okhttp_cache");
    }


    @Provides
    @ApplicationScope
    @OkHttpForApiService
    public OkHttpClient okHttpClient(@HttpLoggingInterceptorForApiService HttpLoggingInterceptor loggingInterceptor, @CacheForApiService Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(4, TimeUnit.SECONDS)
                .readTimeout(4, TimeUnit.SECONDS)
                .cache(cache)
                .build();
    }
}
