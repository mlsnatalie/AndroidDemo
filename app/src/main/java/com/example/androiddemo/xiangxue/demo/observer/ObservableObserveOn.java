package com.example.androiddemo.xiangxue.demo.observer;

import android.os.Handler;
import android.os.Looper;

public class ObservableObserveOn<T> extends ObservableDecorator<T, T> {

//    public static ExecutorService executorService = Executors.newCachedThreadPool();


    public ObservableObserveOn(ObservableSource<T> source) {
        super(source);
    }

    @Override
    protected void subscribeActual(Observer<T> observer) {
        SubscribeOnObserver<T> parent = new SubscribeOnObserver<>(observer);
        observer.onSubscribe();
        source.subscribe(parent);
//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                source.subscribe(parent);
//            }
//        });

    }

    static final class SubscribeOnObserver<T> implements Observer<T> {

        final Observer<T> actual;
        private Handler handler;

        public SubscribeOnObserver(Observer<T> actual) {
            this.actual = actual;
            handler = new Handler(Looper.getMainLooper());
        }

        @Override
        public void onSubscribe() {
            actual.onSubscribe();
        }

        @Override
        public void onNext(T t) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    actual.onNext(t);
                }
            });
        }

        @Override
        public void onError(Throwable throwable) {
            actual.onError(throwable);
        }

        @Override
        public void onComplete() {
            actual.onComplete();
        }
    }
}
