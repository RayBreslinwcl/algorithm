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

    public static void main(String[] args) {

        /**
         *  实例1：
         *       1
         *      / \
         *     2   3
         *    /   / \
         *   4   5   6
         *   序列化为
         *   "1,2,4,#,#,#,3,5,#,#,6,#,#"
         *
         * 当前采用：下面的
         *        5
         *      /  \
         *     3    7
         *    / \   / \
         *   2  4  6   8
         *   序列化为
         *   "5,3,2,#,#,4,#,#,7,6,#,#,8,#,#"
         */
        String serialString="5,3,2,#,#,4,#,#,7,6,#,#,8,#,#";
        TreeNode deserializeTree = new tree_61_serial_deserial().Deserialize(serialString);
        TreeNode treeNodeRes = new tree_62_bin_search_k().KthNode(deserializeTree, 4);
        System.out.println(treeNodeRes.val);
    }
}
