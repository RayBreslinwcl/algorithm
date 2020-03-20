package com.algorithm.learn.recuresion;

/**
 * 递归实现：阶乘
 */
public class factorial {
    public int factor(int k){
        if(k==1) return 1;

        return factor(k-1)*k;

    }

    public static void main(String[] args) {
        System.out.println(new factorial().factor(5));
    }
}
