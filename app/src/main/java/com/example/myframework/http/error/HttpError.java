package com.example.myframework.http.error;

/**
 * Created by 陈行 on 2018/11/20 0020.
 */

public class HttpError extends Error {

    private int errorCode = -1;

    public HttpError(int errorCode) {
        super(HttpErrorCode.getErrorMsg(errorCode));
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
