package com.algorithm.learn.Leetcode._01offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * <p>
 * 剑指Offer - 23 - 二叉搜索树的后序遍历序列
 * <p>
 * 题目链接
 * <p>
 * https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd?tpId=13&tqId=11176&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class offer23 {

    /**
     * 解析参考：https://github.com/RayBreslinwcl/ZXBlog
     * 解析
     * <p>
     * 思路:
     * <p>
     * 在后序遍历得到的序列中，最后一个数是树的根节点 root；
     * 二叉搜索树的后序遍历数组可以划分为两部分。第一部分是左子树结点的值，它们都比根节点的值小；第二部分是右子树结点的值，它们都比根节点的值大；
     * 所以按照上面的方法，递归的时候，每次先确定根root，然后在[L,R]范围内每次先找到mid，即第一个>root.val的位置，后面的就是右子树，必须要全部>root.val，如果不满足就返回false；
     *
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int[] sequence) {

        if (sequence == null || sequence.length == 0)
            return false;

        return rec(sequence, 0, sequence.length - 1);

    }

    private boolean rec(int[] seq, int L, int R) {

        if (L >= R) //前面条件已经满足
            return true;

        int root = seq[R]; //根
        int i = L;

        //找到左右子树分界
        while (i <= R - 1 && seq[i] < root) {
            i++;
        }

        int mid = i; //seq[mid]>root,从mid开始是右子树
        while (i < R - 1) { //检查右侧是否有小于root的
            if (seq[i] < root)
                return false;
            i++;
        }

        return rec(seq, L, mid - 1) && rec(seq, mid, R - 1);//左右两侧是否都是满足条件

    }

}
