package com.algorithm.learn.Leetcode._00jobinterview;

/**
 * Created by Administrator on 2020/1/31.
 * 数组右移K次, 原数组 [1, 2, 3, 4, 5, 6, 7]
 * 右移3次后结果为 [5,6,7,1,2,3,4]
 * 【总结：思路是可以倒序】
 */
public class ArrayMoveKToRight {
    /**
     * 基本思路：
     * （1）原数组array完全逆序，得到array1
     * （2）array1的[0,k]再逆序
     * （3）array1的[k+1,array.length-1]再逆序
     * @param array
     * @param k
     */
    public void arrayMove(int[] array,int k){

        if(array==null){
            System.out.println("数组为空！");
            return;
        }
        //取模，因为如果正好是整数倍，则不用动
        k=k%array.length;
        if(k<=0){
            return;
        }else {
            reverseArray(array,0,array.length-1);
            reverseArray(array,0,k-1);
            reverseArray(array,k,array.length-1);
        }
    }

    /**
     * 从start到end的逆序
     * @param array
     * @param start
     * @param end
     */
    public void reverseArray(int[] array,int start,int end){
        if (array.length==0){
            return;
        }
        if(start>=end){
            System.out.println("输入起始和结束索引有问题！");
            return;
        }
        while (start<end){
            int temp=array[start];
            array[start]=array[end];
            array[end]=temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        int[] array={1, 2, 3 ,4, 5, 6, 7};

        new ArrayMoveKToRight().arrayMove(array,3);

        for (int i : array) {
            System.out.println(i);
        }


    }
}
