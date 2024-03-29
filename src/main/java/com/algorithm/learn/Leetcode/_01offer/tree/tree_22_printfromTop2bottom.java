package com.algorithm.learn.Leetcode._01offer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *剑指Offer - 22 - 从上往下打印二叉树
 *
 * 题目链接
 *
 * https://www.nowcoder.com/practice/7fe2212963db4790b57431d9ed259701?tpId=13&tqId=11175&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目
 *
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 *
 * 解析：
 * 可能是剑指Offer最简单的一道题了。。
 *
 * 直接上二叉树层次遍历代码即可。
 */
public class tree_22_printfromTop2bottom {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }


    /**
     * 解析
     *
     * 可能是剑指Offer最简单的一道题了。。
     * 直接上二叉树层次遍历代码即可。
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();

        if(root==null){
            return res;
        }

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        TreeNode cur=null;

        while (!queue.isEmpty()){
            cur=queue.poll();
            res.add(cur.val);
            if(cur.left!=null)
                queue.add(cur.left);
            if(cur.right!=null)
                queue.add(cur.right);
        }
        return res;
    }


}
