package com.example.myframework.inject.component;

import com.example.myframework.inject.FragmentScope;
import com.example.myframework.inject.module.FragmentModule;

import dagger.Component;

/**
 * Created by 陈行 on 2018/11/16 0016.
 */

@FragmentScope
@Component(modules = FragmentModule.class, dependencies = AppComponent.class)
public interface FragmentComponent {

}