package com.example.myframework.http.core;

import android.app.AlertDialog;
import android.support.annotation.NonNull;

/**
 * Created by 陈行 on 2018/11/20 0020.
 */

public class HttpProgressSubscriber<T> extends HttpSubscriber<T> {

    /**
     * 网络请求dialog
     */
    private AlertDialog mDialog;

    public HttpProgressSubscriber(@NonNull AlertDialog dialog, @NonNull HttpObserver<T> observer) {
        super(observer);
        mDialog = dialog;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!isUnsubscribed())
            mDialog.show();
    }

    @Override
    public void onCompleted() {
        super.onCompleted();
        mDialog.dismiss();
    }

    @Override
    public void onError(Throwable e) {
        super.onError(e);
        mDialog.dismiss();
    }
}
