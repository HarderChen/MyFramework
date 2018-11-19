package com.example.myframework.inject;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by 陈行 on 2018/11/16 0016.
 */
@Documented
@Scope
@Retention(RUNTIME)
public @interface FragmentScope {
}
