package com.algorithm.learn.Leetcode._01offer;

import java.util.ArrayList;

/**
 * 剑指Offer - 24 - 二叉树中和为某一值的路径
 * <p>
 * 题目链接
 * <p>
 * https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=13&tqId=11177&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目
 * <p>
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class offer24 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    private ArrayList<ArrayList<Integer>> res;

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        res = new ArrayList<ArrayList<Integer>>();

        if (root == null)
            return res;

        ArrayList<Integer> path = new ArrayList<>();
        rec(root, 0, target, path);
        return res;

    }

    private void rec(TreeNode node, int curSum, int target, ArrayList<Integer> path) {

        if(node==null){
            return;
        }

        curSum+=node.val;
        path.add(node.val);

        if(curSum==target&&node.left==null&&node.right==null){ //叶子结点且和 = target
            res.add(new ArrayList<>(path)); //res.add(path);  //这个是不对的
        }

        rec(node.left, curSum, target, path);
        rec(node.right, curSum, target, path);
        // curSum -= node.val;
        path.remove(path.size() - 1);

    }


}
