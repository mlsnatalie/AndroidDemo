package com.example.androiddemo.xiangxue.demo.observer;

public class ObservableCreate<T> extends Observable<T> {

    ObservableOnSubscribe<T> source;

    public ObservableCreate(ObservableOnSubscribe<T> source) {
        this.source = source;
    }

    @Override
    public void subscribe(Observer<T> observer) {
        super.subscribe(observer);
    }

    @Override 
    protected void subscribeActual(Observer<T> observer) {
        CreateEmitter<T> createEmitter = new CreateEmitter<>(observer);
        observer.onSubscribe();
        source.subscribe(createEmitter);

    }

    static final class CreateEmitter<T> implements Emitter<T> {

        Observer<T> observer;

        public CreateEmitter(Observer<T> observer) {
            this.observer = observer;
        }

        @Override
        public void onNext(T t) {
            observer.onNext(t);
        }

        @Override
        public void onError(Throwable throwable) {
            observer.onError(throwable);
        }

        @Override
        public void complete() {
            observer.onComplete();
        }
    }
}
