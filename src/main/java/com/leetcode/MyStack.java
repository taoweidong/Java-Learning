package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

interface MyStackImpl {
    /** 添加元素到栈顶 */
    public void push(int x);

    /** 删除栈顶的元素并返回 */
    public int pop();

    /** 返回栈顶元素 */
    public int top();

    /** 判断栈是否为空 */
    public boolean empty();
}

/** 用队列实现栈 */
public class MyStack implements MyStackImpl {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        System.out.println(myStack.top());
        myStack.push(2);
        System.out.println(myStack.top());
        myStack.push(3);
        System.out.println(myStack.top());
        myStack.push(4);
        System.out.println(myStack.top());

        System.out.println("****************");

        while (!myStack.empty()) {
            System.out.println(myStack.pop());
        }
    }

    Queue<Integer> queue = new LinkedList<>();
    /** 队列尾的数据，相当于与栈顶元素 */
    int top_element = 0;

    @Override
    public void push(int x) {
        // 将数据添加到队列中去
        queue.offer(x);
        // 每次添加到队列尾的数据相当于栈顶元素
        top_element = x;
    }

    @Override
    public int pop() {
        // 把队列中的数据颠倒一下
        int size = queue.size();
        while (size > 2) {
            queue.offer(queue.poll());
            size--;
        }
        // 更新栈顶元素
        top_element = queue.peek();
        queue.offer(queue.poll());
        // 删除之前的队尾元素
        return queue.poll();
    }

    /**
     * 返回栈顶元素
     *
     * @return
     */
    @Override
    public int top() {
        return top_element;
    }

    @Override
    public boolean empty() {
        return queue.isEmpty();
    }
}
