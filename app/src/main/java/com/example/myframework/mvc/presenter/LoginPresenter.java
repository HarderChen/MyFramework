package com.example.myframework.mvc.presenter;

import android.content.Intent;

import com.example.myframework.dao.DaoSession;
import com.example.myframework.http.core.HTTPObserver;
import com.example.myframework.http.core.HttpResponse;
import com.example.myframework.http.core.HttpSubscriber;
import com.example.myframework.mvc.contract.LoginContract;
import com.example.myframework.mvc.model.BasicToken;
import com.example.myframework.mvc.model.OauthToken;

import javax.inject.Inject;

import retrofit2.Response;
import rx.Observable;

/**
 * Created by Administrator on 2018/11/2 0002.
 */

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    @Inject
    public LoginPresenter(DaoSession daoSession) {
        super(daoSession);
    }

    @Override
    public void getToken(String code, String state) {
        Observable<Response<OauthToken>> observable = getLoginService().getAccessToken(
                "8f7213694e115df205fb",
                "82c57672382db5c7b528d79e283c398ad02e3c3f",
                code,
                state);
        HttpSubscriber<OauthToken> subscriber =
                new HttpSubscriber<>(
                        new HTTPObserver<OauthToken>() {
                            @Override
                            public void onSuccess(HttpResponse<OauthToken> response) {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        }
                );
        generateRxHttpExecute(observable,subscriber);

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
