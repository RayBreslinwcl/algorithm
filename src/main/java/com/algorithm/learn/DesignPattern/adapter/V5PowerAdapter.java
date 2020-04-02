package com.algorithm.learn.DesignPattern.adapter;

public class V5PowerAdapter implements V5Power {
    //组合的方式
    private V220Power v220Power;

    public V5PowerAdapter(V220Power v220Power) {
        this.v220Power = v220Power;
    }

    @Override
    public int provideV5Power() {
//        return 0;

        int power=v220Power.provideV220Power();
        /**
         * 修改操作
         */
        System.out.println("经过操作，电压已经修改到了5V");
        return 5;

    }
}
