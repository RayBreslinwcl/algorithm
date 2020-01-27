package com.algorithm.learn.Leetcode._240_search_a_2d_matrix;

/**
 * Created by Administrator on 2020/1/27.
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：

 每行的元素从左到右升序排列。
 每列的元素从上到下升序排列。
 示例:
 现有矩阵 matrix 如下：

 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]
 给定 target = 5，返回 true。
 给定 target = 20，返回 false。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _240_search_a_2d_matrix {
    /**
     * 解题思路：
     * 因为对于一个矩阵matrix[i][j]，其右下侧都是大于matrix[i][j]，左上侧都是小于matrix[i][j]的。
     * 首先选取右上角数字，如果该数字等于要查找的数字，查找过程结束；
     * 如果该数字大于要查找的数字，去掉此数字所在列；
     * 如果该数字小于要查找的数字，则去掉该数字所在行。
     * 重复上述过程直到找到要查找的数字，或者查找范围为空。
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int row=0,col=matrix[0].length-1;
        while (row<matrix.length && col>=0){
            if(matrix[row][col]==target){
                return true;
            }else if (matrix[row][col]<target){
                row++;
            }else if(matrix[row][col]>target){
                col--;
            }
        }
        return false;
    }
}
