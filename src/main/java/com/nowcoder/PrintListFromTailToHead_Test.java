package com.nowcoder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * @author Taowd
 * @date 2018/5/17 - 21:19
 * @Description 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class PrintListFromTailToHead_Test {
	public static void main(String[] args) {
		// 创建链表数据，准备测试
		ListNode ln = new ListNode(1);
		ListNode ln2 = new ListNode(2);
		ListNode ln3 = new ListNode(3);
		ln.next = ln2;
		ln2.next = ln3;

		ArrayList<Integer> arrayList = printListFromTailToHead(ln);

		// 打印处理之后的数据，校验结果
		Iterator<Integer> iterator = arrayList.iterator();
		while (iterator.hasNext()) {
			Integer temp = (Integer) iterator.next();
			System.out.println(temp);

		}

	}

	/**
	 * 利用栈的特性：先进后出的特性
	 *
	 * @param listNode
	 * @return
	 */
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		Stack<Integer> stack = new Stack<Integer>();// 创建一个栈
		ArrayList<Integer> newList = new ArrayList<Integer>();
		ListNode t = listNode;

		while (t != null) {
			stack.push(t.val);// 把数据存储到栈中
			t = t.next;
		}

		while (!stack.empty()) {
			newList.add(stack.pop());// 取栈顶数据，存储到ArrayList中去
		}
		return newList;

	}

	/**
	 * 链表结构
	 */
	public static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

}
