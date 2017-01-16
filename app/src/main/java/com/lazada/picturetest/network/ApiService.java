package com.lazada.picturetest.network;

import com.lazada.picturetest.models.photos.PhotoModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Harol Higuera on 1/15/17.
 */

public interface ApiService {

    @GET("v1/photos")
    Call<PhotoModel> GetPhotos(
            @Query("consumer_key") String consumer_key,
            @Query("feature") String feature,
            @Query("sort") String sort,
            @Query("image_size") int image_size,
            @Query("include_store") String include_store,
            @Query("include_states") String include_states,
            @Query("only") String only,
            @Query("page") int page
    );

}
