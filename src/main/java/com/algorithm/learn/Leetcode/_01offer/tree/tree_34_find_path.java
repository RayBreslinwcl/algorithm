package com.algorithm.learn.Leetcode._01offer.tree;

import java.util.ArrayList;

public class tree_34_find_path {


        private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
        private ArrayList<Integer> list = new ArrayList<Integer>()
                ;
        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
            if (root == null)return listAll;

            list.add(root.val);
            target = target - root.val;

            if (target == 0 && root.left == null && root.right == null){
                //这里必须要重新生成一个对象实例，并使用list对其初始化赋值
                listAll.add(new ArrayList<Integer>(list));
            }
            FindPath(root.left,target);
            FindPath(root.right,target);
            //模拟了栈回退,当前节点为叶子节点或者已经访问过的情况下，回溯到父节点
            list.remove(list.size()-1);
            return listAll;
        }


}
