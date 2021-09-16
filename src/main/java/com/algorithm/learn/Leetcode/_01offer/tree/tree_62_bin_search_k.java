package com.algorithm.learn.Leetcode._01offer.tree;

//public class TreeNode {
//    int val = 0;
//    TreeNode left = null;
//    TreeNode right = null;
//
//    public TreeNode(int val) {
//        this.val = val;
//    }
//}

/**
 * 参考：https://blog.csdn.net/sun10081/article/details/82805991
 */
public class tree_62_bin_search_k {

    int count = 0;
    TreeNode ans;
    TreeNode KthNode(TreeNode pRoot, int k){
        helper(pRoot, k);
        return ans;
    }

    public void helper(TreeNode node, int k){
        if (node==null || count>k) {
            return;
        }
        helper(node.left, k);
        count++;
        if (count == k) {
            ans = node;
        }
        helper(node.right, k);
    }
}
