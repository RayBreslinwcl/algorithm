package com.algorithm.learn.Leetcode._01offer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * <p>
 * 剑指Offer - 21 - 栈的压入、弹出序列
 * <p>
 * 题目链接
 * <p>
 * https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tqId=11174&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class offer21 {


    /**
     * 1、思路一
     * <p>
     * 先看过程:
     * <p>
     * 1.遍历pushA，使用一个索引popIndex下标记录popA走到的位置
     * 如果pushA[i] = popA[popIndex]，就popIndex++(不处理)；
     * 否则(不相等)，就入栈pushA[i]；
     * <p>
     * 2.最后全部弹栈，每弹一个，就看stack.pop() == popA[popIndex]，
     * 如果不等，就返回false，否则返回true；
     *
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;

        for (int i = 0; i < pushA.length; i++) {
            if (pushA[i] == popA[popIndex]) {
                popIndex++;
            } else {
                stack.push(pushA[i]);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.pop() != popA[popIndex++]) {
                return false;
            }
        }
        return true;

    }


    /**
     * 思路二
     * 【思路】借用一个辅助的栈，遍历压栈顺序，先讲第一个放入栈中，这里是1，然后判断栈顶元素是不是出栈顺序的第一个元素，这里是4，很显然1≠4，所以我们继续压栈，直到相等以后开始出栈，出栈一个元素，则将出栈顺序向后移动一位，直到不相等，这样循环等压栈顺序遍历完成，如果辅助栈还不为空，说明弹出序列不是该栈的弹出顺序。
     * <p>
     * 举例：
     * <p>
     * 入栈1,2,3,4,5
     * <p>
     * 出栈4,5,3,2,1
     * <p>
     * 首先1入辅助栈，此时栈顶1≠4，继续入栈2
     * <p>
     * 此时栈顶2≠4，继续入栈3
     * <p>
     * 此时栈顶3≠4，继续入栈4
     * <p>
     * 此时栈顶4＝4，出栈4，弹出序列向后一位，此时为5，,辅助栈里面是1,2,3
     * <p>
     * 此时栈顶3≠5，继续入栈5
     * <p>
     * 此时栈顶5=5，出栈5,弹出序列向后一位，此时为3，,辅助栈里面是1,2,3
     * <p>
     * ….
     * <p>
     * 依次执行，最后辅助栈为空。如果不为空说明弹出序列不是该栈的弹出顺序。
     * 【参考：https://www.nowcoder.com/profile/214250/codeBookDetail?submissionId=1523124】
     */
    public boolean IsPopOrder2(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> s = new Stack<Integer>();
        //用于标识弹出序列的位置
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            s.push(pushA[i]);
            //如果栈不为空，且栈顶元素等于弹出序列
            while (!s.empty() && s.peek() == popA[popIndex]) {
                //出栈
                s.pop();
                //弹出序列向后一位
                popIndex++;
            }
        }
        return s.empty();
    }
}
