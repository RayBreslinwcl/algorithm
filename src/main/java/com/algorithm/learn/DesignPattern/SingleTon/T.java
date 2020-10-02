package com.algorithm.learn.DesignPattern.SingleTon;
 
public class T implements Runnable {
    @Override
    public void run() {
//        LazySingleton lazySingleton = LazySingleton.getInstance();
//        System.out.println(Thread.currentThread().getName()+"  "+lazySingleton);
//        LazyDoubleCheckSingleton instance = LazyDoubleCheckSingleton.getInstance();
    	/**
    	 * 通过这个类的getInstance方法
    	 * 看上去没有什么区别
    	 * 但是里面使用的是静态内部类
    	 * 而且是一个private的
    	 * 
    	 */
		SingletonIn instance = SingletonIn.getSingletonIn();
 
//        ContainerSingleton.putInstance("object",new Object());
//        Object instance = ContainerSingleton.getInstance("object");
//        ThreadLocalInstance instance = ThreadLocalInstance.getInstance();
 
        System.out.println(Thread.currentThread().getName()+"  "+instance);
 
    }
}



