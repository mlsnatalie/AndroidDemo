package com.example.androiddemo.xiangxue.demo.observer;

public abstract class Observable<T> implements ObservableSource<T> {

    @Override
    public void subscribe(Observer<T> observer) {

        //我们把这个订阅功能让observer的子类去完成
        subscribeActual(observer);
    }

    protected abstract void subscribeActual(Observer<T> observer);

    //创造被观察者的实例
    public static <T> Observable<T> create(ObservableOnSubscribe<T> source) {
        return new ObservableCreate(source);
    }

    //创建被观察者
    public <U> Observable<U> map(Function<T,U> function) {
        return new ObservableMap(this, function);
    }

    //被观察者切换线程
    public final Observable<T> subscribeOn() {
        return new ObservableSubscribeOn<>(this);
    }

    //观察者切换线程
    public final Observable<T> observerOn() {
        return new ObservableObserveOn<>(this);
    }
}
