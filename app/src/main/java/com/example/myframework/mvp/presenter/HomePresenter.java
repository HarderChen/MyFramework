package com.example.myframework.mvp.presenter;

import com.example.myframework.dao.DaoSession;
import com.example.myframework.mvp.contract.HomeContract;
import com.example.myframework.ui.fragment.HomeFragment;

/**
 * Created by 陈行 on 2018/12/2.
 */

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {

    public HomePresenter(DaoSession daoSession) {
        super(daoSession);
    }
}
