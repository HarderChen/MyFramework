package com.example.myframework.mvc.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/11/2 0002.
 */

public class BasicToken {
    private int id;
    String url;
    String token;
    private Date createdAt;
    private Date updateAt;
    List<String>scopes;

    public BasicToken() {

    }

    public static BasicToken generateFromOauthToken(OauthToken oauthToken){
        BasicToken basicToken = new BasicToken();
        basicToken.setToken(oauthToken.getAccessToken());
        basicToken.setScopes(Arrays.asList(oauthToken.getScope().split(",")));
        return basicToken;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public List<String> getScopes() {
        return scopes;
    }

    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }
}
