package com.lazada.picturetest.injection.module;

import com.lazada.picturetest.adapters.PhotoListAdapter;
import com.lazada.picturetest.fragments.PhotoListFragment;
import com.lazada.picturetest.injection.scope.PhotoListFragmentScope;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Harol Higuera on 1/16/17.
 */
@Module
public class PhotoListFragmentModule {

    private final PhotoListFragment photoListFragment;

    public PhotoListFragmentModule(PhotoListFragment photoListFragment) {
        this.photoListFragment = photoListFragment;
    }


    @Provides
    @PhotoListFragmentScope
    public PhotoListAdapter photoListAdapter(Picasso picasso) {
        return new PhotoListAdapter(photoListFragment.getActivity(), picasso);
    }
}
