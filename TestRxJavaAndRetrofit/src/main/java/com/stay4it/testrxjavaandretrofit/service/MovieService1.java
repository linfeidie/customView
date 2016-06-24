package com.stay4it.testrxjavaandretrofit.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService1 {
    @GET("top250")
    Call<String> getTopMovie(@Query("start") int start, @Query("count") int count);
}
