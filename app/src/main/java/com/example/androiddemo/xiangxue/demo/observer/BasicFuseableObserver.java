package com.example.androiddemo.xiangxue.demo.observer;

public abstract class BasicFuseableObserver<T,R> implements Observer<T> {

    protected final Observer<R> actual;

    public BasicFuseableObserver(Observer<R> actual) {
        this.actual = actual;
    }

    @Override
    public void onSubscribe() {
        actual.onSubscribe();
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
