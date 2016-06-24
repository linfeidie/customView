package com.stay4it.testrxjavaandretrofit.service;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubService {
    @GET("users/{user}/repos")
    Call<String> listRepos(@Path("user") String user);
}
