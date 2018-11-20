package com.example.myframework.http.core;

import android.app.AlertDialog;

/**
 * Created by 陈行 on 2018/11/20 0020.
 */

public class HttpProgressSubcriber<T> extends HttpSubscriber<T> {

    private AlertDialog mDialog;


    public HttpProgressSubcriber(HTTPObserver<T> mObserver, AlertDialog mDialog) {
        super(mObserver);
        this.mDialog = mDialog;
    }
}
