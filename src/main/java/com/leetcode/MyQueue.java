package com.leetcode;

import java.util.Stack;

interface MyQueueInterface {
  /** 添加元素到队尾 */
  public void push(int x);
  /** 删除队头的元素并返回 */
  public int pop();

  /** 返回队头元素 */
  public int peek();
  /** 判断队列是否为空 */
  public boolean empty();
}

/** 用栈实现队列 */
class MyQueue implements MyQueueInterface {

  public static void main(String[] args) {
    MyQueue myQueue = new MyQueue();
    myQueue.push(3);
    myQueue.push(4);
    myQueue.push(1);
    myQueue.push(2);

    // 满足先进先出 栈的特性，用队列进行实现
    while (!myQueue.empty()) {
      System.out.println(myQueue.pop());
    }
  }

  private Stack<Integer> in, out;

  public MyQueue() {
    in = new Stack<>();
    out = new Stack<>();
  }

  @Override
  public void push(int x) {
    in.push(x);
  }

  /**
   * 删除队头的元素并返回
   *
   * @return 队头元素
   */
  @Override
  public int pop() {
    //    先调用peek保证s2非空
    peek();
    return out.pop();
  }

  /**
   * 返回队头元素
   *
   * @return 队头元素
   */
  @Override
  public int peek() {
    if (out.isEmpty()) {
      // 把in中的元素压入到out中
      while (!in.isEmpty()) {
        out.push(in.pop());
      }
    }
    return out.peek();
  }

  @Override
  public boolean empty() {
    return in.isEmpty() && out.isEmpty();
  }
}
