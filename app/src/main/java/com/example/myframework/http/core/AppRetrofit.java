package com.example.myframework.http.core;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.myframework.AppApplication;
import com.example.myframework.AppConfig;
import com.example.myframework.util.FileUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by 陈行 on 2018/11/19 0019.
 */

public enum  AppRetrofit {
    INSTANCE;
    private final String TAG="AppRetrofit";
    private HashMap<String, Retrofit> retrofitMap = new HashMap<>();
    private String token;

    private void createRetrofit(@NonNull String baseUrl,boolean isJson){
        int timeOut= AppConfig.HTTP_TIME_OUT;
        Cache cache=new Cache(FileUtil.getHttpImageCacheDir(AppApplication.get()),AppConfig.HTTP_MAX_CACHE_SIZE);

        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .connectTimeout(timeOut, TimeUnit.MILLISECONDS)
                .addInterceptor(new BaseIntercepter())
                .addInterceptor(new NetworkBaseIntercepter())
                .cache(cache)
                .build();

        Retrofit.Builder builder=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient);

        if(isJson){
            builder.addConverterFactory(GsonConverterFactory.create());
        }else {
            builder.addConverterFactory(SimpleXmlConverterFactory.create());
        }

        retrofitMap.put(baseUrl+"-"+isJson,builder.build());
    }

    public Retrofit getRetrofit(@NonNull String baseUrl, @Nullable String token, boolean isJson){
        this.token=token;
        String key=baseUrl+"-"+isJson;
        if(!retrofitMap.containsKey(key)){
            createRetrofit(baseUrl,isJson);
        }
        return  retrofitMap.get(key);
    }
    public Retrofit getRetrofit(@NonNull String baseUrl, @Nullable String token){
        return getRetrofit(baseUrl, token, true);
    }

    /**
     * 拦截器
     */
    public class BaseIntercepter implements Interceptor{

        @Override
        public Response intercept(@NonNull Chain chain) throws IOException {
            return null;
        }
    }

    /**
     * 网络请求拦截器
     */
    public class NetworkBaseIntercepter implements Interceptor{

        @Override
        public Response intercept(@NonNull Chain chain) throws IOException {
            return null;
        }
    }


}
