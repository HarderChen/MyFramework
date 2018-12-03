package com.example.myframework.mvp.presenter;

import com.example.myframework.AppData;
import com.example.myframework.dao.AuthUser;
import com.example.myframework.dao.AuthUserDao;
import com.example.myframework.dao.DaoSession;
import com.example.myframework.http.core.HttpObserver;
import com.example.myframework.http.core.HttpResponse;
import com.example.myframework.mvp.contract.SplashContract;
import com.example.myframework.mvp.model.User;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by 陈行 on 2018/11/26 0026.
 */

public class SplashPresenter extends BasePresenter<SplashContract.View> implements SplashContract.Presenter {

    private AuthUser authUser;

    @Inject
    public SplashPresenter(DaoSession daoSession) {
        super(daoSession);
    }

    @Override
    public void getUser() {
        AuthUserDao authUserDao = daoSession.getAuthUserDao();
        List<AuthUser>users = authUserDao.queryBuilder()
                .where(AuthUserDao.Properties.Selected.eq(true))
                .limit(1)
                .list();
        AuthUser selectUser = users !=null && users.size()>0 ? users.get(0) : null;
        if(selectUser == null){
            List<AuthUser> firstAccount = authUserDao.queryBuilder()
                    .limit(1)
                    .list();
            selectUser = firstAccount !=null && firstAccount.size()>0 ? firstAccount.get(0) : null;
        }
        if(selectUser != null && isExpired(selectUser)){
            authUserDao.delete(selectUser);
            selectUser = null;
        }
        if(selectUser !=null){
            AppData.INSTANCE.setAuthUser(selectUser);
            getUserInfo(selectUser.getAccessToken());
        }else{
            mView.showLoginPage();
        }

    }

    private void getUserInfo(final String accessToken) {
        HttpObserver<User> httpObserver = new HttpObserver<User>() {
            @Override
            public void onSuccess(HttpResponse<User> response) {
                AppData.INSTANCE.setLoggedUser(response.body());
                if (authUser != null){

                }
            }

            @Override
            public void onError(Throwable e) {

            }
        };

    }

    private   boolean isExpired(AuthUser selectUser){
        return  selectUser.getAuthTime().getTime() + selectUser.getExpireIn()*1000 <System.currentTimeMillis();
    }

    @Override
    public void saveAccessToken() {

    }
}
