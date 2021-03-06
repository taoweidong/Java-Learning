package com.nowcoder;

import java.util.Stack;

/**
 * @author Taowd
 * @Description 用两个栈实现一个队列的功能?要求给出算法和思路!
 * <p>
 * <分析>：
 * <p>
 * 入队：将元素进栈A
 * 出队：判断栈B是否为空，如果为空，则将栈A中所有元素pop，并push进栈B，栈B出栈；
 * 如果不为空，栈B直接出栈。
 * 用两个队列实现一个栈的功能?要求给出算法和思路!
 * <分析>：
 * 入栈：将元素进队列A
 * 出栈：判断队列A中元素的个数是否为1，如果等于1，则出队列，否则将队列A中的元素
 * 以此出队列并放入队列B，直到队列A中的元素留下一个，然后队列A出队列，再把 队列B中的元素出队列以此放入队列A中。
 * 队列的性质是：先进先出
 */
public class StackToQueue_Test {

	public static void main(String[] args) {

		StackToQueue_Test stackToQueue = new StackToQueue_Test();
		stackToQueue.push(12);
		stackToQueue.push(23);
		stackToQueue.push(45);

		System.out.println(stackToQueue.pop());
		System.out.println(stackToQueue.pop());
		System.out.println(stackToQueue.pop());
	}

	Stack<Integer> stackA = new Stack<Integer>();

	Stack<Integer> stackB = new Stack<Integer>();

	/**
	 * 入队列的时候
	 * @param node
	 */
	public void push(int node) {
		// 把项压入栈顶
		stackA.push(node);
	}

	/**
	 * 出队列的时候
	 * @return
	 */
	public int pop() {

		if (stackB.empty()) {
			while (!stackA.empty()) {
				stackB.push(stackA.pop());
			}
		}
		return stackB.pop();
	}
}
