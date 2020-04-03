package com.algorithm.learn.DesignPattern.observer.javaobserver;

/**
 * 测试类
 */
public class test {
    public static void main(String[] args) {
        SubjectFor3d subjectFor3d=new SubjectFor3d();
        SubjectForSSQ subjectForSSQ=new SubjectForSSQ();
        //注册
        Observer1 observer1=new Observer1();
        observer1.registerSubject(subjectFor3d);
        observer1.registerSubject(subjectForSSQ);


        //更新消息
        subjectFor3d.setMsg("hello 3d'nums : 110 ");
        subjectForSSQ.setMsg("ssq'nums : 12,13,31,5,4,3 15");

        /**
         * 结果：
         * subjectFor3d's msg -- >hello 3d'nums : 110
         * subjectForSSQ's msg -- >ssq'nums : 12,13,31,5,4,3 15
         */
    }
}
