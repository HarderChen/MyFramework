package com.example.myframework.mvc.model;
/**
 * Created by Administrator on 2018/11/2 0002.
 */

public class OauthToken {

    private String accessToken;

    private String scope;

    public OauthToken() {

    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
