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
     * 【验证！非常妙！】
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


    /**
     * 类似插入排序:
     * 步骤:
     * 1.L从左向右遍历，找到第一个偶数；
     * 2.每次R从L+1开始向后找，直到找到第一个奇数；
     * 3.将[L,...,R-1]的元素整体后移一位，最后将找到的奇数放入L位置，然后L++；
     * 4.如果没有找到那样的arr[R]是奇数，那说明右边没有奇数了，可以break了；
     * 【思路非常好，就是自己需要练习！】
     * @param array
     */
    public void reOrderArray2(int [] array) {

        int L=0,R;
        while (L< array.length){
            while (L<array.length && (array[L]%2==1)){// 先找到第一个偶数
                L++;
            }
            R=L+1;
            while (R<array.length &&(array[R]%2==0)){// 再在L 的后面开始找到第一个奇数
                R++;
            }

            // 注意此时arr[L]是偶数，arr[R]是奇数　-->将[L,..R-1]中的数向后移动一个位置
            if(R<array.length){
                int t=array[R];
                for(int i=R-1;i>=L;i--){
                    array[i+1]=array[i];
                }
                array[L]=t;
                L++;
            }else {
                break;
            }

        }



    }
}
