package com.example.myframework.ui.activity;

import com.example.myframework.R;
import com.example.myframework.inject.component.AppComponent;
import com.example.myframework.mvp.presenter.SplashPresenter;
import com.example.myframework.ui.activity.base.BaseActivity;

public class SplashActivity extends BaseActivity<SplashPresenter> {

    @Override
    protected void initActivity() {
        super.initActivity();
        mPresenter.getUser();
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_splash;
    }

    @Override
    public void showLoginPage() {
        super.showLoginPage();
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

}
