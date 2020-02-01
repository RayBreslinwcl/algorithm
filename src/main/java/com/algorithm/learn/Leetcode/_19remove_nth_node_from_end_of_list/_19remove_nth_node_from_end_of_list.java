package com.algorithm.learn.Leetcode._19remove_nth_node_from_end_of_list;

/**
 * Created by Administrator on 2020/2/1.
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 示例：
 给定一个链表: 1->2->3->4->5, 和 n = 2.

 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 说明：
 给定的 n 保证是有效的。

 进阶：
 你能尝试使用一趟扫描实现吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _19remove_nth_node_from_end_of_list {

//    Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 只使用一次遍历。
     * 可以使用两个指针而不是一个指针。
     * 1.第一个指针从列表的开头向前移动 n+1步
     * 2.而第二个指针将从列表的开头出发。
     * 3.这两个指针被 n 个结点分开。
     * 4.我们通过同时移动两个指针向前来保持这个恒定的间隔，直到第一个指针到达最后一个结点。
     * 此时第二个指针将指向从最后一个结点数起的第 n个结点。
     * 重新使第二个指针所引用的结点的 next 指针指向该结点的下下个结点。（删除倒数第n个节点）
     作者：LeetCode
     链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-by-l/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return null;
        }

        ListNode dummy=new ListNode(0);
        dummy.next=head;

        ListNode first=dummy;
        ListNode second=dummy;

        //第一个first先跑k个节点
        for(int i=0;i<=n;i++){
            first=first.next;
            // count++;
        }
        //然后两个同时跑
        while(first!=null){
            first=first.next;
            second=second.next;
            // count++;
        }

        second.next=second.next.next;
        return dummy.next;
    }


}
