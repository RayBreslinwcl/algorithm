package com.algorithm.learn.DesignPattern.SingleTon.enumSingle;

import java.lang.reflect.Constructor;

/**
 * Created by geely
 * 反射攻击
 */
public class Test2 {
    public static void main(String[] args) throws NoSuchMethodException {
        Class objectClass = EnumInstance.class;
        Constructor constructor = objectClass.getDeclaredConstructor();
        constructor.setAccessible(true);

    }
}