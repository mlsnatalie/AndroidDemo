package com.example.androiddemo.xiangxue.demo;


import com.example.androiddemo.xiangxue.demo.observer.Emitter;
import com.example.androiddemo.xiangxue.demo.observer.Function;
import com.example.androiddemo.xiangxue.demo.observer.Observable;
import com.example.androiddemo.xiangxue.demo.observer.ObservableOnSubscribe;
import com.example.androiddemo.xiangxue.demo.observer.Observer;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        MObservable mObservable = new MObservable();
//        MObserver mObserver = new MObserver("小双");
//
//        mObservable.add(mObserver);
//        mObserver.update("开启通知");


        //观察者模式
        Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(Emitter<String> emitter) {
                emitter.onNext("谢义双发送消息：");
            }
        }).map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s + "网络连接成功++";
            }
        }).map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s + "数据库连接成功++";
            }
        }).map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s + "文件系统连接成功++";
            }
        }).map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                System.out.println("上游：" + Thread.currentThread().getName());
                return s + "可以登录++";
            }
        })
                .subscribeOn()
                .observerOn()
                .subscribe(new Observer() {
            @Override
            public void onSubscribe() {
                System.out.println("订阅：" + Thread.currentThread().getName());
            }

            @Override
            public void onNext(Object s) {
                System.out.println("下游：" + Thread.currentThread().getName());
                System.out.println("收到消息：" + (String) s);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        });

        //装饰器模式
//        Pizza x = new BasePizza();
//        PizzaA p = new PizzaA(new PizzaB(new PizzaC(x)));
//        p.show();
    }
}
