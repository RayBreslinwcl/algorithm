package com.algorithm.learn.Leetcode._128_longest_consecutive_sequence;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2020/1/27.
 * 题目描述
 给定一个无序的整数类型数组，求最长的连续元素序列的长度。
 例如：
 给出的数组为[100, 4, 200, 1, 3, 2],
 最长的连续元素序列为[1, 2, 3, 4]. 返回这个序列的长度：4
 你需要给出时间复杂度在O（n）之内的算法
 */
public class _128_longest_consecutive_sequence {
    public int longestConsecutive(int[] num) {
        Set<Integer> set=new HashSet<Integer>();

        for (int n : num) {
            set.add(n);
        }
        int max=1;

        for (int n:num){   //不能for (int n:set){，因为会导致修改错误
            if(set.remove(n)){
                int val=n; //当前值
                int sum=1;
                int val_small=val-1;
                int val_big=val+1;
                while (set.remove(val_small)){
                    sum++;
                    val_small--;
                }
                while (set.remove(val_big)){
                    sum++;
                    val_big++;
                }
                max=Math.max(max,sum);
            }
        }

        return max;

    }

    public static void main(String[] args) {
        int[] num=new int[]{0,-1};
        int res=new _128_longest_consecutive_sequence().longestConsecutive(num);
    }
}
