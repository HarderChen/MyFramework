package com.example.myframework.http.error;

/**
 * Created by 陈行 on 2018/11/20 0020.
 */

public class HttpPageNoFoundError extends HttpError {
    public HttpPageNoFoundError() {
        super(HttpErrorCode.PAGE_NOT_FOUND);
    }
}