package com.example.mvvm.model;

import java.util.List;
import retrofit2.http.GET;
import rx.Observable;

public interface GitHubUsers {

    @GET("/users")
    Observable<List<UserRepo>> getUser();

    @GET("/users/pjhyett/followers")
    Observable<List<UserRepo>> getUser2();
}
