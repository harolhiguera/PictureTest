package com.lazada.picturetest.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.lazada.picturetest.R;
import com.lazada.picturetest.fragments.MainFragment;
import com.lazada.picturetest.helpers.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Harol Higuera on 1/15/17.
 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.my_toolbar)
    Toolbar toolbar;
    @BindView(R.id.titleBar)
    TextView titleBar;

    private FragmentManager fragmentManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        SetTitle(getString(R.string.app_name));
        titleBar.setTypeface(Utils.AdventProSemiBold);
        SetBackgBtnState(true);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.main_container, new MainFragment()).commit();

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
}
