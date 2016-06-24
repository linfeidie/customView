package com.stay4it.testretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.stay4it.testretrofit.bean.Result;
import com.stay4it.testretrofit.http.ProgressSubscriber;
import com.stay4it.testretrofit.listener.SubscribeOnNextListener;
import com.stay4it.testretrofit.retrofit.Crazyretrofit;
import com.stay4it.testretrofit.retrofit.MovieRetrofit;
import com.stay4it.testretrofit.utils.PhoneUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "rxjava";

    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.password)
    EditText pass;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.show)
    TextView show;

    private MovieRetrofit mMovieRetrofit;
    private Crazyretrofit mCrazyretrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        test3();

        mMovieRetrofit = new MovieRetrofit();
        mCrazyretrofit = new Crazyretrofit();

//        mMovieRetrofit.getTopMovie(new ProgressSubscriber<List<Subject>>(
//                new SubscribeOnNextListener<List<Subject>>() {
//                    @Override
//                    public void onNext(List<Subject> subjects) {
//                        show.setText(subjects.get(0).getYear());
//                    }
//                }, MainActivity.this, true), 0, 10);


    }

    @OnClick(R.id.login)
    public void login() {

        String app_version = PhoneUtils.getAppVer(MainActivity.this);
        String device_model = PhoneUtils.getIMEI(MainActivity.this);


        mCrazyretrofit.login(new ProgressSubscriber<Result>(new SubscribeOnNextListener<Result>() {
                    @Override
                    public void onNext(Result resultBean) {
                        Log.d(TAG, "onNext: " + "login success");
                    }
                }, MainActivity.this, true), app_version, device_model, "2", "9.2", null,
                "lipengfeng@windward.com.cn", "123456");
    }


    private void test(){
        Observable observable=Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("onNext");
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

            }
        };



        //进行订阅---> 订阅observer
        observable.subscribe(observer);
        //进行订阅---> 订阅subscriber
        observable.subscribe(subscriber);
        //进行订阅---> 订阅ACTION
        observable.subscribe();
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


    //注意和理解这个名字OnSubscribe
    private void test3(){
        final String [] names={"name1","name2","name3"};
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                System.out.println("----> call ");
                subscriber.onNext(names[0]);
                subscriber.onCompleted();
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onNext(String s) {
                System.out.println("----> name="+s);
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

            }
        };

        Observable.from(names).map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return null;
            }
        }).subscribe(subscriber);
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




}
