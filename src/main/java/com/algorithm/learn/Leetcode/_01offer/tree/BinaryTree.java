package com.algorithm.learn.Leetcode._01offer.tree;

/**
 * 包含建树的方法！
 */
public class BinaryTree {
    TreeNode root;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public BinaryTree(Integer[] array) {//建树
        root = new TreeNode(array[1]);
        TreeNode[] treeNodes = new TreeNode[array.length];//树的所有结点
//        二叉链表建树
        treeNodes[1] = root;
        for (int i = 2; i < array.length; i++) {
            if (array[i] == null) continue;
            treeNodes[i] = new TreeNode(array[i]);
            int parent = i / 2;
            if (i % 2 == 0) {//左儿子
                treeNodes[parent].left = treeNodes[i];
            } else {
                treeNodes[parent].right = treeNodes[i];
            }
        }
    }

}
