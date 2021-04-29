package com.example.androiddemo.xiangxue.demo.observer;

/**
 * 装饰类
 * @param <T>
 * @param <R>
 */
public abstract class ObservableDecorator<T,R> extends Observable<T> {

    protected final ObservableSource<T> source;

    public ObservableDecorator(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }
}
