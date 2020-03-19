package com.example.mvvm.model;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class UserRepository {

    private static final String GITHUB_BASE_URL = "https://api.github.com";

    private static UserRepository instance;
    private GitHubUsers gitHubUsers;

    private UserRepository() {
        final Gson gson =
                new GsonBuilder().create();
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(GITHUB_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        gitHubUsers = retrofit.create(GitHubUsers.class);
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public Observable<List<UserRepo>> getUserList() {
        Observable<List<UserRepo>> u=gitHubUsers.getUser();
        return gitHubUsers.getUser();
    }
    public Observable<List<UserRepo>> getUser2() {
        return gitHubUsers.getUser2();
    }
}
