package com.algorithm.learn.DesignPattern.SingleTon.serial;

import java.io.*;

//测试是否返回同一个对象
public class TestDCL {
    public static void main(String[] args) throws Exception {
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton1.hashCode()); // 723074861
        //通过序列化对象，再反序列化得到新对象
        String filePath = "D:\\singleton.txt";
        saveToFile(singleton1,filePath);
        Singleton singleton2 = getFromFile(filePath);
        System.out.println(singleton2.hashCode()); // 1259475182
    }

    //将对象写入到文件
    private static void saveToFile(Singleton singleton, String fileName){
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(singleton); //将对象写入oos
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //从文件中读取对象
    private static Singleton getFromFile(String fileName){
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (Singleton) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
