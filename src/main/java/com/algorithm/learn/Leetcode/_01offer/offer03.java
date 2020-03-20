package com.algorithm.learn.Leetcode._01offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 题目描述
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class offer03 {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    ArrayList<Integer> reslist=null;
    /**
     * 1.递归解法
     * 【验证】
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        reslist=new ArrayList<>();
        res(listNode);
        return reslist;
    }

    public void  res(ListNode listNode){
        if(listNode==null){
            return;
        }
        res(listNode.next);
        reslist.add(listNode.val);
    }


    /**
     * 2.非递归解法：栈
     * 【验证】
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {


        //存储结果list
        ArrayList<Integer> reslist2=new ArrayList<>();
        ListNode cur=listNode;
        //缓存栈
        Stack<Integer> stack=new Stack<>();

        while (cur!=null){  //一定注意截止位置
            stack.push(cur.val);
            cur=cur.next;
        }

        while (!stack.isEmpty()){
            reslist2.add(stack.pop());
        }
        return reslist2;
    }
}


