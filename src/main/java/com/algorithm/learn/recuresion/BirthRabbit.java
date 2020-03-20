package com.algorithm.learn.recuresion;

public class BirthRabbit {

    public int f(int day){
        if(day==1|| day==2) return 1;

        return f(day-1)+f(day-2);
    }

    public static void main(String[] args) {
        System.out.println(new BirthRabbit().f(3));
    }
}
