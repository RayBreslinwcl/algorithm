package com.algorithm.learn.Leetcode._01offer.tree;

/**
 * 原文链接
 * https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=11157&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * <p>
 * #### 题目
 * <p>
 * > 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * 例如：
 * 输入前序遍历序列`{1,2,4,7,3,5,6,8}`和中序遍历序列`{4,7,2,1,5,3,8,6}`，则重建二叉树并返回。
 */
public class tree_04_reconstruct {

    // Definition for binary tree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        /*根据前序遍历和中序遍历确定一棵二叉树*/
        //递归实现
        if(pre==null||in==null||pre.length==0)
            return null;
        return reConstructBinaryTree(pre,in,0,pre.length-1,0,in.length-1);
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in,int pre_begin,
                                          int pre_end,int in_begin,int in_end)
    {
        ////前序序列：从pre_begin到pre_end,  中序序列：从in_begin到in_end
        //递归结束条件
        if(pre_begin>pre_end || in_begin>in_end)
            return null;

        int rootValue=pre[pre_begin];
        TreeNode root=new TreeNode(rootValue);  //第一个节点就是根节点
        if(pre_begin==pre_end || in_begin==in_end)
            return root;
        //在中序序列中，找到root，前面的就是左子树，右边的就是右子树
        int rootIn=in_begin; //root在中序序列中的位置
        while(rootIn<=in_end && in[rootIn]!=rootValue)
            rootIn++;

        int left_count=rootIn-in_begin; //左子树节点个数
        root.left=reConstructBinaryTree(pre,in,pre_begin+1,pre_begin+left_count,
                in_begin,rootIn-1);
        root.right=reConstructBinaryTree(pre,in,pre_begin+left_count+1,
                pre_end,rootIn+1,in_end);
        return root;
    }
}
