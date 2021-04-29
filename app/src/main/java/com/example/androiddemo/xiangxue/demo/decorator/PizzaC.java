package com.example.androiddemo.xiangxue.demo.decorator;

public class PizzaC extends Decorator {
    private Pizza pizza;
    public PizzaC(Pizza pizza) {
        this.pizza = pizza;
    }


    @Override
    public String getName() {
        return pizza.getName() + "+洋葱";
    }

    @Override
    public Double getPrice() {
        return pizza.getPrice() + 15;
    }

}
