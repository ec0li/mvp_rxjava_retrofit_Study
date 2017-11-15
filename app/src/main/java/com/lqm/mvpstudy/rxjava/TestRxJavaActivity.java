package com.lqm.mvpstudy.rxjava;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lqm.mvpstudy.R;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


/**
 * user：lqm
 * desc：RxJava学习
 */

public class TestRxJavaActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
    }


    {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

            }
        }).subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe(new Action1<String>() {
                @Override
                public void call(String s) {

                }
            });



    }
}
