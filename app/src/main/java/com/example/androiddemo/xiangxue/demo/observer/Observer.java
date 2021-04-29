package com.example.androiddemo.xiangxue.demo.observer;

/**
 * 抽象的观察者
 *
 */

public interface Observer<T> {
    //订阅
    void onSubscribe();
    //推送消息
    void onNext(T t);
    //错误提示
    void onError(Throwable throwable);
    //完成消息推送
    void onComplete();
}
