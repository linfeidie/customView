package com.stay4it.testrxjavaandretrofit.service;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface MovieService2 {
    @GET("top250")
    Observable<String> getTopMovie(@Query("start") int start, @Query("count") int count);
}
