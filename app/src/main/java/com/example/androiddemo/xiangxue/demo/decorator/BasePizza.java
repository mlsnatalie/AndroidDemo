package com.example.androiddemo.xiangxue.demo.decorator;

public class BasePizza extends Pizza {

    @Override
    public String getName() {
        this.name = "披萨";
        return this.name;
    }

    @Override
    public Double getPrice() {
        return 50D;
    }
}
