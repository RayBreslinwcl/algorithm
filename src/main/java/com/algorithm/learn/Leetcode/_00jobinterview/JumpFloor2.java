package com.algorithm.learn.Leetcode._00jobinterview;

/**
 * Created by Administrator on 2020/2/1.
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 正常分析法：
 * 1.假设n>=2，第一步有n种跳法：跳1级、跳2级、到跳n级
 * (1)跳1级，剩下n-1级，则剩下跳法是f(n-1)
 * (2)跳2级，剩下n-2级，则剩下跳法是f(n-2)
 * ......
 * (3)跳n-1级，剩下1级，则剩下跳法是f(1)
 * (4)跳n级，剩下0级，则剩下跳法是f(0)
 * 2.所以在n>=2的情况下： f(n)=f(n-1)+f(n-2)+...+f(1)
 * 3.因为f(n-1)=f(n-2)+f(n-3)+...+f(1) 所以f(n)=2*f(n-1) 又f(1)=1,所以可得f(n)=2^(number-1)
 */
public class JumpFloor2 {

    public int jumpfloor2(int n){
        return 1<< --n;
    }
}
