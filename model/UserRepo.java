package com.example.mvvm.model;

public class UserRepo {
    private int id;
    private String login;
    private String repos_url;
    private String avatar_url;

    public UserRepo(int id, String login, String repos_url, String avatar_url) {
        this.id = id;
        this.login = login;
        this.repos_url = repos_url;
        this.avatar_url = avatar_url;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }


    public String getRepos_url() {
        return repos_url;
    }


    public String getAvatar_url() {
        return avatar_url;
    }

    @Override
    public String toString() {
        return "UserRepo{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", repos_url='" + repos_url + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                '}';
    }


}
