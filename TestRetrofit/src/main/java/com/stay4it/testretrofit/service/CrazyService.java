package com.stay4it.testretrofit.service;

import com.stay4it.testretrofit.bean.Response;
import com.stay4it.testretrofit.bean.Result;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface CrazyService {

    @FormUrlEncoded
    @POST("user/login")
    Observable<Response<Result>> login(@Field("APP_VERSION") String APP_VERSION,
                                       @Field("DEVICE_UUID") String DEVICE_UUID,
                                       @Field("DEVICE_MODEL") String DEVICE_MODEL,
                                       @Field("DEVICE_VERSION") String DEVICE_VERSION,
                                       @Field("APP_TOKEN") String APP_TOKEN,
                                       @Field("email") String email,
                                       @Field("password") String password);
}
