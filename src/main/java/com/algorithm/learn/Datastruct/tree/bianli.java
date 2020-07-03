package com.algorithm.learn.Datastruct.tree;

import java.util.ArrayDeque;
import java.util.Queue;

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

    public void qianxu(TreeNode t)// 前序递归 前序遍历：根结点 ---> 左子树 ---> 右子树
    {
        if (t == null) {
            return;
        }
        System.out.print(t.val + " ");// 当前节点
        qianxu(t.left);
        qianxu(t.right);
    }

    public void zhongxu(TreeNode t)// 中序遍历 中序遍历：左子树---> 根结点 ---> 右子树
    {
        if (t == null) {
            return;
        }
        zhongxu(t.left);
        System.out.print(t.val + " ");// 访问完左节点访问当前节点
        zhongxu(t.right);

    }

    public void houxu(TreeNode t)// 后序遍历 后序遍历：左子树 ---> 右子树 ---> 根结点
    {
        if (t == null) {
            return;
        }
        houxu(t.left);
        houxu(t.right);
        System.out.print(t.val + " "); // 访问玩左右访问当前节点

    }

    //2020/7/3 参考：https://www.cnblogs.com/bigsai/p/11393609.html
    /**
     * 1.层序遍历
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
