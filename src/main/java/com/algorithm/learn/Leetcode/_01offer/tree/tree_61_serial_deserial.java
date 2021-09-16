package com.algorithm.learn.Leetcode._01offer.tree;

public class tree_61_serial_deserial {

    //序列化
    String Serialize(TreeNode root){
        if(root==null)
            return "#,";
        String res="";
        res+=root.val+",";   //前序遍历，根左右
        res+=Serialize(root.left);
        res+=Serialize(root.right);
        return res;
    }

    //反序列化
    int start=-1;
    TreeNode Deserialize(String str){
        if(str==null || str.length()==0)
            return null;
        String[] strArr=str.split(",");
        return Deserialize(strArr);
    }
    TreeNode Deserialize(String[] strArr){
        start++;
        if(start>=strArr.length || strArr[start].equals("#"))
            return null;
        TreeNode cur=new TreeNode(Integer.valueOf(strArr[start]));
        cur.left=Deserialize(strArr);
        cur.right=Deserialize(strArr);
        return cur;
    }


    /**
     *
     * 实例1：
     *      1
     *     / \
     *    2   3
     *   /   / \
     *  4   5   6
     *  序列化为
     *  "1,2,4,$,$,$,3,5,$,$,6,$,$"
     *
     * 实例2：from-官网
     *      1
     *     / \
     *    2   3
     *       / \
     *      6   7
     *  序列化为
     *  “{1,2,3,#,#,6,7}”
     *
     * @param args
     */
    public static void main(String[] args) {

        String serialString="1,2,4,#,#,#,3,5,#,#,6,#,#";
        TreeNode deserialize = new tree_61_serial_deserial().Deserialize(serialString);
        System.out.println("===反序列化后的结果===");

        System.out.println("===序列化后的结果===");
        System.out.println(new tree_61_serial_deserial().Serialize(deserialize));

        System.out.println("===Finished===");
    }
}

//public class TreeNode {
//    int val = 0;
//    TreeNode left = null;
//    TreeNode right = null;
//
//    public TreeNode(int val) {
//        this.val = val;
//    }
//}