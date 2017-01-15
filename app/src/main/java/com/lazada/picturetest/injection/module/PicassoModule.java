package com.lazada.picturetest.injection.module;

import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.lazada.picturetest.injection.quialifier.OkHttpForPicasso;
import com.lazada.picturetest.injection.scope.ApplicationScope;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by Harol Higuera on 1/15/17.
 */
@Module(includes = {PicassoNetworkModule.class, ContextModule.class})
public class PicassoModule {

    @Provides
    @ApplicationScope
    public Picasso picasso(Context context, OkHttp3Downloader okHttp3Downloader){

        return new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build();
    }

    @Provides
    @ApplicationScope
    public OkHttp3Downloader okHttp3Downloader(@OkHttpForPicasso OkHttpClient okHttpClient){
        return new OkHttp3Downloader(okHttpClient);
    }

}
