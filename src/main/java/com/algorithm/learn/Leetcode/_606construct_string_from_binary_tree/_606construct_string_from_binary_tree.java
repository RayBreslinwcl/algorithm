package com.algorithm.learn.Leetcode._606construct_string_from_binary_tree;

/**
 * Created by Administrator on 2020/1/12.
 */
public class _606construct_string_from_binary_tree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 参考思路：https://leetcode-cn.com/problems/construct-string-from-binary-tree/solution/gen-ju-er-cha-shu-chuang-jian-zi-fu-chuan-by-leetc/
     * @param t
     * @return
     */
    public String tree2str(TreeNode t) {
        if(t==null){
            return "";
        }
        if(t.left==null&& t.right==null){
            return t.val+"";
        }

        if(t.right==null){
            return t.val+"("+tree2str(t.left)+")";
        }
        return t.val+"("+tree2str(t.left)+")("+tree2str(t.right)+")";

    }
}
