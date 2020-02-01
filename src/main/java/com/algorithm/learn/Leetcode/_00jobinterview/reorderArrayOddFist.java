package com.algorithm.learn.Leetcode._00jobinterview;

/**
 * Created by Administrator on 2020/2/1.
 * 调整数组顺序使奇数位于偶数前面
 * 题目描述：
 输入一个整数数组，实现一个函数来调整该数组中数字的顺序.
 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分。
 并保证奇数和奇数，偶数和偶数之间的相对位置不变。

 问题解析：
 1.首先统计奇数的个数假设为oddCount
 2.然后新建一个等长数组
 3.然后通过循环判断原数组中的元素为偶数还是奇数。
 （1）如果是奇数，则从数组下标0的元素开始，把该奇数添加到新数组；
 （2）如果是偶数，则从数组下标为oddCount的元素开始把该偶数添加到新数组中


 */
public class reorderArrayOddFist {

    public static void main(String[] args) {
        int[] array={1,5,2,3,4,5,12,256,342,524,4};
        new reorderArrayOddFist().reorderarrayOddFist(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public void reorderarrayOddFist(int[] array){
        if(array.length==0||array.length==1){
            return ;
        }
        //保存奇数个数：oddCount
        //偶数从：oddCount+1开始添加
        int oddCount=0;
        //奇数从：ini开始添加
        int ini=0;
        for (int i=0;i<array.length;i++){
            if(array[i]%2==1){
                oddCount++;
            }
        }

        //辅助数组，保存整理好的数组
        int[] aux=new int[array.length];
        for (int i=0;i<array.length;i++){
            if(array[i]%2==1){
                aux[ini++]=array[i];
            }else {
                aux[oddCount++]=array[i];
            }
        }

        //赋给原数组
        for (int i=0;i<array.length;i++){
            array[i]=aux[i];
        }
    }
}
