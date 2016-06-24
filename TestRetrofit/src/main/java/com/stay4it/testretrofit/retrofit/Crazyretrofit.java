package com.stay4it.testretrofit.retrofit;


import com.stay4it.testretrofit.bean.Result;
import com.stay4it.testretrofit.http.BaseService;
import com.stay4it.testretrofit.service.CrazyService;

import rx.Observable;
import rx.Subscriber;


public class Crazyretrofit extends BaseService<CrazyService> {
    private static final String TAG = "rxjava";
    private CrazyService crazyService;


    @Override
    protected void getService() {
        crazyService = retrofit.create(CrazyService.class);
    }

    public void login(Subscriber<Result> subscriber, String a, String b, String c, String d,
                      String e, String email, String pass) {
        Observable observable = crazyService.login(a, b, c, d, e, email, pass)
                .map(new HttpResponse<Result>());

        toSubscribe(observable, subscriber);
    }

//    Func1 f = new Func1<String, HttpResponse<Result>>() {
//        @Override
//        public HttpResponse<Result> call(String s) {
//            Log.d(TAG, "call: " + s);
//            return JSONObject.parseObject(s, new TypeReference<HttpResponse<Result>>() {
//            });
//        }
//    };
}
