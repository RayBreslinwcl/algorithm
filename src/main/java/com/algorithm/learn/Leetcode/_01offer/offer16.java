package com.algorithm.learn.Leetcode._01offer;

/**
 * 剑指Offer - 16 - 合并两个排序的链表
 *
 * #### [题目解析](https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&tqId=11169&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)
 *
 * > https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&tqId=11169&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * #### 题目
 *
 * > 输入两个**单调递增**的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足**单调不减**规则。
 */
public class offer16 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 总结：测试了3-5遍才做出了，需要重复做
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode preHead=new ListNode(0);
        ListNode head=preHead;
        while (list1!=null&&list2!=null){
            if(list1.val<=list2.val ){

                head.next=list1;
                list1=list1.next;
                head=head.next;
            }else if(list1.val>list2.val ){
                head.next=list2;
                list2=list2.next;
                head=head.next;
            }
        }

        if(list1==null){
            head.next=list2;
        }
        if(list2==null){
            head.next=list1;
        }

        return preHead.next;
    }
}
