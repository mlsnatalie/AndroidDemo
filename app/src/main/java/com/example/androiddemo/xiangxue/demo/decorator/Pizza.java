package com.example.androiddemo.xiangxue.demo.decorator;

public abstract class Pizza {
    protected String name;

    public String getName() {
        return this.name;
    }

    public abstract Double getPrice();
}
