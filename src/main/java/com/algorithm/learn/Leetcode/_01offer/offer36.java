package com.algorithm.learn.Leetcode._01offer;

import java.util.HashSet;

/**
 * 目描述
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 *
 * ## 剑指Offer - 36 - 两个链表的第一个公共结点
 *
 * #### [题目链接](https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=13&tqId=11189&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)
 *
 * > https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=13&tqId=11189&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 */
public class offer36 {


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        HashSet<ListNode> set=new HashSet<>();
        for (ListNode cur=pHead1;cur!=null;cur=cur.next){
            set.add(cur);
        }

        for (ListNode cur=pHead2;cur!=null;cur=cur.next){
            if(set.contains(cur)){
                return cur;
            }
        }
        return null;


    }

    /**
     * 方法二，优化
     * O(N)时间，O(1)空间优化解法。思路如下:
     *
     * 先求出两个链表的长度n1、n2；
     * 记长度较长的链表为p1，较短的为p2；
     * 先让p1走abs(n1 - n2)步；
     * 然后让p1、p2一起走，当p1 == p2的时候，就是第一个公共节点；
     *
     */
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        int n1 = len(pHead1), n2 = len(pHead2);
        ListNode p1 = n1 > n2 ? pHead1 : pHead2;
        ListNode p2 = n1 > n2 ? pHead2 : pHead1;
        for(int i = 0; i < Math.abs(n1 - n2); i++) p1 = p1.next;
        for(; p1 != null && p1 != p2 ; p1 = p1.next, p2 = p2.next);
        return p1;
    }
    private int len(ListNode node) {
        int len = 0;
        for (ListNode p = node; p != null; p = p.next) len++;
        return len;
    }



}
