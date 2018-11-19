package com.example.myframework.mvc.presenter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.myframework.mvc.contract.base.IBaseContract;

/**
 * Created by Administrator on 2018/11/2 0002.
 */

public abstract class BasePresenter<V extends IBaseContract.View> implements IBaseContract.Presenter<V> {

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
}
