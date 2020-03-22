package com.algorithm.learn.Leetcode._01offer;

/**
 * 题目链接:调增数组顺序使奇数位于偶数前面
 *
 * https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593?tpId=13&tqId=11166&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 解析
 *
 *
 *
 */
public class offer13 {

    /**
     * 类似冒泡排序解法
     * 冒泡排序是交换前面的一个数比后面的一个数大的情况，而这个题目是交换前面是偶数而后面是奇数的情况。
     * 【验证！】
     * @param array
     */
    public void reOrderArray(int [] array) {


        for (int end=array.length-1;end>0;end--){
            //n-1次冒泡
            //相邻两个，如果前面是偶数，后面是奇数，则转换一下
            for (int i=0;i<end;i++){
                if((array[i]%2==0)&&(array[i+1]%2==1)){
                    //偶数放到后面
                    int temp=array[i];
                    array[i]=array[i+1];
                    array[i+1]=temp;
                }
            }
        }

    }
}
