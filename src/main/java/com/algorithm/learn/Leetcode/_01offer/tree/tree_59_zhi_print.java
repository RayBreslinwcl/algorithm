package com.algorithm.learn.Leetcode._01offer.tree;
import java.util.ArrayList;
import java.util.Stack;

public class tree_59_zhi_print {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        /*
        思路：之字形打印，用两个栈来实现
        打印奇数行时，将他的左右节点保存到另一个栈中，先左后右
        打印偶数行时，同样将左右节点保存到栈中，先右后左
        */
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if(pRoot==null)
            return res;
        Stack[] stack=new Stack[2]; //stack[0]保存偶数层，stack[1]保存奇数层,注意java不支持泛型数组
        stack[0]=new Stack();
        stack[1]=new Stack();
        TreeNode root=pRoot;
        stack[1].push(root);
        int num=1; //当前打印的是第几层
        while((!stack[0].isEmpty())||(!stack[1].isEmpty())){ //有一个栈不为空
            int flag=num%2; //当前要打印的栈
            //int save=flag==0?1:0; //下一层保存在这个栈中
            ArrayList<Integer> row=new ArrayList<>();
            while(!stack[flag].isEmpty()){
                TreeNode temp=(TreeNode)stack[flag].pop();
                if(flag==1) { //当前是奇数行
                    if(temp.left!=null)
                        stack[0].push(temp.left);
                    if(temp.right!=null)
                        stack[0].push(temp.right);
                }else{ //当前是偶数行
                    if(temp.right!=null)
                        stack[1].push(temp.right);
                    if(temp.left!=null)
                        stack[1].push(temp.left);
                }
                row.add(temp.val);
            }
            res.add(row);
            num++;
        }
        return res;
    }
}
