package com.algorithm.learn.Leetcode._01offer.tree;

/**
 * 18 - 二叉树的镜像
 *
 * 题目链接
 *
 * https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011?tpId=13&tqId=11171&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */
public class tree_02_mirror {


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 思路解析
     *
     * 这题算一个简单题了。
     *
     * 思路很简单，递归求解的过程:
     *
     * 先把当前根节点的左右子树换掉；
     * 然后递归换自己的左右子树即可；
     */
    public void Mirror(TreeNode root) {
        //终止条件
        if(root==null) return;

        //交换
        TreeNode right=root.right;
        TreeNode left=root.left;
        root.right=left;
        root.left=right;

        //迭代
        Mirror(root.left);
        Mirror(root.right);
    }
}
