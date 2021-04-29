package com.example.androiddemo.xiangxue.demo.decorator;


/**
 * 装饰类
 */
public abstract class Decorator extends Pizza {

    @Override
    public Double getPrice() {
        return this.getPrice();
    }

    public void show() {
        System.out.println(getName()+ "  " + getPrice());
    }
}
