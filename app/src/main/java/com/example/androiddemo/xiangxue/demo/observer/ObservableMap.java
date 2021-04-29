package com.example.androiddemo.xiangxue.demo.observer;

public class ObservableMap<T,U> extends ObservableDecorator<T,U> {

    final Function<T,U> function;

    public ObservableMap(ObservableSource<T> source, Function<T, U> function) {
        super(source);
        this.function = function;
    }


    @Override
    protected void subscribeActual(Observer<T> observer) {
        source.subscribe(new MapObserver(observer, function));
    }

    static final class MapObserver<T,U> extends BasicFuseableObserver<T,U> {

        final Function<T,U> mapper;

        public MapObserver(Observer<U> actual, Function<T, U> mapper) {
            super(actual);
            this.mapper = mapper;
        }

        @Override
        public void onNext(T t) {
            U apply = mapper.apply(t);
            actual.onNext(apply);
        }
    }
}
