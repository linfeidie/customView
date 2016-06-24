package com.stay4it.testrxjavaandretrofit.service;

import com.stay4it.testrxjavaandretrofit.http.HttpResult2;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.subjects.Subject;

public interface MovieService4 {
    @GET("top250")
    Observable<HttpResult2<List<Subject>>> getTopMovie(@Query("start") int start, @Query("count") int count);
}
