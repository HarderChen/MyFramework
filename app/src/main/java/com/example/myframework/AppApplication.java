package com.example.myframework;

import android.app.Application;

import com.example.myframework.inject.component.AppComponent;
import com.example.myframework.inject.component.DaggerAppComponent;
import com.example.myframework.inject.module.AppModule;


/**
 * Created by 陈行 on 2018/11/16 0016.
 */

public class AppApplication extends Application {

    private static AppApplication application;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppApplication get(){
        return application;
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
