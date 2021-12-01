package com.algorithm.learn.Leetcode._01offer;

/**
 * 18 - 二叉树的镜像
 *
 * 题目链接
 *
 * https://www.nowcoder.com/practice/a9d0ecbacef9410ca97463e4a5c83be7?tpId=265&&tqId=39229&rp=1&ru=/ta/coding-interviews-all&qru=/ta/coding-interviews-all/question-ranking
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */
public class offer18 {


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }


    /**
     * 思路解析
     *
     * 这题算一个简单题了。
     *
     * 思路很简单，递归求解的过程:
     *
     * 先把当前根节点的左右子树换掉；
     * 然后递归换自己的左右子树即可；
     */
    public void Mirror(TreeNode root) {
        //终止条件
        if(root==null) return;

        //交换
        TreeNode right=root.right;
        TreeNode left=root.left;
        root.right=left;
        root.left=right;

        //迭代
        Mirror(root.left);
        Mirror(root.right);
    }

    /**
     * 更新：一次通过，20211201
     * https://www.nowcoder.com/practice/a9d0ecbacef9410ca97463e4a5c83be7?tpId=265&&tqId=39229&rp=1&ru=/ta/coding-interviews-all&qru=/ta/coding-interviews-all/question-ranking
     *
     * @param pRoot
     * @return
     */
    private TreeNode Mirror2 (TreeNode pRoot) {
        if (pRoot==null) return null;
        TreeNode left=pRoot.left;
        TreeNode right=pRoot.right;
        pRoot.left=right;
        pRoot.right=left;

        Mirror2(pRoot.left);
        Mirror2(pRoot.right);
        return pRoot;
    }
}
