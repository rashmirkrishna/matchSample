package com.matchapp.rashmi.matchsample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    private String login;
    private Integer id;
    private String avatar_url;
    private String gravatar_id;
    private String url;
    private String followers_url;
    private String following_url;
    private String repos_url;
    private String type;

    public String getLogin() {
        return login;
    }

    public Integer getId() {
        return id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getGravatar_id() {
        return gravatar_id;
    }

    public String getUrl() {
        return url;
    }

    public String getFollowers_url() {
        return followers_url;
    }

    public String getFollowing_url() {
        return following_url;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public String getType() {
        return type;
    }
}

