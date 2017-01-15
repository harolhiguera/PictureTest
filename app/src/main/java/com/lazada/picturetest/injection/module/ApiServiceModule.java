package com.lazada.picturetest.injection.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lazada.picturetest.helpers.Constant;
import com.lazada.picturetest.injection.quialifier.OkHttpForApiService;
import com.lazada.picturetest.injection.scope.ApplicationScope;
import com.lazada.picturetest.network.ApiService;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Harol Higuera on 1/15/17.
 */

@Module(includes = {ApiServiceNetworkModule.class})
public class ApiServiceModule {

    private static final String API_BASE_URL = Constant.API_BASE_URL;

    @Provides
    @ApplicationScope
    public ApiService apiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }

    @Provides
    @ApplicationScope
    public Gson gson(){
        GsonBuilder gsonBuilder = new GsonBuilder();

        return gsonBuilder.create();
    }

    @Provides
    @ApplicationScope
    public Retrofit retrofit(@OkHttpForApiService OkHttpClient okHttpClient, Gson gson){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl(API_BASE_URL)
                .build();
    }
}
