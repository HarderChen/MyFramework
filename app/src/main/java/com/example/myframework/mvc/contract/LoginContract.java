package com.example.myframework.mvc.contract;

import android.content.Intent;

import com.example.myframework.mvc.contract.base.BaseContract;
import com.example.myframework.mvc.model.BasicToken;

/**
 * Created by Administrator on 2018/11/2 0002.
 */

public interface LoginContract {
    interface View extends BaseContract.View{
        void onGetTokenSuccess(BasicToken basicToken);
        void onGetTokenError(String errorMsg);
        void onLoginComplete();
    }
    interface Presenter extends BaseContract.Presenter<LoginContract.View>{
        void getToken(String code, String state);
        String getOAuth2Url();
        void basicLogin(String userName, String password);
        void handleOauth(Intent intent);
        void getUserInfo(BasicToken basicToken);
    }
}
