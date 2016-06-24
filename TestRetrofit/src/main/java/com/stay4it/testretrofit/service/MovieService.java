package com.stay4it.testretrofit.service;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface MovieService {

    @GET("top250")
    Observable<String> getTopMovie(@Query("start") int start, @Query("count") int count);

}
