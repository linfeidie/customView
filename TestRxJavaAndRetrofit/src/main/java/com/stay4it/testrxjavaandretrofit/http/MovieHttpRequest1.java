package com.stay4it.testrxjavaandretrofit.http;
import com.stay4it.testrxjavaandretrofit.service.MovieService3;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MovieHttpRequest1 {
    public static final String BASE_URL = "https://api.douban.com/v2/movie/";
    private static final int DEFAULT_TIMEOUT = 5;
    private Retrofit retrofit;
    private MovieService3 movieService3;

    private static class SingletonHttpRequest{
        private static final MovieHttpRequest1 INSTANCE = new MovieHttpRequest1();
    }

    public static MovieHttpRequest1 getInstance(){
        return SingletonHttpRequest.INSTANCE;
    }

    private MovieHttpRequest1(){
        OkHttpClient.Builder builder=new OkHttpClient().newBuilder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        movieService3=retrofit.create(MovieService3.class);

    }

    public void getTopMovie(Subscriber<String> subscriber, int start, int count){
        movieService3.getTopMovie(start, count)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


}
