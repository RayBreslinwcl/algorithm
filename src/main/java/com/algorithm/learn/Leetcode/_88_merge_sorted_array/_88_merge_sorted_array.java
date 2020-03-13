package com.algorithm.learn.Leetcode._88_merge_sorted_array;

/**
 * Created by Administrator on 2020/3/13.
 * 88. 合并两个有序数组
 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。

 说明:

 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。


 示例:

 输入:
 nums1 = [1,2,3,0,0,0], m = 3
 nums2 = [2,5,6],       n = 3

 输出: [1,2,2,3,5,6]
 【题目推荐：https://github.com/xbox1994/Java-Interview】
 */
public class _88_merge_sorted_array {
    /**
     * 解题思路：
     * 【参考】
     * https://leetcode-cn.com/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetcode/
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1=m-1;
        int p2=n-1;
        int k=m+n-1;
        //当两个数组都有元素
        while ((p1>=0)&&(p2>=0)){
            if(nums1[p1]>nums2[p2]){
                nums1[k--]=nums1[p1--];
            }else {
                nums1[k--]=nums2[p2--];
            }
        }
        //当p1先到0，p2没有到0，则把剩余的复制到后面
        while (p2>=0){
            nums1[k--]=nums2[p2--];
        }
        //当p2先到0，p1没有到0.不用管，因为已经排好序了
    }

    public static void main(String[] args) {
       int[] a1=new int[]{0};
        int[] a2=new int[]{1};
       new _88_merge_sorted_array().merge(a1,0,a2,1);
    }
}
