package com.algorithm.learn.Leetcode._01offer;

/**
 * 题目: 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 * 【面试：笔试题目】
 *
 *
 */
public class  offer01 {

    /**
     * 错误：[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]查找7，返回false。因为手残，等号导致
     * 【update2】
     * @param target
     * @param array
     * @return
     */

    public boolean Find(int target, int[][] array) {
        int row = array.length;
        int col = array[0].length;

        //起点
        int i = 0;
        int j = col - 1;

        while (i < row && j >= 0) {
            if (array[i][j] > target) {
                j--;
            } else if (array[i][j] < target) {  //这里array[i][j] <= target,手残添加了一个“=”所以完蛋
                i++;
            } else if (array[i][j] == target) {
                return true;
            }
        }

        return false;

    }
}
