package com.algorithm.learn.Leetcode._00jobinterview;

/**
 * Created by Administrator on 2020/1/31.
 * 给定一个链表，判断链表中是否有环。

 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 示例 1：
 输入：head = [3,2,0,-4], pos = 1
 输出：true
 解释：链表中有一个环，其尾部连接到第二个节点。

 示例 2：
 输入：head = [1,2], pos = 0
 输出：true
 解释：链表中有一个环，其尾部连接到第一个节点。

 示例 3：
 输入：head = [1], pos = -1
 输出：false
 解释：链表中没有环。

 进阶：
 你能用 O(1)（即，常量）内存解决此问题吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/linked-list-cycle
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 【总结：双指针】
 */
public class linked_list_cycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 思路：
     * 通过使用具有 不同速度 的快、慢两个指针遍历链表，空间复杂度可以被降低至 O(1)O(1)。慢指针每次移动一步，而快指针每次移动两步。
     * （1）如果列表中不存在环，最终快指针将会最先到达尾部，此时我们可以返回 false。
     * （2）现在考虑一个环形链表，把慢指针和快指针想象成两个在环形赛道上跑步的运动员（分别称之为慢跑者与快跑者）。
     * 而快跑者最终一定会追上慢跑者。
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        //默认没有节点，或者只有一个节点的链表
        if(head==null||head.next==null){
            return false;
        }
        //慢指针
        ListNode slow=head;
        //快指针
        ListNode fast=head.next;
        while (slow!=fast){
//            if(slow==fast){
//                return true;
//            }
            //如果快等于空，则说明不是环形的
            if(fast==null||fast.next==null){
                return false;
            }
            //分别后移动
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }

}
