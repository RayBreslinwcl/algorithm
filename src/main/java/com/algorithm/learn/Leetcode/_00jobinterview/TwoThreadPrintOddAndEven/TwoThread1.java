package com.algorithm.learn.Leetcode._00jobinterview.TwoThreadPrintOddAndEven;

/**
 * Created by Administrator on 2020/1/31.
 * 基于：object的wait/notify方式
 */
public class TwoThread1 {

    private static int i=1;

    private static final int total=100;
    //锁
    public static Object lock=new Object();

//    public static class OddNumber implements Runnable{
//        @Override
//        public void run() {
//            while (i<=total){
//                synchronized (lock){
//                    if (i%2==0){
//                        System.out.println(Thread.currentThread().getName()+"i="+i);
//                        i++;
//                        lock.notifyAll();
//                    }else {
//                        try {
//                            lock.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//        }
//    }
//    public static class EvenNumber implements Runnable{
//
//        @Override
//        public void run() {
//            while (i<=total){
//                synchronized (lock){
//                    if(i%2==1){
//                        System.out.println(Thread.currentThread().getName()+ "i="+i);
//                        i++;
//                        lock.notifyAll();
//                    }else {
//                        try {
//                            lock.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
//        Thread thread=new Thread(new TwoThread1()..OddNumber);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (i<=total){
                    synchronized (lock){
                        if (i%2==0){
                            System.out.println(Thread.currentThread().getName()+"i="+i);
                            i++;
                            lock.notifyAll();
                        }else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (i<=total){
                    synchronized (lock){
                        if(i%2==1){
                            System.out.println(Thread.currentThread().getName()+ "i="+i);
                            i++;
                            lock.notifyAll();
                        }else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();
    }

}
