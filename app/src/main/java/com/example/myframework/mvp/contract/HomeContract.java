package com.example.myframework.mvp.contract;

import com.example.myframework.mvp.contract.base.BaseContract;

/**
 * Created by 陈行 on 2018/12/2.
 */

public interface HomeContract {

    interface View extends BaseContract.View{

    }

    interface Presenter extends BaseContract.Presenter<HomeContract.View>{

    }
}
