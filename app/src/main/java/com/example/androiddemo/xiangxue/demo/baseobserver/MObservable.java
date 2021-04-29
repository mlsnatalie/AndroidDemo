package com.example.androiddemo.xiangxue.demo.baseobserver;

import java.util.ArrayList;
import java.util.List;

public class MObservable implements Observable {

    List<Observer> observableList = new ArrayList<>();

    public MObservable() {

    }

    @Override
    public void add(Observer observer) {
        observableList.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observableList.remove(observer);
    }

    @Override
    public void pushMessage(Object obj) {
        for (Observer observer : observableList) {
            observer.update(obj);
        }
    }
}
