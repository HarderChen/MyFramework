package com.example.myframework.http.core;

import retrofit2.Response;

/**
 * Created by 陈行 on 2018/11/20 0020.
 */

public interface HTTPObserver<T> {

    void onSuccess(HttpResponse<T>response);

    void onError(Throwable e);
}
