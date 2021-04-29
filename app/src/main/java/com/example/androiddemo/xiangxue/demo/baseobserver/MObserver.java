package com.example.androiddemo.xiangxue.demo.baseobserver;

public class MObserver implements Observer {

    private String name;
    private String message;

    public MObserver(String name) {
        this.name = name;
    }


    @Override
    public void update(Object obj) {
        System.out.println((String) obj + name);
    }
}
