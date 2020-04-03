package com.algorithm.learn.DesignPattern.observer;

/**
 * 服务号中维护了所有向它订阅消息的使用者，当服务号有新消息时，通知所有的使用者。
 * 整个架构是一种松耦合，主题的实现不依赖与使用者，
 * 当增加新的使用者时，主题的代码不需要改变；
 * 使用者如何处理得到的数据与主题无关；
 */
public class test {
    public static void main(String[] args) {

        ObjectFor3D subject=new ObjectFor3D();

        Observer1 observer1=new Observer1(subject);
        Observer2 observer2=new Observer2(subject);

        subject.setMsg("message 1");

        subject.setMsg("message 2");

        /**
         * 结果：
         * observer1 得到 3D 号码  -->message 1, 我要记下来。
         * observer2 得到 3D 号码 -->message 1我要告诉舍友们。
         * observer1 得到 3D 号码  -->message 2, 我要记下来。
         * observer2 得到 3D 号码 -->message 2我要告诉舍友们。
         * 
         */
    }
}
