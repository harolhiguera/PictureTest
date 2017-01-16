package com.lazada.picturetest.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.lazada.picturetest.bus.PhotoBus;
import com.lazada.picturetest.R;
import com.lazada.picturetest.fragments.MainFragment;
import com.lazada.picturetest.helpers.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;

/**
 * Created by Harol Higuera on 1/15/17.
 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.my_toolbar)
    Toolbar toolbar;
    @BindView(R.id.titleBar)
    TextView titleBar;

    private FragmentManager fragmentManager;
    private CompositeSubscription compositeSubscription;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        titleBar.setTypeface(Utils.AdventProSemiBold);

        SetTitle(getString(R.string.app_name));
        SetBackgBtnState(false);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        fragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null){
            fragmentManager.beginTransaction().replace(R.id.main_container, new MainFragment()).commit();
        }

        compositeSubscription = new CompositeSubscription();

        Subscribe();
    }

    private void Subscribe() {

        compositeSubscription.add(PhotoBus.showBackBtnM.subscribe((String cat)->{

            if(cat != null){
                SetTitle(cat);
                SetBackgBtnState(true);
            }

        }));
    }


    private void SetBackgBtnState(boolean show) {
        if (getSupportActionBar() != null) {
            if (show) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setDisplayShowHomeEnabled(true);
            } else {
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                getSupportActionBar().setDisplayShowHomeEnabled(false);
            }
        }
    }

    private void SetTitle(String string) {
        titleBar.setText(string);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home){
            SetTitle(getString(R.string.app_name));
            SetBackgBtnState(false);

            fragmentManager.popBackStack("PhotoListFragment", FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroy() {
        if (compositeSubscription != null) {
            compositeSubscription.unsubscribe();
            compositeSubscription.clear();
        }
        Timber.d("onDestroy");
        super.onDestroy();
    }
}
