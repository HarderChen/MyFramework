package com.example.myframework.http.core;

import retrofit2.Response;
import rx.Subscriber;

/**
 * Created by 陈行 on 2018/11/20 0020.
 */

public class HttpSubscriber<T> extends Subscriber<Response<T>> {

    private HTTPObserver<T> mObserver;

    public HttpSubscriber( HTTPObserver<T> mObserver) {
        this.mObserver = mObserver;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        if (mObserver != null)
            mObserver.onError(e);
    }

    @Override
    public void onNext(Response<T> tResponse) {
        if (mObserver != null)
            mObserver.onSuccess(new HttpResponse<T>(tResponse));
    }
}
