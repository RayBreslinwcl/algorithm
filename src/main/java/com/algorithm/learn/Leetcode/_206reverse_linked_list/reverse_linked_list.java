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
     * 【0305：又面试一次，这个算法真的需要重新理解！】
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

    //递归解法：https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
    /**
     * 递归解法
     这题有个很骚气的递归解法，递归解法很不好理解，这里最好配合代码和动画一起理解。
     递归的两个条件：

     终止条件是当前节点或者下一个节点==null
     在函数内部，改变节点的指向，也就是 head 的下一个节点指向 head 递归函数那句
     head.next.next = head
     很不好理解，其实就是 head 的下一个节点指向head。
     递归函数中每次返回的 cur 其实只最后一个节点，在递归函数内部，改变的是当前节点的指向。
     动画演示如下：
     https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode/


     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    /**
     * 理解：从2个节点链表；3个节点链表；4个节点链表可以理解
     * 【0305：对返回cur还是需要不断理解】
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur=reverseList2(head.next);
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next=head;
        //防止链表循环，需要将head.next设置为空
        head.next=null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }



}
