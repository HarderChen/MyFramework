package com.example.myframework.inject.module;

import android.app.FragmentManager;
import android.content.Context;

import com.example.myframework.inject.ActivityScope;
import com.example.myframework.ui.activity.base.BaseActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 陈行 on 2018/11/16 0016.
 */
@Module
public class ActivityModule {

    private BaseActivity mActivity;

    public ActivityModule(BaseActivity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    @ActivityScope
    public BaseActivity provideActivity(){
        return mActivity;
    }

    @Provides
    @ActivityScope
    public Context provideContext(){
        return  mActivity;
    }

    @Provides
    @ActivityScope
    public FragmentManager provideFragmentManager(){
        return  mActivity.getFragmentManager();
    }
}
