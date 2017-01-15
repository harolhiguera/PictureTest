package com.lazada.picturetest.injection.component;

import com.lazada.picturetest.injection.module.ApiServiceModule;
import com.lazada.picturetest.injection.module.PicassoModule;
import com.lazada.picturetest.injection.scope.ApplicationScope;
import com.lazada.picturetest.network.ApiService;
import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * Created by Harol Higuera on 1/15/17.
 */
@ApplicationScope
@Component(modules = {PicassoModule.class, ApiServiceModule.class})
public interface ApplicationComponent {

    Picasso getPicasso();
    ApiService getApiService();

}
