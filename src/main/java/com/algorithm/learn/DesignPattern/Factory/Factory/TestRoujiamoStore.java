package com.algorithm.learn.DesignPattern.Factory.Factory;


/**
 * Created by Administrator on 2020/3/11.
 * 【测试工厂类】
 * 通过工厂类RouJiaMoFactory，实现直接创建对应肉夹馍实例，并且实现销售
 */
public class TestRoujiamoStore {
    private RouJiaMoFactory factory;

    public TestRoujiamoStore(RouJiaMoFactory factory){
        this.factory=factory;
    }

    public RouJiaMo sellRoujiamo(){
        RouJiaMo rouJiaMo=factory.createRouJiaMo();
        rouJiaMo.prepare();
        rouJiaMo.fire();
        rouJiaMo.pack();
        return rouJiaMo;
    }


    public static void main(String[] args) {
        //直接生成辣肉夹馍，不需要传参数
        TestRoujiamoStore roujiamoStore=new TestRoujiamoStore( new LaRouJiaMoFactory());
        roujiamoStore.sellRoujiamo();
    }
}
