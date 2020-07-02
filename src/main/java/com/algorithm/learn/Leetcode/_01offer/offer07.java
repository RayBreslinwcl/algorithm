package com.algorithm.learn.Leetcode._01offer;

/**
 * 斐波那契
 * ## 剑指Offer - 07 - 斐波那契数列
 *
 * #### [题目链接](https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&tqId=11160&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)
 *
 * > https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&tqId=11160&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * #### 题目
 *
 * >  大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
 *
 * ### 解析
 *
 * 经典的简单题。给出5种做法。
 *
 */
public class offer07 {

    /**
     * 方法一：递归
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if (n < 1){
            return 0;
        }

        if (n == 1 || n == 2){
            return 1;
        }

        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}
