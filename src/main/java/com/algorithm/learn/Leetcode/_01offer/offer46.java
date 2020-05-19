package com.algorithm.learn.Leetcode._01offer;

import java.util.ArrayList;

/**
 * ## 孩子们的游戏(圆圈中最后剩下的数)(约瑟夫环)
 *
 * #### [题目链接](https://www.nowcoder.com/practice/f78a359491e64a50bce2d89cff857eb6?tpId=13&tqId=11199&tPage=3&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)
 *
 * > https://www.nowcoder.com/practice/f78a359491e64a50bce2d89cff857eb6?tpId=13&tqId=11199&tPage=3&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * #### 题目
 *
 * ### 解析
 *
 * 提供几种做法。
 *
 */
public class offer46 {


    class Node {
        int val;
        Node next;

        Node(int v) {
            val = v;
        }
    }

    /**
     * 解法一
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        if (m == 0 || n == 0){
            return -1;
        }
        // 构造环形链表
        Node head = new Node(0);
        Node pre = head;
        for (int i = 1; i < n; i++) {
            Node cur = new Node(i);
            pre.next = cur;
            pre = cur;
        }
        pre.next = head; // 环形
        Node tail = pre;
        int cnt = 0;
        while (head != tail) {
            if (++cnt == m) {
                tail.next = head.next; // del head
                cnt = 0;
                head = tail.next;
            } else {
                tail = tail.next; // del tail
                head = tail.next;
            }
        }
        return head.val;
    }


    /**
     * 解法二
     * 利用取摸。看个例子就懂了。
     *
     * `n = 5, m = 4`。
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution2(int n, int m) {
        if(n == 0 || m == 0){
            return -1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) list.add(i);
        int pos = -1;
        while(list.size() > 1){
            pos = (pos + m) % list.size();
            list.remove(pos);
            pos--;
        }
        return list.get(0);
    }

}
