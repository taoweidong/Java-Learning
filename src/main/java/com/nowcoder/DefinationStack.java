package com.nowcoder;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName DefinationStack
 * @Description 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * @Author Taowd
 * @Date 2018/6/19 22:08
 * @Version V1.0
 */
public class DefinationStack {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		DefinationStack stack = new DefinationStack();
		stack.push(12);
		stack.push(24);
		stack.push(8);
		stack.push(1);
		stack.push(200);

		System.out.println(stack.min);

	}

	/**
	 * 自定义栈结构的大小
	 */
	private int size;

	/**
	 * 最小值
	 */
	private int min = Integer.MAX_VALUE;
	/**
	 * 最小值栈
	 */
	private Stack<Integer> minStack = new Stack<Integer>();

	private Integer[] elements = new Integer[10];

	/**
	 * 添加元素
	 *
	 * @param node
	 */
	public void push(int node) {
		ensureCapacity(size + 1);
		elements[size++] = node;
		if (node <= min) {
			minStack.push(node);// 把项压入栈顶。
			min = minStack.peek();// 查看栈顶对象而不移除它。
		} else {
			minStack.push(min);
		}
	}

	/**
	 * 自动扩容的方法
	 *
	 * @param size
	 */
	private void ensureCapacity(int size) {
		int len = elements.length;
		if (size > len) {
			int newLen = (len * 3) / 2 + 1;// 扩容之后的长度
			elements = Arrays.copyOf(elements, newLen);
		}
	}

	/**
	 * 移除栈顶对象并作为此函数的值返回该对象。
	 */
	public void pop() {
		Integer top = top();
		if (top != null) {
			elements[size - 1] = (Integer) null;
		}
		size--;
		minStack.pop();// 移除栈顶对象并作为此函数的值返回该对象。
		min = minStack.peek();// 查看栈顶对象而不移除它。
	}

	public int top() {
		if (!empty()) {
			if (size - 1 > 0) {
				return elements[size - 1];
			}
		}
		return 0;
	}

	/**
	 * 判断当前栈结构是否为空
	 *
	 * @return
	 */
	private boolean empty() {
		return size == 0;
	}

	/**
	 * 返回栈中的最小元素
	 *
	 * @return
	 */
	public int min() {
		return min;
	}
}
