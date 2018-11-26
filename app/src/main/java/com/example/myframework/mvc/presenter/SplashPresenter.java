package com.example.myframework.mvc.presenter;

import com.example.myframework.dao.DaoSession;
import com.example.myframework.mvc.contract.SplashContract;

import javax.inject.Inject;

/**
 * Created by 陈行 on 2018/11/26 0026.
 */

public class SplashPresenter extends BasePresenter<SplashContract.View> implements SplashContract.Presenter {

    @Inject
    public SplashPresenter(DaoSession daoSession) {
        super(daoSession);
    }

    @Override
    public void getUser() {


    }

    @Override
    public void saveAccessToken() {

    }
}
