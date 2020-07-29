package com.algorithm.learn.Datastruct.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class bianli {
    /**
     * 树结构
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 前序遍历以node为根的二分搜索树, 递归算法
    // 前序递归 前序遍历：根结点 ---> 左子树 ---> 右子树
    private void preOrder(TreeNode node){
        if(node==null){
            return;
        }

        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }


    /**
     * 3.3 非递归前序遍历
     */
    public void preOrderNR(TreeNode root){
        if (root==null){
            return;
        }

        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur=stack.pop();
            System.out.println(cur.val);

            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                stack.push(cur.left);
            }
        }
    }

    // 中序遍历以node为根的二分搜索树, 递归算法
    private void inOrder(TreeNode node){
        if(node==null){
            return;
        }

        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    /**
     * 后续遍历
     * @param node
     */
    private void postOrder(TreeNode node){
        if(node==null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val);
    }


    //2020/7/3 参考：https://www.cnblogs.com/bigsai/p/11393609.html
    /**
     * 1.层序遍历【重复学习】
     * update3
     * @param t
     */
    public void cengxu(TreeNode t) {//层序遍历
        Queue<TreeNode> q1 = new ArrayDeque<TreeNode>();
        if (t == null){
            return;
        }
        if (t != null) {
            q1.add(t);
        }
        while (!q1.isEmpty()) {
            TreeNode t1 = q1.poll();
            if (t1.left != null){
                q1.add(t1.left);
            }
            if (t1.right != null){
                q1.add(t1.right);
            }
            System.out.print(t1.val + " ");
        }
        System.out.println();
    }
}
