package com.example.myframework.mvc.presenter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.myframework.dao.DaoSession;
import com.example.myframework.http.LoginService;
import com.example.myframework.http.core.AppRetrofit;
import com.example.myframework.http.core.HttpSubscriber;
import com.example.myframework.mvc.contract.base.BaseContract;

import java.util.ArrayList;

import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by Administrator on 2018/11/2 0002.
 */

public abstract class BasePresenter<V extends BaseContract.View> implements BaseContract.Presenter<V> {

    protected DaoSession daoSession;
    private ArrayList<Subscriber<?>> subscribers;

    public BasePresenter(DaoSession daoSession) {
        this.daoSession = daoSession;
        subscribers = new ArrayList<>();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onRestoreInstanceState(Bundle outState) {

    }

    @Override
    public void attachView(@NonNull V view) {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void onViewInitialized() {

    }

    @Nullable
    @Override
    public Context getContext() {
        return null;
    }

    /**
     * retrofit
     */
    public LoginService getLoginService(){
        return AppRetrofit.INSTANCE.getRetrofit("https://github.com/",null)
                .create(LoginService.class);
    }

    protected <T> void generateRxHttpExecute(
            @NonNull Observable<Response<T>> observable, @Nullable HttpSubscriber<T> subscriber) {

        if (subscriber != null) {
            subscribers.add(subscriber);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(subscriber);
        } else {
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new HttpSubscriber<T>());
        }
    }

}
