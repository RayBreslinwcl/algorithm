package com.algorithm.learn.Leetcode._01offer.tree;

/**
 * 参考：https://www.cnblogs.com/gzshan/p/10889249.html
 */
public class tree_57_next_node {
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        /*
        思路：三种情况：（1）若给定结点有右子树，则下一个结点是它右子树中最左边的结点
            （2）若该结点没有右子树，并且是父节点的左结点，则下一个结点就是他的父节点
            （3）若该结点没有右子树，并且是父节点的右结点，则应该沿着父节点向上，直到找到的结点是一个左结点。则下一个结点是该左结点的父节点
        */
        if(pNode==null)
            return null;
        TreeLinkNode res=null;
        if(pNode.right!=null){ //有右子树
            res=pNode.right;
            while(res.left!=null)
                res=res.left;
        }else{  //没有右子树
            TreeLinkNode parent=pNode.next; //父节点
            if(parent!=null && pNode==parent.left) //是父节点的左结点
                res=parent;
            else{ //是父节点的右结点
                while(parent!=null && parent.next!=null && parent!=parent.next.left)
                    parent=parent.next;
                res=parent==null? null : parent.next;
            }
        }
        return res;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}