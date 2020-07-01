package com.algorithm.learn.Datastruct.tree;

public class bianli {
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
}
