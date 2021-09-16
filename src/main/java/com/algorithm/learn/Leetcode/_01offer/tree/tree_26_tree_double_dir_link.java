package com.algorithm.learn.Leetcode._01offer.tree;

public class tree_26_tree_double_dir_link {

    public TreeNode Convert(TreeNode pRootOfTree) {
        //根据中序遍历采用递归依次实现
        if(pRootOfTree==null)
            return null;
        TreeNode curEndoflink=null;
        TreeNode root=pRootOfTree;
        Convert(root,curEndoflink);

        while(pRootOfTree!=null && pRootOfTree.left!=null){ //链表头是最左边
            pRootOfTree=pRootOfTree.left;
        }
        return pRootOfTree;
    }
    //curEndoflink保存的是当前已经排好的链表的最后一个节点
    public TreeNode Convert(TreeNode pRootOfTree,TreeNode curEndoflink){
        if(pRootOfTree==null)
            return null;
        TreeNode root=pRootOfTree;
        if(root.left!=null) //将左子树构建为链表
            curEndoflink=Convert(root.left,curEndoflink);

        //将根接在左子树的链表之后
        root.left=curEndoflink;
        if(curEndoflink!=null)
            curEndoflink.right=root;
        curEndoflink=root;  //引用改变值，需要return

        if(root.right!=null) //将右子树构建为链表
            curEndoflink=Convert(root.right,curEndoflink);

        return curEndoflink;

    }
}
//public class TreeNode {
//    int val = 0;
//    TreeNode left = null;
//    TreeNode right = null;
//
//    public TreeNode(int val) {
//        this.val = val;
//
//    }
//}