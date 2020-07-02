package com.algorithm.learn.Leetcode._01offer;

/**
 * ## 剑指Offer - 09 - 变态跳台阶
 *
 * #### [题目链接](https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=11162&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)
 * > https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=11162&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * #### 题目
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * */
public class offer09 {
    /**
     * 解析：
     * 这题不同于跳台阶问题的地方在于，n层可以由前面的任意一层跳过来:
     * 第n个台阶可以由前面所有的台阶跳过来即f[n] = f[n-1] + f[n-2] + ... f[1]；
     * 然后加上直接跳到自己这个台阶(+1)；
     * 经典
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        if(target==1||target==2) return target;
//        if(target==2) return 2;
        int sum=1;
        for (int i = 1; i < target; i++) {
            sum+=JumpFloorII(i);
        }
        return sum;
    }
}
