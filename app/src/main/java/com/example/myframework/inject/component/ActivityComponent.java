package com.example.myframework.inject.component;

import com.example.myframework.inject.ActivityScope;
import com.example.myframework.inject.module.ActivityModule;
import com.example.myframework.inject.module.AppModule;
import com.example.myframework.ui.activity.LoginActivity;
import com.example.myframework.ui.activity.MainActivity;

import dagger.Component;

/**
 * Created by 陈行 on 2018/11/16 0016.
 */
@ActivityScope
@Component(modules = ActivityModule.class , dependencies = AppModule.class)
public interface ActivityComponent {
    void inject(LoginActivity activity);
    void inject(MainActivity activity);
}
