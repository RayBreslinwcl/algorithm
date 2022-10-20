package com.algorithm.learn.recuresion;

/**
 * 问题描述
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 * 这是 leetcode 的 62 号题：https://leetcode-cn.com/problems/unique-paths/
 */
public class _3unique_paths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }

    /**
     * 这个暴力解法：不推荐！关键超出时间，是不符合要求的
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        if(m==1||n==1) return 1;

        int res=uniquePaths(m-1,n)+uniquePaths(m,n-1);

        return res;
    }


    /**
     * 优化：计算过的结果，不要重复计算。因为(5,4)和(6,5)可能都需要(4,4)所以，需要计算2此(4,4)，这个重复计算可以避免的。
     * https://leetcode.cn/problems/unique-paths/submissions/
     * 验证是可行的
     * @param m
     * @param n
     * @return
     */
    // 全局变量，用来保存计算过的只
    static int[][] arr = null;
    public int uniquePaths2(int m, int n) {
        // 创建一个二维数组
        arr = new int[m][n];
        return dfs(m - 1, n -1);
    }

    public int dfs(int i, int j) {
        if(i == 0 || j == 0){
            return 1;
        }
        // java 里，数组的初始值是 0，所以可以用 arr[i][i] 是否为 0 来判断
        if(arr[i][j] != 0){
            return arr[i][j];
        }
        // 把计算过的指保存起来
        arr[i][j] = dfs(i - 1, j) + dfs(i, j - 1);

        return arr[i][j];
    }

}
