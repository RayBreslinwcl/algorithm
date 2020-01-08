package com.algorithm.learn.Leetcode._206reverse_linked_list;

/**
 * Created by Administrator on 2020/1/8.
 * 题目：反转一个单链表。
     示例:
     输入: 1->2->3->4->5->NULL
     输出: 5->4->3->2->1->NULL
     进阶:
     你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class reverse_linked_list {

//    Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    /**
     * 非递归解法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode nextTemp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nextTemp;
        }
        return pre;
    }
}
