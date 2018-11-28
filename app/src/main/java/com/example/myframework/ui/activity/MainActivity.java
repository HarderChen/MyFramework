package com.example.myframework.ui.activity;

import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.myframework.R;
import com.example.myframework.ui.fragment.PageFragment;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;
import rx.Observable;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {
    private final String TAG="MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

}
