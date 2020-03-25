package com.data.structure;

import java.util.Scanner;

/**
 * 输入一个单向链表，输出该链表中倒数第k个结点，链表的倒数第1个结点为链表的尾指针。
 * @author Taoweidong
 */
public class HuaWei_Test20200325 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//输入的链表节点的个数
		int count = sc.nextInt();

		//定义头结点
		ListNode node = new ListNode(0);
		//根据输入链表的值构造链表信息
		for (int i = 0; i < count; i++) {
			ListNode item = new ListNode(sc.nextInt());
			addNode(node, item);
		}
		//倒数的节点数
		int find = sc.nextInt();
		ListNode result = findByLastValue(node, count, find);
		if (result != null) {
			System.out.println(result.key);
		}

	}

	/**
	 * 添加链表
	 * @param node    链表头
	 * @param newNode 节点
	 */
	public static void addNode(ListNode node, ListNode newNode) {
		//定义临时节点
		ListNode nextNode = node;
		while (nextNode.next != null) {
			nextNode = nextNode.next;
		}

		nextNode.next = newNode;
	}

	/**
	 * 找到链表node的倒数第find的节点
	 * @param node  链表
	 * @param count 总数
	 * @param find  倒数节点
	 * @return 找的的节点值
	 */
	public static ListNode findByLastValue(ListNode node, int count, int find) {
		//定义临时节点
		ListNode nextNode = node.next;
		for (int i = 0; i < (count - find); i++) {
			nextNode = nextNode.next;
		}
		return nextNode;
	}
}

/**
 * 定义链表结构
 */
class ListNode {

	int key;

	ListNode next;

	public ListNode(int key) {

		this.key = key;
	}

}
