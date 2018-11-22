package com.example.myframework.ui.activity.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.WindowManager;

import com.example.myframework.AppData;
import com.example.myframework.mvc.contract.base.BaseContract;
import com.example.myframework.util.WindowUtil;
import com.thirtydegreesray.dataautoaccess.DataAutoAccess;
import com.thirtydegreesray.dataautoaccess.annotation.AutoAccess;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/11/2 0002.
 */

public abstract class BaseActivity<P extends BaseContract.Presenter> extends AppCompatActivity implements BaseContract.View {

    protected P mPresenter;
    private static BaseActivity curActivity;
    protected boolean isAlive = true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DataAutoAccess.getData(this, savedInstanceState);

        if(mPresenter != null) {
            mPresenter.onRestoreInstanceState(savedInstanceState == null ?
                    getIntent().getExtras() : savedInstanceState);
            mPresenter.attachView(this);
        }

        getScreenSize();
        if(getContentView() != 0){
            setContentView(getContentView());
            ButterKnife.bind(getActivity());
        }
        initActivity();

        initView(savedInstanceState);

        if(mPresenter != null) mPresenter.onViewInitialized();

        if(isFullScreen){
            intoFullScreen();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //系统由于内存不足而杀死activity，此时保存数据
        DataAutoAccess.saveData(this, outState);
        if(mPresenter != null) mPresenter.onSaveInstanceState(outState);
        if(curActivity.equals(this)){
            DataAutoAccess.saveData(AppData.INSTANCE, outState);
        }
    }

    @LayoutRes
    protected abstract int getContentView();

    @AutoAccess boolean isFullScreen = false;

    @CallSuper
    protected void initView(Bundle savedInstanceState){

    }


    @Override
    public void showInfoToast(String message) {

    }

    @Override
    public void showSuccessToast(String message) {

    }

    @Override
    public void showErrorToast(String message) {

    }

    @Override
    public void showWarningToast(String message) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showLoginPage() {

    }

    @NonNull
    protected BaseActivity getActivity() {
        return this;
    }
    @CallSuper
    protected void initActivity(){

    }
    protected void intoFullScreen() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        if(toolbar != null) toolbar.setVisibility(View.GONE);
        isFullScreen = true;
    }
    private void getScreenSize(){
        if(WindowUtil.screenHeight == 0 ||
                WindowUtil.screenWidth == 0){
            Display display = getWindowManager().getDefaultDisplay();
            WindowUtil.screenWidth = display.getWidth();
            WindowUtil.screenHeight = display.getHeight();
        }
    }
}
