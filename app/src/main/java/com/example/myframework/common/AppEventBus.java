package com.example.myframework.common;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by 陈行 on 2018/11/20 0020.
 */

public enum  AppEventBus {
    INSTANCE;

    AppEventBus() {
        init();
    }

    private EventBus eventBus;

    private void init(){
        eventBus=EventBus.builder().installDefaultEventBus();
    }

    public EventBus getEventBus(){
        return eventBus;
    }
}
