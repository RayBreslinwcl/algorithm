package com.algorithm.learn.Leetcode._00jobinterview;

/**
 * Created by Administrator on 2020/2/1.
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 正常分析法：
 * a.如果两种跳法，1阶或者2阶，那么假定第一次跳的是一阶，那么剩下的是n-1个台阶，跳法是f(n-1);
 * b.假定第一次跳的是2阶，那么剩下的是n-2个台阶，跳法是f(n-2)
 * c.由a，b假设可以得出总跳法为: f(n) = f(n-1) + f(n-2)
 * d.然后通过实际的情况可以得出：只有一阶的时候 f(1) = 1 ,只有两阶的时候可以有 f(2) = 2
 * 【总结：重点思路】
 */
public class JumpFloor {
    public int jumpfloor(int n){
        if(n<=0){
            return 0;
        }

        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int first=1;
        int second=2;
        int third=0;
        for (int i=3;i<=n;i++){
            third=first+second;
            if(i!=n){
                first=second;
                second=third;
            }
        }
        return third;

    }
}
