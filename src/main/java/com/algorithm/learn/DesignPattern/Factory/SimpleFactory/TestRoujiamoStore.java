package com.algorithm.learn.DesignPattern.Factory.SimpleFactory;

/**
 * Created by Administrator on 2020/3/11.
 * 【测试简单工厂类】
 * 通过简单工厂类simpleRouJiaMoFactory，实现直接创建对应肉夹馍实例，并且实现销售
 */
public class TestRoujiamoStore {
    private SimpleRouJiaMoFactory simpleRouJiaMoFactory;

    public TestRoujiamoStore(SimpleRouJiaMoFactory factory){
        this.simpleRouJiaMoFactory=factory;
    }

    public RouJiaMo sellRoujiamo(String type){
        RouJiaMo rouJiaMo=simpleRouJiaMoFactory.createRouJiaMo(type);
        rouJiaMo.prepare();
        rouJiaMo.fire();
        rouJiaMo.pack();
        return rouJiaMo;
    }
}
