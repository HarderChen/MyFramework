package com.example.myframework.http;

import android.support.annotation.NonNull;

import com.example.myframework.http.model.AuthRequestModel;
import com.example.myframework.mvp.model.BasicToken;
import com.example.myframework.mvp.model.OauthToken;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 陈行 on 2018/11/19 0019.
 */

public interface LoginService {

    @POST("authorizations")
    @Headers("Accept：application/json")
    Observable<Response<BasicToken>>authorization(@NonNull @Body AuthRequestModel authRequestModel);

    @POST("login/oauth/access_token")
    @Headers("Accept：application/json")
    Observable<Response<OauthToken>> getAccessToken(
            @Query("client_id")String clientId ,
            @Query("client_secret")String clientSecret ,
            @Query("code")String code ,
            @Query("state")String state
    );
}
