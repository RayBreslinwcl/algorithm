package com.algorithm.learn.Leetcode._01offer.tree;

import java.util.ArrayList;

public class tree_34_find_path {


    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();


    /**
     *
     * 参考：链接https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=13&tqId=11177&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
     *
     * 如二叉树root为{10,5,12,4,7},expectNumber为22
     * 实际模拟
     * sum=10
     * 1-》root=10 list=（10）
     *      -》 左：root=5 list=（10，5）
     *          -》左： root=4 list=（10，5，4） -》到最后一步回退 list=（10，5）
     *
     *          -》右： root=7 list=（10，5，7） -》到最后一步回退 list=（10，5）
     *
     *          -》到最后一步回退：list（10）
     *
     *      -》 右：root=12 list=（10，12）
     *          -》左： root=null ：无
     *          -》右： root=null ：无
     *          -》回退： list（10）
     *
     *      -》回退 list=null
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return listAll;

        list.add(root.val);
        target = target - root.val;

        if (target == 0 && root.left == null && root.right == null) {
            //这里必须要重新生成一个对象实例，并使用list对其初始化赋值
            listAll.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        //模拟了栈回退,当前节点为叶子节点或者已经访问过的情况下，回溯到父节点
        list.remove(list.size() - 1);
        return listAll;
    }


}
