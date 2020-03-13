package com.algorithm.learn.Leetcode._226_invert_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2020/3/7.
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * 输入：
 * <p>
 *     4
 *   /   \
 *  2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 *     4
 *   /   \
 *  7     2
 * / \   / \
 * 9   6 3   1
 * <p>
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的
 * <p>
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 * 【面试重点：https://github.com/xbox1994/Java-Interview】
 */
public class _226_invert_binary_tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 1.递归解法
     * 【练习：3】
     * @param root
     * @return
     */
    public TreeNode invertTree1(TreeNode root) {

        if (root == null) {
            return null;
        }
        //先递归
        TreeNode right = invertTree1(root.right);
        TreeNode left = invertTree1(root.left);
        //再反转
        root.left = right;
        root.right = left;
        return root;
    }


    /**
     * 非递归解法：迭代解法
     * 【非递归：2】
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }



}
