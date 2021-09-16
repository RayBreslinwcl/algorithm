package com.algorithm.learn.Leetcode._01offer.tree;

import java.util.*;

public class tree_60_print_mult_line {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        //思路：使用队列实现
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if(pRoot==null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>(); //借助队列实现
        TreeNode root=pRoot;
        queue.add(root);
        while(!queue.isEmpty()){ //队列不空
            //当前队列长度代表当前这一层节点个数
            int len=queue.size();
            ArrayList<Integer> row=new ArrayList<>();
            for(int i=0;i<len;i++){  //循环次数，也就是当前这一层节点个数
                TreeNode temp=queue.poll();
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
                row.add(temp.val);
            }
            res.add(row);
        }
        return res;
    }
}

//public class TreeNode {
//    int val = 0;
//    TreeNode left = null;
//    TreeNode right = null;
//
//    public TreeNode(int val) {
//        this.val = val;
//    }
//}