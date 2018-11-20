package com.example.myframework.http.core;

import retrofit2.Response;

/**
 * Created by 陈行 on 2018/11/20 0020.
 */

public class HttpResponse<T> {

    private Response<T> oriResponse;

    public HttpResponse(Response<T> oriResponse) {
        this.oriResponse = oriResponse;
    }


}
