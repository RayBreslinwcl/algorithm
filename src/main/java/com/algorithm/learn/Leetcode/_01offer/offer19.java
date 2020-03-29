package com.algorithm.learn.Leetcode._01offer;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 */
public class offer19 {

    /**
     * 参考：ZXBLOG:剑指Offer - 19 - 顺时针打印矩阵
     */
    private ArrayList<Integer> res;

    public ArrayList<Integer> printMatrix(int [][] matrix) {

        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return null;
        }

        res=new ArrayList<>();
        int ar=0,ac=0,br=matrix.length-1,bc=matrix[0].length-1;

        while (ar<=br&&ac<=bc){
            printNew(ar++,ac++,br--,bc--,matrix);
        }

        return res;
    }

    private void printNew(int ar, int ac, int br, int bc, int[][] matrix) {
        if(ar==br){
            for (int j=ac;j<=bc;j++) res.add(matrix[ar][j]);
        }else if(ac==bc){
            for (int i=ar;i<=br;i++) res.add(matrix[i][ac]);
        }else {
            for (int j=ac;j<bc;j++) res.add(matrix[ar][j]);
            for (int i=ar;i<br;i++) res.add(matrix[i][bc]);
            for (int j=bc;j>ac;j--) res.add(matrix[br][j]);
            for (int i=br;i>ar;i--) res.add(matrix[i][ac]);
        }
    }
}
