package com.example.myframework.inject.component;

import com.example.myframework.AppApplication;
import com.example.myframework.dao.DaoSession;
import com.example.myframework.inject.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by 陈行 on 2018/11/16 0016.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    /**
     * 获取AppApplication
     * @return
     */
    AppApplication getApplication();

    /**
     * 获取数据库Dao
     * @return
     */
    DaoSession getDaoSession();
}
