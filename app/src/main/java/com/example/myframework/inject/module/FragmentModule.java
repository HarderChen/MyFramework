package com.example.myframework.inject.module;

import android.content.Context;

import com.example.myframework.inject.FragmentScope;
import com.example.myframework.ui.fragment.base.BaseFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 陈行 on 2018/11/16 0016.
 */
@Module
public class FragmentModule {
    private BaseFragment mFragment;

    public FragmentModule(BaseFragment fragment) {
        mFragment = fragment;
    }

    @Provides
    @FragmentScope
    public BaseFragment provideFragment(){
        return mFragment;
    }

    @Provides
    @FragmentScope
    public Context provideContext(){
        return mFragment.getActivity();
    }
}
