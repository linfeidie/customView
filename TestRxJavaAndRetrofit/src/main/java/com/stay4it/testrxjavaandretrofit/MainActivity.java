package com.stay4it.testrxjavaandretrofit;

import android.app.Activity;
import android.os.Bundle;

import com.stay4it.testrxjavaandretrofit.http.MovieHttpRequest1;
import com.stay4it.testrxjavaandretrofit.http.MovieHttpRequest2;
import com.stay4it.testrxjavaandretrofit.service.GithubService;
import com.stay4it.testrxjavaandretrofit.service.LoginService;
import com.stay4it.testrxjavaandretrofit.service.MovieService1;
import com.stay4it.testrxjavaandretrofit.service.MovieService2;
import com.stay4it.testrxjavaandretrofit.util.PhoneUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subjects.Subject;

public class MainActivity extends Activity {
    //public  String TAG="Test";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //test0();
        //test1();
        //test2();
        //test3();
        //test4();

        //testMovieService1();
        //testMovieService2();
        //testMovieService3();
        testMovieService4();
    }


    /**
     * Observable订阅observer还有subscriber
     */
    private void test0(){
        Observable observable=Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("This is message for onNext");
                subscriber.onCompleted();
            }
        });

        Observer<String> observer=new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("----> s="+s);
            }
        };

        Subscriber<String> subscriber=new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("----> s = "+s);
            }
        };

        //observable.subscribe(observer);

       observable.subscribe(subscriber);

    }

    /**
     * Observable除了订阅observer和subscriber以外，还可以订阅Action在此举例说明。
     *
     * 请注意Action0和Action1的区别：
     * Action1的call方法是有一个参数的，而Action0的call方法是没有参数。
     * 这一点从两者的名字也可以区分出来。
     */
    private void test1(){
        Observable observable=Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("This is message for onNext");
                subscriber.onCompleted();
            }
        });


        // 可以实现类型于Subscriber中onNext()的作用
        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println("----> s = "+s);
            }
        };

        // 可以实现类型于Subscriber中onError()的作用
        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                System.out.println("----> throwable = "+throwable.getMessage().toString());
            }
        };

        // 可以实现类型于Subscriber中onCompleted()的作用
        Action0 onCompletedAction = new Action0() {
            @Override
            public void call() {

            }
        };

        observable.subscribe(onNextAction, onErrorAction, onCompletedAction);

    }

    private void test2(){
        String [] names={"name1","name2","name3"};
        Observable.from(names).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println("----> name="+s);
            }
        });
    }


    private void test3(){
        final String [] names={"name1","name2","name3"};
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                System.out.println("----> Observable.OnSubscribe 中的call()方法 ");
                subscriber.onNext(names[0]);
                subscriber.onCompleted();
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onNext(String s) {
                System.out.println("----> name = "+s);
            }
            @Override
            public void onCompleted() {
                System.out.println("----> onCompleted");
            }
            @Override
            public void onError(Throwable e) {

            }
        });
    }


    private void test4(){
        final String [] names={"name1","name2","name3"};
        Subscriber<String> subscriber=new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("----> onNext = "+s);
            }
        };

        Observable.from(names)
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return s + " " + s;
                    }
                })
                .subscribe(subscriber);
    }


    private void test5() {
        final String[] names = {"name1", "name2", "name3"};
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        };

        Observable.from(names).flatMap(new Func1<String, Observable<String>>() {
            @Override
            public Observable<String> call(String s) {
                return null;
            }
        }).subscribe(subscriber);
    }


    /**
     * 需要设置ConverterFactory否则Retrofit只能接收字符串结果
     */
    private void testGithubService(){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(FastJsonConverterFactory.create())
                .baseUrl("https://api.github.com/")
                .build();

        GithubService githubService = retrofit.create(GithubService.class);

        Call<String> call = githubService.listRepos("octocat");

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                System.out.println("---> response.body()="+response.body().toString());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
                System.out.println("---> t.getMessage()="+t.getMessage().toString());
            }
        });
    }

    private void testMovieService1(){
        String baseUrl = "https://api.douban.com/v2/movie/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(FastJsonConverterFactory.create())
                .build();

        MovieService1 movieService1 = retrofit.create(MovieService1.class);
        Call<String> call = movieService1.getTopMovie(0, 5);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                System.out.println("---> response.body()="+response.body().toString());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println("---> t.getMessage()="+t.getMessage().toString());
            }
        });
    }

    /**
     * Retrofit和RxJava的结合使用
     *
     * Retrofit使用Gson转换器(Converter)和RxJava适配器(Adapter).
     *
     * Retrofit和RxJava的结合使用时Service的返回就不再是Call
     * 而是一个Observable，所以可以调用其subscribeOn()和observeOn还有subscribe()方法
     *
     */
    private void testMovieService2(){
        String baseUrl = "https://api.douban.com/v2/movie/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        MovieService2 movieService2 = retrofit.create(MovieService2.class);

        movieService2.getTopMovie(0, 5)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("---> onError()="+e.getMessage().toString());
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("---> onNext()="+s);
                    }
                });

    }

    /**
     * 将Retrofit和OkHttp封装在一起，在此处只用处理Subscriber就行
     * 这种封装比较不错.
     */
    private void testMovieService3(){
       Subscriber<String> subscriber=new Subscriber<String>() {
           @Override
           public void onCompleted() {
               System.out.println("---> onCompleted()");
           }

           @Override
           public void onError(Throwable e) {
               System.out.println("---> onError()="+e.getMessage().toString());
           }

           @Override
           public void onNext(String s) {
               System.out.println("---> onNext()="+s);
           }
       };
        MovieHttpRequest1.getInstance().getTopMovie(subscriber,0,5);
    }

    private void testMovieService4(){
        Subscriber<List<Subject>> subscriber=new Subscriber<List<Subject>>() {
            @Override
            public void onCompleted() {
                System.out.println("---> onCompleted()");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("---> onError()="+e.getMessage().toString());
            }

            @Override
            public void onNext(List<Subject> listHttpResult2) {
                System.out.println("---> listHttpResult2.size()="+listHttpResult2.size());
            }
        };

        MovieHttpRequest2.getInstance().getTopMovie(subscriber,0,5);
    }


    //在网络请求的过程中加入
    private void testLogin() {

        String BASE_URL = "http://api.crazy.windward.cn/";
        int DEFAULT_TIMEOUT = 5;

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        httpClientBuilder.addInterceptor(loggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        LoginService loginService=retrofit.create(LoginService.class);

        String app_version = PhoneUtils.getAppVer(MainActivity.this);
        String device_model = PhoneUtils.getIMEI(MainActivity.this);

    }



}
