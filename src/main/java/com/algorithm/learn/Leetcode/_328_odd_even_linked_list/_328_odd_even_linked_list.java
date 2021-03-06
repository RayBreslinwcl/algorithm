package com.algorithm.learn.Leetcode._328_odd_even_linked_list;

/**
 * Created by Administrator on 2020/2/8.
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。

 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

 示例 1:
 输入: 1->2->3->4->5->NULL
 输出: 1->3->5->2->4->NULL
 示例 2:

 输入: 2->1->3->5->6->4->7->NULL
 输出: 2->3->6->7->1->5->4->NULL
 说明:

 应当保持奇数节点和偶数节点的相对顺序。
 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _328_odd_even_linked_list {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 核心注意：奇偶指的是编号，不是值！
     *
     * 一个 LinkedList 需要一个头指针和一个尾指针来支持双端操作。
     * 1.用变量 head 和 odd 保存奇链表的头和尾指针。
     * 2.evenHead 和 even 保存偶链表的头和尾指针。
     * 3.算法会遍历原链表一次并把奇节点放到奇链表里去、偶节点放到偶链表里去。
     * 遍历整个链表我们至少需要一个指针作为迭代器。
     * 这里 odd 指针和 even 指针不仅仅是尾指针，也可以扮演原链表迭代器的角色。

     作者：LeetCode
     链接：https://leetcode-cn.com/problems/odd-even-linked-list/solution/qi-ou-lian-biao-by-leetcode/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if(head==null) return null;

        ListNode odd=head;
        ListNode even=head.next,evenHead=even;
        while (even!=null&&even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;


    }
}
