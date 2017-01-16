package com.lazada.picturetest.injection.component;

import com.lazada.picturetest.fragments.PhotoListFragment;
import com.lazada.picturetest.injection.module.PhotoListFragmentModule;
import com.lazada.picturetest.injection.scope.PhotoListFragmentScope;

import dagger.Component;

/**
 * Created by Harol Higuera on 1/16/17.
 */

@PhotoListFragmentScope
@Component(modules = {PhotoListFragmentModule.class}, dependencies = {ApplicationComponent.class})
public interface PhotoListFragmentComponent {

    void injectPhotoListFragment(PhotoListFragment photoListFragment);
}
