package com.example.androiddemo.xiangxue.demo.baseobserver;

public interface Observable {
    void add(Observer observer);
    void remove(Observer observer);
    void pushMessage(Object obj);
}
