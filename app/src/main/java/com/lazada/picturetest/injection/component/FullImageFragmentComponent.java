package com.lazada.picturetest.injection.component;

import com.lazada.picturetest.fragments.FullImageFragment;
import com.lazada.picturetest.injection.module.FullImageFragmentModule;
import com.lazada.picturetest.injection.scope.FullImageFragmentScope;

import dagger.Component;

/**
 * Created by Harol Higuera on 1/16/17.
 */
@FullImageFragmentScope
@Component(modules = {FullImageFragmentModule.class}, dependencies = {ApplicationComponent.class})
public interface FullImageFragmentComponent {

    void injectFullImageFragment(FullImageFragment fullImageFragment);

}
