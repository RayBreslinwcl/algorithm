package com.algorithm.learn.Leetcode._01offer.tree;

/**
 * 参考：https://www.cnblogs.com/gzshan/p/10889257.html
 */
public class tree_58_isSymmetrical {
    boolean isSymmetrical(TreeNode pRoot){
        //左的左，和右的右进行比较，左的右和右的左比较
        if(pRoot==null)
            return true;
        return isSymmetrical(pRoot.left,pRoot.right);
    }
    boolean isSymmetrical(TreeNode pleft,TreeNode pright){
        if(pleft==null && pright==null)
            return true;
        if(pleft==null || pright==null)
            return false;
        if(pleft.val!=pright.val)
            return false;
        return isSymmetrical(pleft.left,pright.right) && isSymmetrical(pleft.right,pright.left);
    }
}
