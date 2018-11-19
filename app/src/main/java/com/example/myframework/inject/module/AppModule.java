package com.example.myframework.inject.module;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.example.myframework.AppApplication;
import com.example.myframework.dao.DBOpenHelper;
import com.example.myframework.dao.DaoMaster;
import com.example.myframework.dao.DaoSession;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 陈行 on 2018/11/16 0016.
 */
@Module
public class AppModule {
    private AppApplication appApplication;

    public AppModule(AppApplication appApplication) {
        this.appApplication = appApplication;
    }

    @Provides
    @Singleton
    public AppApplication provideApplication(){
        return appApplication;
    }

    @NonNull
    @Singleton
    @Provides
    public DaoSession provideDaoSession(){
        DBOpenHelper dbOpenHelper=new DBOpenHelper(appApplication,"framework.db",null);
        SQLiteDatabase db=dbOpenHelper.getWritableDatabase();
        DaoMaster daoMaster=new DaoMaster(db);
        return daoMaster.newSession();
    }
}
