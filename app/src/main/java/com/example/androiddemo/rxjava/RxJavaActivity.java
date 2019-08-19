package com.example.androiddemo.rxjava;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androiddemo.R;
import io.reactivex.*;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * @author Menglingshuai
 * @date 2019-08-16.
 * email：mlsnatalie@163.com
 * description：具体例子看https://juejin.im/post/5b17560e6fb9a01e2862246f#heading-60
 */
public class RxJavaActivity extends AppCompatActivity {
    private String TAG = "RxJava";
    private Observable<Integer> observable;
    private Observer<Integer> observer;
    private Integer i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        initObservable();
        initObserver();

        /**
         * 订阅
         */
        observable.subscribe(observer);

//        just();

        interval();
        range();
        fromArray();
        map();
        zip();
        subscribeOn();
        observeOn();
        filter();
    }

    /**
     * 被观察者
     */
    private void initObservable() {
        observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                Log.d(TAG, "=========================currentThread name: " + Thread.currentThread().getName());
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        });
    }

    /**
     * 观察者
     */
    private void initObserver() {
        observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "======================onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "======================onNext " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "======================onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "======================onComplete");
            }
        };
    }

    /**
     * just操作符，创建一个被观察者，并发送事件，发送的事件不可以超过10个以上。
     */
    private void just() {
        Observable.just(1, 2, 3)
                .subscribe(new Observer < Integer > () {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "=================onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "=================onNext " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "=================onError ");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "=================onComplete ");
                    }
                });
    }

    /**
     * fromArray操作符，这个方法和 just() 类似，只不过 fromArray 可以传入多于10个的变量，并且可以传入一个数组。
     */
    private void fromArray() {
        Integer array[] = {1, 2, 3, 4};
        Observable.fromArray(array)
                .subscribe(new Observer < Integer > () {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "=================onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "=================onNext " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "=================onError ");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "=================onComplete ");
                    }
                });
    }

    /**
     * interval操作符，每隔一段时间就会发送一个事件，这个事件是从0开始，不断增1的数字。可以用来做定时任务。
     */
    private void interval() {
        Observable.interval(4, TimeUnit.SECONDS)
                .subscribe(new Observer < Long > () {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "==============onSubscribe ");
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.d(TAG, "==============onNext " + aLong);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 同时发送一定范围的事件序列。
     */
    private void range() {
        Observable.range(2, 5)
                .subscribe(new Observer < Integer > () {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "==============onSubscribe ");
                    }

                    @Override
                    public void onNext(Integer aLong) {
                        Log.d(TAG, "==============onNext " + aLong);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 转换操作符，map 可以将被观察者发送的数据类型转变成其他的类型
     */
    private void map() {
        Observable.just(1, 2, 3)
                .map(new Function< Integer, String >() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return "I'm " + integer;
                    }
                })
                .subscribe(new Observer < String > () {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "===================onSubscribe");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "===================onNext " + s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 会将多个被观察者合并，根据各个被观察者发送事件的顺序一个个结合起来，最终发送的事件数量会与源 Observable 中最少事件的数量一样。
     */
    private void zip() {
        Observable.zip(Observable.intervalRange(1, 5, 1, 1, TimeUnit.SECONDS)
                        .map(new Function<Long, String>() {
                            @Override
                            public String apply(Long aLong) throws Exception {
                                String s1 = "A" + aLong;
                                Log.d(TAG, "===================A 发送的事件 " + s1);
                                return s1;
                            }}),
                Observable.intervalRange(1, 6, 1, 1, TimeUnit.SECONDS)
                        .map(new Function<Long, String>() {
                            @Override
                            public String apply(Long aLong) throws Exception {
                                String s2 = "B" + aLong;
                                Log.d(TAG, "===================B 发送的事件 " + s2);
                                return s2;
                            }
                        }),
                new BiFunction<String, String, String>() {
                    @Override
                    public String apply(String s, String s2) throws Exception {
                        String res = s + s2;
                        return res;
                    }
                })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "===================onSubscribe ");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, "===================onNext " + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "===================onError ");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "===================onComplete ");
                    }
                });
    }

    /**
     * 指定被观察者的线程，要注意的时，如果多次调用此方法，只有第一次有效。用于主线程和子线程之类的。
     */
    private void subscribeOn() {
        Observable.create(new ObservableOnSubscribe < Integer > () {
            @Override
            public void subscribe(ObservableEmitter < Integer > e) throws Exception {
                Log.d(TAG, "=========================currentThread name: " + Thread.currentThread().getName());
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        })
                //.subscribeOn(Schedulers.newThread())
                .subscribe(new Observer < Integer > () {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "======================onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "======================onNext " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "======================onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "======================onComplete");
                    }
                });
    }

    /**
     * 指定观察者的线程，每指定一次就会生效一次。
     */
    private void observeOn() {
        Observable.just(1, 2, 3)
                .observeOn(Schedulers.newThread())
                .flatMap(new Function < Integer, ObservableSource< String >> () {
                    @Override
                    public ObservableSource < String > apply(Integer integer) throws Exception {
                        Log.d(TAG, "======================flatMap Thread name " + Thread.currentThread().getName());
                        return Observable.just("chan" + integer);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer < String > () {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "======================onSubscribe");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, "======================onNext Thread name " + Thread.currentThread().getName());
                        Log.d(TAG, "======================onNext " + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "======================onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "======================onComplete");
                    }
                });
    }

    /**
     * 通过一定逻辑来过滤被观察者发送的事件，如果返回 true 则会发送事件，否则不会发送。
     */
    private void filter() {
        Observable.just(1, 2, 3)
                .filter(new Predicate< Integer >() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer < 2;
                    }
                })
                .subscribe(new Observer < Integer > () {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "==================onSubscribe ");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        i += integer;
                        Log.d(TAG, "==================onNext " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "==================onError ");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "==================onComplete ");
                    }
                });
    }
}
