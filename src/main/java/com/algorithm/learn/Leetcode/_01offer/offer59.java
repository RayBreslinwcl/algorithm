package com.algorithm.learn.Leetcode._01offer;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 ## 剑指Offer - 59 - 按之字形顺序打印二叉树

 #### [题目链接](https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0?tpId=13&tqId=11212&tPage=3&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)

 #### 题目

 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。

 ### 解析

 这题是[剑指Offer - 60 - 把二叉树打印成多行](剑指Offer - 60 - 把二叉树打印成多行.md)的加强版，可以先做那一题。

 另外在[LeetCode - 103](https://github.com/ZXZxin/ZXBlog/blob/master/%E5%88%B7%E9%A2%98/LeetCode/Tree/LeetCode%20-%20103.%20Binary%20Tree%20Zigzag%20Level%20Order%20Traversal.md)我也写过。可以看那一篇。

 然后只需要将偶数层的翻转一下即可。

 */
public class offer59 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean ok = false;
        ArrayList<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            int n = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                TreeNode cur = queue.poll();
                tmp.add(cur.val);
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
            if(ok) {
                Collections.reverse(tmp);
            }
            ok = !ok;
            res.add(tmp);
        }
        return res;
    }
}
