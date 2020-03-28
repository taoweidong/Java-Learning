package com.data.structure;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 栈相关方法熟悉：先进后出
 * @author Taoweidong
 */
public class StackDemo {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();
		stack.add(100);
		stack.add(34);
		stack.add(56);
		stack.add(77);

		while (!stack.isEmpty()) {
			//pop 取栈顶元素并删除
			//peek只取栈顶元素不删除
			System.out.println(stack.pop());
		}

		System.out.println("*******************************");
		for (Integer item : stack) {
			System.out.println(item);
		}

	}
}
