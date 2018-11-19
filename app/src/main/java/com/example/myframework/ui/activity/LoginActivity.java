package com.example.myframework.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.widget.Button;

import com.example.myframework.R;
import com.example.myframework.mvc.contract.ILoginContract;
import com.example.myframework.mvc.model.BasicToken;
import com.example.myframework.mvc.presenter.LoginPresenter;
import com.example.myframework.ui.activity.base.BaseActivity;
import com.unstoppable.submitbuttonview.SubmitButton;

import butterknife.BindView;

public class LoginActivity extends BaseActivity<LoginPresenter> implements ILoginContract.View {

    @BindView(R.id.user_name_et)
    TextInputEditText userNameEt;
    @BindView(R.id.user_name_layout)
    TextInputLayout userNameLayout;
    @BindView(R.id.password_et)
    TextInputEditText passwordEt;
    @BindView(R.id.password_layout)
    TextInputLayout passwordLayout;
    @BindView(R.id.login_bn)
    SubmitButton loginBn;
    @BindView(R.id.oauth_login_bn)
    Button oauthLoginBn;

    @Override
    public void onGetTokenSuccess(BasicToken basicToken) {

    }

    @Override
    public void onGetTokenError(String errorMsg) {

    }

    @Override
    public void onLoginComplete() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        loginBn.setOnResultEndListener(new SubmitButton.OnResultEndListener() {
            @Override
            public void onResultEnd() {

            }
        });
    }
}
