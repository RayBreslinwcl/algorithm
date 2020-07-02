package com.algorithm.learn.Leetcode._01offer;

/**
 * ## 剑指Offer - 08 - 跳台阶
 * <p>
 * #### [题目链接](https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=13&tqId=11161&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)
 * <p>
 * > https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=13&tqId=11161&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * <p>
 * #### 题目
 * <p>
 * > 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * <p>
 * ### 解析
 * <p>
 * 和上一题斐波那契数列问题唯一的不同就是`n == 2`的时候是`2`而不是`1`，思路如下：
 * <p>
 * * 唯一的不同在于`n = 2`时不是返回`1`而是返回`2`，因为`2`级台阶可以有**两种**跳法；
 * * 为什么是f<sub>n</sub> = f<sub>n-1</sub> + f<sub>n-2</sub>呢，**如果台阶有N级，最后跳上第N级的情况，要么是从N-2级台阶直接跨2级台阶，要么是从N-1级台阶跨1级台阶，所以台阶有N级的方法数为跨到N-2级台阶的方法数加上跨到N-1级台阶的方法数**；
 */
public class offer08 {


    public int JumpFloor(int target) {
        if (target < 1){
            return 0;
        }

        if (target == 1 || target == 2){
            //这里和上面的不同
            return target;
        }

        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

}
