package com.example.myframework.mvc.presenter;

import android.content.Intent;

import com.example.myframework.mvc.contract.ILoginContract;
import com.example.myframework.mvc.model.BasicToken;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/11/2 0002.
 */

public class LoginPresenter extends BasePresenter<ILoginContract.View> implements ILoginContract.Presenter  {


    @Override
    public void getToken(String code, String state) {

    }

    @Override
    public String getOAuth2Url() {
        return null;
    }

    @Override
    public void basicLogin(String userName, String password) {

    }

    @Override
    public void handleOauth(Intent intent) {

    }

    @Override
    public void getUserInfo(BasicToken basicToken) {

    }
}
