package com.example.myframework.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myframework.R;
import com.example.myframework.inject.component.AppComponent;
import com.example.myframework.mvp.contract.HomeContract;
import com.example.myframework.mvp.presenter.HomePresenter;
import com.example.myframework.ui.fragment.base.BaseFragment;

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.View{


    public HomeFragment() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void setupFragmentComponent(AppComponent appComponent) {

    }

    @Override
    protected void initFragment(Bundle savedInstanceState) {

    }

}
