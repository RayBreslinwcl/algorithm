package com.algorithm.learn.Leetcode._01offer.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public List<Integer> preOrder2(TreeNode root) {//根左右
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.empty()||node!=null){//栈不为空且当前结点不为空继续遍历
            while (node!=null){//遍历左儿子 边遍历边添加结果
                stack.push(node);
                list.add(node.val);
                node = node.left;
            }
            node = stack.pop();//返回当前节点的父节点
            node = node.right;
        }
        return list;
    }

    public static void main(String[] args) {
        Integer[] array=new Integer[]{1,2,3,4};
        BinaryTree btr=new BinaryTree(array);
        System.out.println(btr);
    }
}
