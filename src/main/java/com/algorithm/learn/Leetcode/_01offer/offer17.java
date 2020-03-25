package com.algorithm.learn.Leetcode._01offer;

/**
 * 面试被难住的一道真实面试题目，树结构不熟悉，需要强化【***】
 * 17 - 树的子结构
 * 题目链接
 * <p>
 * https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88?tpId=13&tqId=11170&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目
 * <p>
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class offer17 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 思路:
     * <p>
     * 先在A里面找到B的根的值(某个结点A.val = B.val)，然后看看子树是不是都相同(具体来说不是相同，而是A是否包含(A>=B))，这里判断是另一个函数AcontainsB()来判断；
     * 如果上述条件不满足，递归在A.left或A.right中找这个值，然后再递归看子树是不是满足AcontiansB；
     * 然后看递归函数函数AcontainsB()，递归条件root2只要达到空，就说明找到了，返回true，反之，root1达到空，返回false，注意这里不是判断两个树完全相等；
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        //有一个为空，必然不是子树
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean res = false;

        if (root1.val == root2.val)
            res = aContainsB(root1, root2);

        if(!res)
            res=HasSubtree(root1.left,root2); //判断左边是否包含root2

        if(!res)
            res=HasSubtree(root1.right,root2); //判断右边是否包含root2
        return res;
    }


    /**
     * 判断a是否包含B
     *
     * @param A
     * @param B
     * @return
     */
    private boolean aContainsB(TreeNode A, TreeNode B) {
        if (B == null)// B遍历完了, 说明可以
            return true;
        if (A == null)// A遍历完了，B还没有遍历完，说明不是
            return false;
        // A != null && B != null 利用短路特性
        return A.val == B.val
                && aContainsB(A.left, B.left)
                && aContainsB(A.right, B.right);
    }
}
