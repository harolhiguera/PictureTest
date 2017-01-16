package com.lazada.picturetest.fragments;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lazada.picturetest.R;
import com.lazada.picturetest.application.App;
import com.lazada.picturetest.helpers.Utils;
import com.lazada.picturetest.injection.component.DaggerFullImageFragmentComponent;
import com.lazada.picturetest.injection.component.FullImageFragmentComponent;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import timber.log.Timber;

/**
 * A simple {@link Fragment} subclass.
 */
public class FullImageFragment extends Fragment {

    @Inject
    Picasso picasso;

    String photo;
    String avatar;
    String title;
    String author;

    @BindView(R.id.img_photo)
    ImageView img_photo;
    @BindView(R.id.img_avatar)
    CircleImageView img_avatar;
    @BindView(R.id.txt_title)
    TextView txt_title;
    @BindView(R.id.txt_author)
    TextView txt_author;
    @BindView(R.id.btn_back)
    ImageButton btn_back;
    @BindView(R.id.cont_labels)
    LinearLayout cont_labels;



    private boolean controlHidden;
    private Unbinder unbinder;

    public FullImageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null){

            photo = savedInstanceState.getString("photo");
            avatar = savedInstanceState.getString("avatar");
            title = savedInstanceState.getString("title");
            author = savedInstanceState.getString("author");
        }

        FullImageFragmentComponent component = DaggerFullImageFragmentComponent.builder()
                .applicationComponent(App.get(this).component())
                .build();
        component.injectFullImageFragment(this);

    }

    public static FullImageFragment newInstance(String ph, String av, String ti, String au) {

        FullImageFragment fragment = new FullImageFragment();

        fragment.photo = ph;
        fragment.avatar = av;
        fragment.title = ti;
        fragment.author = au;

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_full_image, container, false);
        unbinder = ButterKnife.bind(this, view);

        init();

        return view;
    }

    private void init() {

        picasso.load(photo)
                .into(img_photo);

        picasso.load(avatar)
                .resize(Utils.pxFromDp(getActivity(), 40), Utils.pxFromDp(getActivity(), 40))
                .centerCrop()
                .into(img_avatar);

        txt_author.setText(author);
        txt_author.setTypeface(Utils.AdventProRegular);

        txt_title.setText(title);
        txt_title.setTypeface(Utils.AdventProRegular);
    }

    //*
    //*
    //*
    //*
    //*::::::::: LISTENERS ::::::::::::::::::::::::::::::::::::::::::
    //*
    //*
    //*

    @OnClick(R.id.btn_back)
    void L1() {

        FragmentManager fM = getActivity().getSupportFragmentManager();
        fM.popBackStack("FullImageFragment", FragmentManager.POP_BACK_STACK_INCLUSIVE);

    }

    @OnClick(R.id.img_photo)
    void L2(){

        if (controlHidden){
            FadeIn(btn_back);
            FadeIn(cont_labels);
            controlHidden = false;
        }else{
            FadeOut(btn_back);
            FadeOut(cont_labels);
            controlHidden = true;
        }
    }


    //*
    //*
    //*
    //*
    //*::::::::: UTILS ::::::::::::::::::::::::::::::::::::::::::
    //*
    //*
    //*

    private void FadeIn(final View view) {
        view.setVisibility(View.VISIBLE);
        view.setAlpha(0.0f);
        view.animate()
                .alpha(1.0f)
                .setInterpolator(new LinearInterpolator())
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        view.setVisibility(View.VISIBLE);
                    }
                });
    }

    private void FadeOut(final View view) {
        view.animate()
                .alpha(0.0f)
                .setInterpolator(new LinearInterpolator())
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        view.setVisibility(View.GONE);
                    }
                });
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
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("photo",photo);
        outState.putString("author",author);
        outState.putString("avatar",avatar);
        outState.putString("title",title);

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
}
