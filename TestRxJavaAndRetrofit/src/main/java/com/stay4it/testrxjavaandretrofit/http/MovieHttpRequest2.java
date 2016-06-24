package com.stay4it.testrxjavaandretrofit.http;

import com.stay4it.testrxjavaandretrofit.service.MovieService4;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subjects.Subject;

public class MovieHttpRequest2 {
    public static final String BASE_URL = "https://api.douban.com/v2/movie/";
    private static final int DEFAULT_TIMEOUT = 5;
    private Retrofit retrofit;
    private MovieService4 movieService4;

    private static class SingletonHttpRequest{
        private static final MovieHttpRequest2 INSTANCE = new MovieHttpRequest2();
    }

    public static MovieHttpRequest2 getInstance(){
        return SingletonHttpRequest.INSTANCE;
    }

    private MovieHttpRequest2(){
        OkHttpClient.Builder builder=new OkHttpClient().newBuilder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        movieService4=retrofit.create(MovieService4.class);
    }


    /**
     * 统一处理Http的返回
     * 将HttpResult的Data部分剥离出来返回给subscriber
     *
     * 也就是说数据原本是HttpResult2<T>，现通过Map将其转换为T
     */
    private class HttpResultFunc<T> implements Func1<HttpResult2<T>, T> {

        @Override
        public T call(HttpResult2<T> httpResult) {

            if (httpResult.getCount() == 0) {
                throw new ApiException(9527);
            }
            //TODO 这里根据需要添加错误代码及处理流程
            return httpResult.getSubjects();
        }
    }




    /**
     * 请注意map的使用
     * 原来是HttpResult2类型的，转换成了httpResult.getSubjects()
     */
    public void getTopMovie(Subscriber<List<Subject>> subscriber, int start, int count){
        movieService4.getTopMovie(start, count)
                .map(new HttpResultFunc<List<Subject>>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }



}
