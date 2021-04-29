package com.example.androiddemo.xiangxue.demo.observer;

/**
 * 定义了发消息的api
 * @param <T>
 */
public interface Emitter<T> {

    void onNext(T t);
    void onError(Throwable throwable);
    void complete();
}
