# [【动画模拟】很简单易懂的方法](https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/dong-hua-mo-ni-hen-jian-dan-yi-dong-de-f-w6f8/)

[程序厨L5](https://leetcode-cn.com/u/chefyuan/)发布于 2021-03-282.6k[字节跳动](https://leetcode-cn.com/company/bytedance/)[Java](https://leetcode-cn.com/topic/java/)

> 我将我所有的动画题解文章全部开源在了 Github 上，大概**有 80 来篇文章， 100多个动画**，专门为刚刷题不知道从何刷起和看不懂题解的同学准备的算法基地。
>
> https://github.com/chefyuan/algorithm-base
>
> 另外大家如果需要加入**刷题打卡小队**，**互相监督，共同进步**。可以点击我的小屋内的**刷题小队**进入，但是要**记得备注和坚持打卡**。
>
> 还整理了一份面试必刷题大纲，也可以在我的小屋点击刷题大纲获取。
>
> [小屋地址](https://cdn.jsdelivr.net/gh/tan45du/photobed@master/微信图片_20210320152235.2c1f5hy6gmas.png)

今天我们来说一下反转链表 2，其实这个和 1 的思路差不多，今天先说一个比较好理解的方法，完全按照反转链表 1 的方法来解决，大家看这个题目之前要先看一下[【动画模拟】leetcode 206 反转链表](https://github.com/chefyuan/algorithm-base/blob/main/animation-simulation/链表篇/leetcode206反转链表.md)

下面我们先来看一下题目。

#### [92. 反转链表 II](https://leetcode-cn.com/problems/reverse-linked-list-ii/)

难度中等836

给你单链表的头指针 `head` 和两个整数 `left` 和 `right` ，其中 `left <= right` 。请你反转从位置 `left` 到位置 `right` 的链表节点，返回 **反转后的链表** 。

**示例 1：**

![img](https://pic.leetcode-cn.com/1616905281-ytwsGP-rev2ex2.jpg)

> 输入：head = [1,2,3,4,5], left = 2, right = 4
> 输出：[1,4,3,2,5]

**示例 2：**

> 输入：head = [5], left = 1, right = 1
> 输出：[5]

含义就是让我们反转部分链表。也就是上面蓝色的部分，那我们怎么借助 1 的方法来解决呢？

我们主要通过两部分来解决，先截取需要翻转的部分，然后再头尾交换即可。下面我们通过一个动画来看看具体步骤。





是不是很容易理解，下面我们来看代码吧。

```java
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        //虚拟头节点
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode pro = temp;
        //来到 left 节点前的一个节点
        int i = 0;
        for (; i < left-1; ++i) {
            pro = pro.next;
        }
        // 保存 left 节点前的第一个节点
        ListNode leftNode = pro;
        for (; i < right; ++i) {
            pro = pro.next;
        }
        // 保存 right 节点后的节点
        ListNode rightNode = pro.next;
        //切断链表
        pro.next = null;
        ListNode newhead = leftNode.next;
        leftNode.next = null;
        leftNode.next = rever(newhead);
        //重新接头
        newhead.next = rightNode;
        return temp.next;

    }
    //和反转链表1代码一致
    public ListNode rever (ListNode head) {
         ListNode low = null;
        ListNode pro = head;
        while (pro != null) {
            ListNode temp = pro;
            pro = pro.next;
            temp.next = low;
            low = temp;
        }     
        return low;
    }
}
```

好啦，感谢各位支持，记得留下阅读的痕迹呀

下一篇：in rust we trust -- list (reverse_between/92. 反转链表 II)

© 著作权归作者所有

4

条评论

最热

编辑

预览



评论

[![jlchai](https://assets.leetcode-cn.com/aliyun-lc-upload/users/jlchai/avatar_1628467100.png)柴建龙](https://leetcode-cn.com/u/jlchai/)

2021-08-08

建议命名有含义

1踩回复

[![gao-meng-lu](https://assets.leetcode-cn.com/aliyun-lc-upload/users/gao-meng-lu/avatar_1616424214.png)高梦露和小霸王多做题L1](https://leetcode-cn.com/u/gao-meng-lu/)

（编辑过）2021-04-02

这个思路很清晰, 将链表斩成3段, 反转中间的一段(反转的操作完全复用反转链表1), 再两端接上 👍

1踩回复

[![zhenxingli](https://assets.leetcode-cn.com/aliyun-lc-upload/users/hhgggg/avatar_1622114729.png)我为啥这么菜啊L1](https://leetcode-cn.com/u/zhenxingli/)

2021-03-30

还是这个思路可以看懂

赞踩回复

[![chefyuan](https://assets.leetcode-cn.com/aliyun-lc-upload/users/tan45du/avatar_1609256941.png)程序厨L5](https://leetcode-cn.com/u/chefyuan/)

2021-03-28

各位留下阅读的痕迹呀