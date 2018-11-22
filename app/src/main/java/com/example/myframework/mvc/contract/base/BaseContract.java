package com.example.myframework.mvc.contract.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2018/11/2 0002.
 */

public interface BaseContract {
    interface View{
        void showProgressDialog(String content);

        void dismissProgressDialog();

        ProgressDialog getProgressDialog(String content);

        void showTipDialog(String content);

        void showConfirmDialog(String msn, String title, String confirmText
                , DialogInterface.OnClickListener confirmListener);

        void showToast(String message);

        void showInfoToast(String message);

        void showSuccessToast(String message);

        void showErrorToast(String message);

        void showWarningToast(String message);

        void showLoading();

        void hideLoading();

        void showLoginPage();

    }

    interface Presenter<V extends BaseContract.View>{
        void onSaveInstanceState(Bundle outState);
        void onRestoreInstanceState(Bundle outState);
        void attachView(@NonNull V view);
        void detachView();
        /**
         * view initialized, you can init view data
         */
        void onViewInitialized();
        @Nullable
        Context getContext();
    }
}
