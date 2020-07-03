package com.algorithm.learn.Leetcode._01offer;

/**
 *剑指Offer - 12 - 数值的整数次方
 *
 * 题目链接
 *
 * https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00?tpId=13&tqId=11165&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * 题目
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class offer12 {
    /**
     * 参考解法：https://www.nowcoder.com/questionTerminal/1a834e5e3e1a4b7ba251417554e07c00?f=discussion
     *  FantasyLin的解法
     *
     *  【update：这个解法妙】
     */
    public double Power(double base, int exponent) {
        return powerSelf(base,exponent);
    }

    private double powerSelf(double base, int exponent) {
        int n=Math.abs(exponent);
        double result=0.0;

        //结束条件
        if(n==0) {
            return 1.0;
        }
        if(n==1){
            return base;
        }

        result=powerSelf(base,n/2);
        result=result*result;
        //奇数偶数分支判断；
        if((n&1) ==0){
            //偶数
        }else {
            result*=base;
        }

        if(exponent>0){

        }else if(exponent<0){
            //负数
            result=1/result;
        }

        return result;
//        return 0;
    }

}
