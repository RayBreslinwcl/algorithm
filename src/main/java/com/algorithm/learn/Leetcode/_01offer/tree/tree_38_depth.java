package com.algorithm.learn.Leetcode._01offer.tree;

public class tree_38_depth {

    public int TreeDepth(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        int leftDepth=TreeDepth(root.left);
        int rightDepth=TreeDepth(root.right);
        int depth=leftDepth>rightDepth?leftDepth:rightDepth;
        return 1+depth;
    }

}
//public class TreeNode {
//    int val = 0;
//    TreeNode left = null;
//    TreeNode right = null;
//
//    public TreeNode(int val) {
//        this.val = val;
//    }
//}