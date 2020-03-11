package com.algorithm.learn.DesignPattern.Factory.Factory;

/**
 * Created by Administrator on 2020/3/11.
 */
public class LaRouJiaMoFactory extends RouJiaMoFactory{

    @Override
    public RouJiaMo createRouJiaMo() {
        return new LaRouJiaMo();
    }
}
