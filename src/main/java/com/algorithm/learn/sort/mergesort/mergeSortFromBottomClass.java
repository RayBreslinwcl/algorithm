package com.algorithm.learn.sort.mergesort;

/**
 * Created by Administrator on 2019/11/1.
 */
public class mergeSortFromBottomClass {

    /**
     * 总结：
     * 1.排序时间：10000个数字排序，array 排序耗时：6ms
     */

    /**
     * 【1】
     * 0.归并算法自底向上，非递归
     * 功能：对arr[i], 其中left<=i<=right 范围内的数进行排序
     * @param array
     * @param left
     * @param right
     */
    public static void mergeSortFromBottom(int[] array,int left,int right){

        for (int stepSize=1;stepSize<right-left+1;stepSize+=stepSize){
            for (int i=0;i+stepSize<right-left+1;i+=stepSize+stepSize){

                //因为最后一次2*stepSize归并，第二部分可能越界，本部分保证不越界
                int finalright=(i+stepSize+stepSize-1)<(right-left)?(i+stepSize+stepSize-1):(right-left);
                merge(array,i,i+stepSize-1,finalright);
            }
        }
    }

    /**
     * 0.1:
     * 功能：将a[i]中， l<=i<=mid 和 mid+1<=i<=r 两个部分，进行归并
     * @param array
     * @param left
     * @param mid
     * @param right
     */
    public static void merge(int[] array,int left,int mid,int right){

        int i=left,j=mid+1;
        int k;

        //声明辅助数组
        int[] aux =new int[right-left+1];
        for (int t=0;t<right-left+1;t++){
            aux[t]=array[left+t]; //把将要归并的两组数，赋给中间数组aux
        }

        //合并
        for (k=left;k<=right;k++){

            if (i>mid){
                array[k]=aux[j-left];
                j++;
            }else if(j>right){
                array[k]=aux[i-left];
                i++;
            }else if (aux[i-left]<=aux[j-left]){
                array[k]=aux[i-left];
                i++;
            }else if(aux[j-left]<aux[i-left]){
                array[k]=aux[j-left];
                j++;
            }
        }

    }

    public static void main(String[] args) {
        //生成测试数组测试
        int numcount=10000;
        int maxValue=10000;
        int[] arr=new int[numcount];
        for (int i=0;i<numcount;i++){
            arr[i]=(int)(Math.random()*maxValue); //随机数的范围
        }

        System.out.println("array 排序前数组：");
        for (int i : arr) {
            System.out.print(i+"\t");
        }

        System.out.println();

        long startTime=System.currentTimeMillis();
        mergeSortFromBottom(arr,0,arr.length-1); //归并排序
        long stopTime=System.currentTimeMillis();
        System.out.println("array 排序耗时："+(stopTime-startTime)+"ms");


        System.out.println("array 排序后数组：");
        for (int i : arr) {
            System.out.print(i+"\t");
        }

    }
}
