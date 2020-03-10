package com.algorithm.learn.Leetcode._21merge_two_sorted_lists;

/**
 * Created by Administrator on 2020/2/1.
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

 示例：

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class merge_two_sorted_lists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 思路：【复习2】
     * l1和l2两个链表
     * 1.新建一个链表头prehead，并再创建一个辅助头head指向prehead。后续移动只是移动head
     * 2.比较l1和l2，把head指向比较小的那一个，同时head也进行后移
     * 3.最后，判断l1或者l2哪个后结束，则黏贴到后面即可！
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        //合并
        ListNode prehead=new ListNode(-1);
        ListNode head=prehead;


        while (l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                head.next=l1;
                l1=l1.next;
            }else {
                head.next=l2;
                l2=l2.next;
            }
            head=head.next;
        }

        //把l1或l2长的那一个黏贴到后面
        head.next=(l1==null?l2:l1);
        return prehead.next;
    }

}
