package com.example.myframework.mvc.contract;

import com.example.myframework.mvc.contract.base.BaseContract;

/**
 * Created by 陈行 on 2018/11/26 0026.
 */

public interface SplashContract {

    interface View extends BaseContract.View{
        void showMainPage();
    }

    interface Presenter extends BaseContract.Presenter<SplashContract.View>{
        void getUser();
        void saveAccessToken();
    }
}
