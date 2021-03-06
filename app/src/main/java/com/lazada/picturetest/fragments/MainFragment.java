package com.lazada.picturetest.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lazada.picturetest.bus.PhotoBus;
import com.lazada.picturetest.R;
import com.lazada.picturetest.adapters.ListOfCategoriesAdapter;
import com.lazada.picturetest.helpers.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;
import timber.log.Timber;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private Unbinder unbinder;
    private boolean isRecreated;

    @BindView(R.id.list_categories)
    ListView list_categories;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this,view);

        ListOfCategoriesAdapter listOfCategoriesAdapter = new ListOfCategoriesAdapter(Constant.categories, getActivity());

        list_categories.setAdapter(listOfCategoriesAdapter);
        list_categories.setOnItemClickListener(new catListener());
        OverScrollDecoratorHelper.setUpOverScroll(list_categories);

        return view;
    }

    //*
    //*
    //*
    //*
    //*::::::::: LISTENERS ::::::::::::::::::::::::::::::::::::::::::
    //*
    //*
    //*

    private class catListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

            PhotoListFragment photoListFragment = PhotoListFragment.newInstance(Constant.categories[i]);

            fragmentManager.beginTransaction()
                    .replace(R.id.main_container,photoListFragment)
                    .addToBackStack("PhotoListFragment")
                    .commit();
            PhotoBus.showBackBtn.onNext(Constant.categories[i]);

        }
    }


    //*
    //*
    //*
    //*
    //*::::::::: FRAGMENT CONTROL ::::::::::::::::::::::::::::::::::::::::::
    //*
    //*
    //*
    @Override
    public void onResume() {
        super.onResume();
        Timber.d("- - - > onResume");
    }

    @Override
    public void onStart() {
        super.onStart();

        Timber.d("- - - > onStart");

    }

    @Override
    public void onPause() {
        Timber.d("- - - > onPause");
        super.onPause();
    }


    @Override
    public void onStop() {
        Timber.d("- - - > onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {

        unbinder.unbind();
        Timber.d("- - - > onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Timber.d("- - - > onDestroy");
        super.onDestroy();
    }
}
