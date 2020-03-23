package com.algorithm.learn.Leetcode._01offer;

/**
 * 15 - 反转链表
 *
 * #### [题目链接](https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=13&tqId=11168&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)
 *
 * > https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=13&tqId=11168&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * #### 题目
 *
 * > 输入一个链表，反转链表后，输出新链表的表头。
 */
public class offer15 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 递归：测试成功
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if(head==null||head.next==null) return head;
//        if(head.next==null) return head;

        ListNode rehead=ReverseList(head.next);
        head.next.next=head;
        head.next=null;

        return rehead;

    }


    /**
     * 迭代
     * 【测试成功~】
     * @param head
     * @return
     */
    public ListNode ReverseList2(ListNode head) {
        if(head==null) return head;

        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }

        return pre;


    }
}
