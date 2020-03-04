package com.algorithm.learn.Leetcode._00jobinterview;

import com.algorithm.learn.Leetcode._206reverse_linked_list.reverse_linked_list;

/**
 * Created by Administrator on 2020/2/1.
 * 链表中倒数第k个节点
 * 思路：
 * 两个指针，
 * 1.一个指针first先开始跑，指针first跑到k-1个节点后
 * 2.另外一个节点second开始跑
 * 3.当first跑到最后first.next=null时，second所指的指针就是倒数第k个节点。
 *
 * first
 * second
 * |
 * 1  ->  2  ->  3  ->  4  ->  5
 * 当倒数第3的时候，最后
 *                              first
 *              second           |
 *                |             |
 * 1  ->  2  ->  3  ->  4  ->  5
 * 【总结：双指针】
 */
public class LinkedListKfromTail {

    //链表类
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode findKfromTail(ListNode head,int k){
        if(head==null){
            return null;
        }
        //记录节点的个数,如果k>count,则返回空
        int count=0;

        ListNode first=head;
        ListNode second=head;

        //第一个first先跑k-1个节点
        for(int i=0;i<k-1;i++){
            first=first.next;
            count++;
        }
        //然后两个同时跑
        while (first.next!=null){
            first=first.next;
            second=second.next;
            count++;
        }
        //如果k>count,则返回空
        if(k>count){
            return null;
        }
        return second;

    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(3);
        listNode.next.next.next=new ListNode(4);
        listNode.next.next.next.next=new ListNode(5);
//        listNode.next.next.next.next.next=new ListNode(5);

        //链表1-》2-》3-》4-》5
        System.out.println(LinkedListKfromTail.findKfromTail(listNode,3).val);
    }
}
