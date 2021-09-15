package com.algorithm.learn.Leetcode._01offer.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class tree_01_pre_mid_last_around {
    /**
     * 1.递归
     */
    /**
     * 1.1.前序：递归
     */
    public void preOrder(TreeNode node,List<Integer> list){
        if(node==null)return;
        list.add(node.val);//根
        preOrder(node.left,list);//左
        preOrder(node.right,list);//右
    }

    /**
     * 1.2.中序：递归
     * @param node
     * @param list
     */
    public void midOrder(TreeNode node,List<Integer> list){
        if(node==null)return;
        preOrder(node.left,list);//左
        list.add(node.val);//根
        preOrder(node.right,list);//右
    }

    /**
     * 1.3.后序
     * @param node
     * @param list
     */
    public void afterOrder(TreeNode node,List<Integer> list){
        if(node==null)return;
        afterOrder(node.left,list);//左
        afterOrder(node.right,list);//右
        list.add(node.val);//根
    }




    /**
     * 2.非递归
     */
    /**
     * 2.1.前序：非递归
     * 参考：https://blog.csdn.net/qq_43434328/article/details/113356807
     * @param root
     */
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
    /**
     * 2.2.中序：非递归
     * 参考：https://blog.csdn.net/qq_43434328/article/details/113356807
     * @param root
     */
    public List<Integer> midOrder(TreeNode root) {//左根右
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.empty()||node!=null) {//栈不为空且当前结点不为空继续遍历
            while (node!=null){//遍历左儿子 找到最左儿子
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();//返回当前节点的父节点
            list.add(node.val);
            node = node.right;
        }
        return list;
    }

    /**
     * 2.3 后序：非递归
     * 后序用双栈实现 根据栈的特性先进后出 后序需要的是左右根 当我们向栈中按照根右左压入时 最后弹出的顺序就是左右根 所以此时后序遍历就转换为先序遍历的形式了。
     * @param root
     * @return
     */
    public List<Integer> afterOrder(TreeNode root) {//左右根
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> out = new Stack<>();
        TreeNode node = root;
        while (!stack.empty()||node!=null) {//找根右左
            while (node!=null){//遍历右儿子 边遍历边存结果
                stack.push(node);
                out.push(node);
                node = node.right;
            }
            node = stack.pop();//返回当前节点的父节点
            node = node.left;
        }
        while (!out.empty())//利用栈的先入后出变成左右根存入
            list.add(out.pop().val);
        return list;
    }



}
class TreeNode{//TreeNode类，后边同样
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val){
        this.val = val;
    }
}