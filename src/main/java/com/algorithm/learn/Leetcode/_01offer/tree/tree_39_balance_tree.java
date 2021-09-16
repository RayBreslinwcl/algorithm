package com.algorithm.learn.Leetcode._01offer.tree;

/**
 * 参考链接：https://www.cnblogs.com/gzshan/p/10843320.html
 */
public class tree_39_balance_tree {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null) //空树也是二叉平衡树
            return true;
        int res=getDepth(root);
        if(res==-1)
            return false;
        return true;
    }
    public int getDepth(TreeNode root){
        if(root==null)
            return 0;
        int left=getDepth(root.left);
        if(left==-1) //遍历过程中发现子树不满足平衡条件直接返回
            return -1;
        int right=getDepth(root.right);
        if(right==-1)  //遍历过程中发现子树不满足平衡条件直接返回
            return -1;
        if(Math.abs(left-right)>1)
            return -1;
        else
            return left>right?left+1:right+1;
    }
}
