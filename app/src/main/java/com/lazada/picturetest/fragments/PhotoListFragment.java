package com.lazada.picturetest.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lazada.picturetest.R;
import com.lazada.picturetest.adapters.PhotoListAdapter;
import com.lazada.picturetest.application.App;
import com.lazada.picturetest.helpers.Constant;
import com.lazada.picturetest.helpers.EndlessRecyclerViewScrollListener;
import com.lazada.picturetest.helpers.RecycleItemListener;
import com.lazada.picturetest.injection.component.DaggerPhotoListFragmentComponent;
import com.lazada.picturetest.injection.component.PhotoListFragmentComponent;
import com.lazada.picturetest.injection.module.PhotoListFragmentModule;
import com.lazada.picturetest.models.photos.Photo;
import com.lazada.picturetest.models.photos.PhotoModel;
import com.lazada.picturetest.network.ApiService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhotoListFragment extends Fragment {

    private static final int NUMBER_OF_COLUMNS = 1;

    private ArrayList<String> arrayPhotos = new ArrayList<>();
    private ArrayList<String> arrayAuthorName = new ArrayList<>();
    private ArrayList<String> arrayAuthorAvatar = new ArrayList<>();
    private ArrayList<String> arrayTitles = new ArrayList<>();

    private Call<PhotoModel> call;

    private String keyWord;
    private Unbinder unbinder;

    private int pageCounter;
    private int totalPages;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefresh)
    SwipeRefreshLayout swiperefresh;

    @Inject
    PhotoListAdapter photoListAdapter;
    @Inject
    ApiService apiService;

    public PhotoListFragment() {
        // Required empty public constructor
    }

    public static PhotoListFragment newInstance(String keyword) {

        PhotoListFragment fragment = new PhotoListFragment();
        fragment.keyWord = keyword;

        return fragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PhotoListFragmentComponent component = DaggerPhotoListFragmentComponent.builder()
                .photoListFragmentModule(new PhotoListFragmentModule(this))
                .applicationComponent(App.get(this).component())
                .build();

        component.injectPhotoListFragment(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo_list, container, false);
        unbinder = ButterKnife.bind(this, view);

        setRecyclerViewLayoutManager();
        setupRecyclerView();

        LoadNextPage();

        pageCounter = 1;
        swiperefresh.setColorSchemeResources(R.color.list_back_01);
        swiperefresh.setRefreshing(true);

        return view;
    }


    /**
     * ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
     * ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
     * :::::::::  RECYCLER-VIEW CONFIGURATIONS ::::::::::::::::::
     * ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
     * ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
     */

    private void setupRecyclerView() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        EndlessRecyclerViewScrollListener scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {

                // If there are not more pages to request no request will be executed
                if (pageCounter < totalPages)
                    LoadNextPage();
            }
        };

        recyclerView.addOnScrollListener(scrollListener);

        recyclerView.setAdapter(photoListAdapter);
        OverScrollDecoratorHelper.setUpOverScroll(recyclerView, OverScrollDecoratorHelper.ORIENTATION_VERTICAL);
    }

    private void setRecyclerViewLayoutManager() {

        int scrollPosition = 0;

        if (recyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) recyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), NUMBER_OF_COLUMNS);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.scrollToPosition(scrollPosition);
    }

    /*
     * ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
     * ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
     * :::::::::  LISTENERS :::::::::::::::::::::::::::::::::::::
     * ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
     * ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
     */

    private class RecycleListener extends RecycleItemListener.SimpleOnItemClickListener {
        @Override
        public void onItemClick(View childView, int position) {
            super.onItemClick(childView, position);

            Timber.d("Position " + position + "selected");
        }
    }

    /*
     * ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
     * ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
     * :::::::::  Request Client method :::::::::::::::::::::::::
     * ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
     * ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
     */

    private void LoadNextPage() {

        if (call != null && call.isExecuted()) {
            call.cancel();
        }

        call = apiService.GetPhotos(Constant.CONSUMER_KEY
                , "popular"
                , "created_at"
                , 3
                , "store_download"
                , "voted"
                , keyWord
                , pageCounter
        );

        call.clone().enqueue(new Callback<PhotoModel>() {
            @Override
            public void onResponse(Call<PhotoModel> call, Response<PhotoModel> response) {

                if (response.isSuccessful()) {

                    Timber.d("CODE: "+ response.code());
                    Timber.d("response.body(): "+ response.body().toString());

                    int totalElements;
                    PhotoModel photoModel;
                    List<Photo> photos;

                    photoModel = response.body();
                    totalElements = photoModel.getPhotos().size();

                    if (pageCounter == 1) {
                        totalPages = photoModel.getTotal_pages();
                        swiperefresh.setRefreshing(false);
                    }

                    Timber.d("totalElements: "+ totalElements);
                    if (totalElements > 0) {
                        photos = photoModel.getPhotos();

                        for (int i = 0; i < photos.size(); i++) {
                            arrayPhotos.add(photos.get(i).getImageUrl());
                            arrayTitles.add(photos.get(i).getName());
                            arrayAuthorName.add(photos.get(i).getUser().getFullname());
                            arrayAuthorAvatar.add(photos.get(i).getUser().getAvatars().getLarge().getHttps());
                        }

                        photoListAdapter.UpdateEntries(arrayPhotos, arrayAuthorName, arrayTitles, arrayAuthorAvatar);
                        pageCounter++;
                    }


                }
            }

            @Override
            public void onFailure(Call<PhotoModel> call, Throwable t) {

            }
        });


    }


    /*
     * ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
     * ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
     * ::::::::: Control ::::::::::::::::::::::::::::::::::::::::
     * ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
     * ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
     */

    @Override
    public void onStart() {
        recyclerView.addOnItemTouchListener(new RecycleItemListener(getActivity(), new RecycleListener()));
        Timber.d("onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Timber.d("onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Timber.d("onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Timber.d("onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Timber.d("onDestroyView");
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Timber.d("onDestroy");
        super.onDestroy();
    }


}
