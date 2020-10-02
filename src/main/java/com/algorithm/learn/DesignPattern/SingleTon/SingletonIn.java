package com.algorithm.learn.DesignPattern.SingleTon;

/**
 * Created by Administrator on 2020/3/10.
 * 【参考：https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/singleton/inclass/SingletonIn.java】
 *
 *
 */

public class SingletonIn {

    /**
     * Created by jingbin on 2016/10/28.
     * 内部类[推荐用]
     * <p>
     * 这种方式跟饿汉式方式采用的机制类似，但又有不同。
     * 两者都是采用了类装载的机制来保证初始化实例时只有一个线程。
     * 不同的地方:
     * 在饿汉式方式是只要Singleton类被装载就会实例化,
     * 内部类是在需要实例化时，调用getInstance方法，才会装载SingletonHolder类
     * <p>
     * 优点：避免了线程不安全，延迟加载，效率高。
     */

    private SingletonIn() {
        if(SingletonInHodler.singletonIn != null){
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }

    private static class SingletonInHodler {
        private static SingletonIn singletonIn = new SingletonIn();
    }

    public static SingletonIn getSingletonIn() {
        return SingletonInHodler.singletonIn;
    }
}
