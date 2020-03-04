package com.algorithm.learn.Leetcode._00jobinterview;

import java.util.Stack;

/**
 * Created by Administrator on 2020/1/31.
 * 题目：两个栈实现队列
 *
 * 思路：
 * （1）第一个栈存放写队列的数据。
 * （2）第二个栈存放将要移除队列的数据。
 * -》第二个栈如果没数据，第一个栈里的数据依次弹出压入第二个栈；
 * -》第二个栈如果有数据，则直接pop出栈顶的数据
 *
 * 【总结：面试遇到挂掉，难点是两个栈对队列的实现思路】
 */
public class TwoStackQueue {

    /**
     * 写入栈
     */
    private Stack<Integer> input=new Stack<>();

    /**
     * 输出栈
     */
    private Stack<Integer> out=new Stack<>();

    /**
     * 入队
     * @param t
     */
    public void enqueue(int t){
        input.push(t);
    }

    /**
     * 出队
     * @return
     */
    public int dequeue(){

        if(out.isEmpty()){
            while (!input.isEmpty()){
                out.push(input.pop());
            }
        }

        return out.pop();
    }

    /**
     * 队列中总数
     * @return
     */
    public int getSize(){
        return input.size()+out.size();
    }

    public static void main(String[] args) {

        TwoStackQueue twoStackQueue=new TwoStackQueue();
        twoStackQueue.enqueue(1);
        twoStackQueue.enqueue(4);
        twoStackQueue.enqueue(5);
        twoStackQueue.enqueue(6);
        twoStackQueue.enqueue(19);

        int size=twoStackQueue.getSize();

        for (int i = 0; i < size; i++) {
            System.out.println(twoStackQueue.dequeue());
        }
    }
}
