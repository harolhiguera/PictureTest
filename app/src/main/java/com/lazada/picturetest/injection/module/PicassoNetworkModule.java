package com.lazada.picturetest.injection.module;

import android.content.Context;

import com.lazada.picturetest.injection.quialifier.CacheForPicasso;
import com.lazada.picturetest.injection.quialifier.FileForPicasso;
import com.lazada.picturetest.injection.quialifier.HttpLoggingInterceptorForPicasso;
import com.lazada.picturetest.injection.quialifier.OkHttpForPicasso;
import com.lazada.picturetest.injection.scope.ApplicationScope;

import java.io.File;

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
public class PicassoNetworkModule {

    @Provides
    @ApplicationScope
    @HttpLoggingInterceptorForPicasso
    public HttpLoggingInterceptor loggingInterceptor(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.d("Picasso Working: " + message);
            }
        });

        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return interceptor;

    }

    @Provides
    @ApplicationScope
    @CacheForPicasso
    public Cache cache(@FileForPicasso File cacheFile){
        return new Cache(cacheFile,10*1000*1000); // 10Mb Cache
    }

    @Provides
    @ApplicationScope
    @FileForPicasso
    public File cacheFile(Context context){
        return new File(context.getCacheDir(), "okhttp_cache");
    }


    @Provides
    @ApplicationScope
    @OkHttpForPicasso
    public OkHttpClient okHttpClient(@HttpLoggingInterceptorForPicasso HttpLoggingInterceptor loggingInterceptor, @CacheForPicasso Cache cache){
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();
    }
}
