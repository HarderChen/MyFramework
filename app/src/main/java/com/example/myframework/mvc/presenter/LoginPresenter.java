package com.example.myframework.mvc.presenter;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;

import com.example.myframework.dao.DaoSession;
import com.example.myframework.http.core.HttpObserver;
import com.example.myframework.http.core.HttpResponse;
import com.example.myframework.http.core.HttpSubscriber;
import com.example.myframework.http.model.AuthRequestModel;
import com.example.myframework.mvc.contract.LoginContract;
import com.example.myframework.mvc.model.BasicToken;
import com.example.myframework.mvc.model.OauthToken;
import com.example.myframework.mvc.model.User;

import java.util.Date;

import javax.inject.Inject;

import okhttp3.Credentials;
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
                        new HttpObserver<OauthToken>() {
                            @Override
                            public void onSuccess(HttpResponse<OauthToken> response) {
                                OauthToken token = response.body();
                                if(token != null){
                                    mView.onGetTokenSuccess(BasicToken.generateFromOauthToken(token));
                                }else{
                                    mView.onGetTokenError(response.getOriResponse().message());
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                mView.dismissProgressDialog();
                                mView.showErrorToast(getErrorTip(e));
                            }
                        }
                );
        generateRxHttpExecute(observable,subscriber);
        mView.showProgressDialog(getLoadTip());
    }

    @Override
    public String getOAuth2Url() {
        return null;
    }

    @Override
    public void basicLogin(String userName, String password) {
        AuthRequestModel authRequestModel = AuthRequestModel.generate();
        String token = Credentials.basic(userName, password);
        Observable<Response<BasicToken>> observable =
                getLoginService(token).authorization(authRequestModel);
        HttpSubscriber<BasicToken> subscriber =
                new HttpSubscriber<>(
                        new HttpObserver<BasicToken>() {
                            @Override
                            public void onError(@NonNull Throwable error) {
//                                mView.dismissProgressDialog();
                                mView.onGetTokenError(getErrorTip(error));
                            }

                            @Override
                            public void onSuccess(@NonNull HttpResponse<BasicToken> response) {
                                BasicToken token = response.body();
                                if (token != null) {
                                    mView.onGetTokenSuccess(token);
                                } else {
                                    mView.onGetTokenError(response.getOriResponse().message());
                                }

                            }
                        }
                );
        generalRxHttpExecute(observable, subscriber);
//        mView.showProgressDialog(getLoadTip());
    }

    @Override
    public void handleOauth(Intent intent) {
        Uri uri = intent.getData();
        if(uri != null){
            String code = uri.getQueryParameter("code");
            String state = uri.getQueryParameter("state");
            getToken(code,state);
        }

    }

    @Override
    public void getUserInfo(final BasicToken basicToken) {
        HttpSubscriber<User> subscriber = new HttpSubscriber<>(
                new HttpObserver<User>() {
                    @Override
                    public void onError(Throwable error) {
                        mView.dismissProgressDialog();
                        mView.showErrorToast(getErrorTip(error));
                    }

                    @Override
                    public void onSuccess(HttpResponse<User> response) {
//                        mView.dismissProgressDialog();
                        saveAuthUser(basicToken, response.body());
                        mView.onLoginComplete();
                    }
                }
        );
        Observable<Response<User>> observable = getUserService(basicToken.getToken()).
                getPersonInfo(true);
        generalRxHttpExecute(observable, subscriber);
        mView.showProgressDialog(getLoadTip());
    }

    private void saveAuthUser(BasicToken basicToken, User userInfo) {
//        String updateSql = "UPDATE " + daoSession.getAuthUserDao().getTablename()
//                + " SET " + AuthUserDao.Properties.Selected.columnName + " = 0";
//        daoSession.getAuthUserDao().getDatabase().execSQL(updateSql);
//
//        String deleteExistsSql = "DELETE FROM " + daoSession.getAuthUserDao().getTablename()
//                + " WHERE " + AuthUserDao.Properties.LoginId.columnName
//                + " = '" + userInfo.getLogin() + "'";
//        daoSession.getAuthUserDao().getDatabase().execSQL(deleteExistsSql);
//
//        AuthUser authUser = new AuthUser();
//        String scope = StringUtils.listToString(basicToken.getScopes(), ",");
//        Date date = new Date();
//        authUser.setAccessToken(basicToken.getToken());
//        authUser.setScope(scope);
//        authUser.setAuthTime(date);
//        authUser.setExpireIn(360 * 24 * 60 * 60);
//        authUser.setSelected(true);
//        authUser.setLoginId(userInfo.getLogin());
//        authUser.setName(userInfo.getName());
//        authUser.setAvatar(userInfo.getAvatarUrl());
//        daoSession.getAuthUserDao().insert(authUser);
//
//        AppData.INSTANCE.setAuthUser(authUser);
//        AppData.INSTANCE.setLoggedUser(userInfo);
    }

}
