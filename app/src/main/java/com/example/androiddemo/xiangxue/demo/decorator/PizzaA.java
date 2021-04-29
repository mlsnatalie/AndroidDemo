package com.example.androiddemo.xiangxue.demo.decorator;

public class PizzaA extends Decorator {
    private Pizza pizza;
    public PizzaA(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getName() {
        return pizza.getName() + "+菠萝";
    }

    @Override
    public Double getPrice() {
        return pizza.getPrice() + 10;
    }

}
