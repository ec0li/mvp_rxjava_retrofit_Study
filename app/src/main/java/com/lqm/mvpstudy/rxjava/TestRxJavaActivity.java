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


//    {
//
//        final List<Bitmap> imageCollectorView = new ArrayList<>();
//        File[] folders = new File[0];
//        Observable.from(folders)
//            .flatMap(new Func1<File, Observable<File>>() {
//                @Override
//                public Observable<File> call(File file) {
//                    return Observable.from(file.listFiles());
//                }
//            })
//            .filter(new Func1<File, Boolean>() {
//                @Override
//                public Boolean call(File file) {
//                    return file.getName().endsWith(".png");
//                }
//            })
//            .map(new Func1<File, Bitmap>() {
//                @Override
//                public Bitmap call(File file) {
//                    return getBitmapFromFile(file);
//                }
//            })
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(new Action1<Bitmap>() {
//                @Override
//                public void call(Bitmap bitmap) {
//                    imageCollectorView.add(bitmap);
//                }
//            });
//
//
//    }

}
