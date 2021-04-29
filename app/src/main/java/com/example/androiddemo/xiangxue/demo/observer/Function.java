package com.example.androiddemo.xiangxue.demo.observer;

/**
 * 实现转换与传递的功能
 */
public interface Function<T,R> {
    //对输入值进行一个计算，得到一个结果，传递给下游，起转换对作用
    R apply(T t);
}
