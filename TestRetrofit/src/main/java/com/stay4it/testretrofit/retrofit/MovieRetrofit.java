package com.stay4it.testretrofit.retrofit;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.stay4it.testretrofit.bean.Subject;
import com.stay4it.testretrofit.http.BaseService;
import com.stay4it.testretrofit.http.HttpResult;
import com.stay4it.testretrofit.service.MovieService;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;


public class MovieRetrofit extends BaseService<MovieService> {

    private static final String TAG = "rxjava";
    private MovieService movieService;

    @Override
    protected void getService() {
        movieService = retrofit.create(MovieService.class);
    }

    public void getTopMovie(Subscriber<List<Subject>> subscriber, int start, int count) {
        Observable observable = movieService.getTopMovie(start, count)
                .map(f).map(new HttpResultFunc<List<Subject>>());

        toSubscribe(observable, subscriber);

    }

    Func1 f = new Func1<String, HttpResult<List<Subject>>>() {
        @Override
        public HttpResult<List<Subject>> call(String s) {

            return JSONObject.parseObject(s, new TypeReference<HttpResult<List
                                            <Subject>>>() {
            });
        }
    };
}
