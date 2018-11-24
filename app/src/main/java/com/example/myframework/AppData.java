package com.example.myframework;

import com.example.myframework.dao.AuthUser;
import com.example.myframework.mvc.model.User;
import com.thirtydegreesray.dataautoaccess.annotation.AutoAccess;

public enum AppData {
    INSTANCE;

    @AutoAccess(dataName = "appData_loggedUser")
    User loggedUser;
    @AutoAccess(dataName = "appData_authUser")
    AuthUser authUser;


    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public AuthUser getAuthUser() {
        return authUser;
    }

    public void setAuthUser(AuthUser authUser) {
        this.authUser = authUser;
    }
}
