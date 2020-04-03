package com.algorithm.learn.DesignPattern.proxy;

/**
 * 测试：
 *
 */
public class Test {

    public static void main(String[] args) {

        Image image1=new RealImage("测试输入类");

        // 第一次是new的，图像从磁盘加载
        image1.display();
        System.out.println("=====================");
        // 第二次取缓存，图像不需要从磁盘加载
        image1.display();

    }
}
