/**
 * 文件名：MyQueue.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-05 15:15
 * @description 用两个栈构建先入先出队列
 */
public class MyQueue {

    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public MyQueue() {
        inStack = new LinkedList<Integer>();
        outStack = new LinkedList<Integer>();
    }


    /**
     * 将元素 x 推到队列的末尾
     * @param x
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * 从队列的开头移除并返回元素
     * @return
     */
    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    /**
     * 返回队列开头的元素
     * @return
     */
    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }

    /**
     * 如果队列为空，返回 true ；否则，返回 false
     * @return
     */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
