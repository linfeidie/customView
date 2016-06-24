package com.stay4it.testretrofit.http;

import android.util.Log;

import com.stay4it.testretrofit.bean.Response;
import com.stay4it.testretrofit.config.BaseUrl;
import com.stay4it.testretrofit.config.Constant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


public abstract class BaseService<T> {

    public static final String BASE_URL = BaseUrl.CRAZY;
    private static final int DEFAULT_TIMEOUT = 5;
    private static final String TAG = "rxjava";

    protected Retrofit retrofit;
    protected T service;

    public BaseService() {

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        HttpLoggingInterceptor loggingInterceptor =new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        httpClientBuilder.addInterceptor(loggingInterceptor);

        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        getService();
    }


    protected <T> void toSubscribe(Observable<T> ob, Subscriber<T> sub) {
        ob.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(sub);
    }

    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    public class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

        @Override
        public T call(HttpResult<T> tHttpResult) {
            if (tHttpResult.getCount() == 0) {
                throw new ApiException(100);
            }

            //TODO 这里根据需要添加错误代码及处理流程
            return tHttpResult.getSubjects();
        }
    }


    public class HttpResponse<T> implements Func1<Response<T>, T> {

        @Override
        public T call(Response<T> tResponse) {
            if (!Constant.HTTP_OK.equals(tResponse.getStatus())) {
                Log.d(TAG, "call: " + tResponse.getCode() + "");
                throw new ApiException(2);
            }
            return tResponse.getData();
        }
    }

    //    Func1 f = new Func1<String, HttpResult<T>>() {
//
//        @Override
//        public HttpResult<T> call(String s) {
//
//            return JSONObject.parseObject(s, new TypeReference<HttpResult<T>>() {
//            });
//        }
//    };
    protected abstract void getService();

}
