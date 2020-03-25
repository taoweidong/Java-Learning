package com.nowcoder;

/**
 * @ClassName Merge
 * @Description 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @Author Taowd
 * @Version V1.0
 */
public class Merge_Test {

	//定义链表结构
	public static class ListNode {

		/**
		 * 值
		 */
		int val;

		/**
		 * 后一个节点
		 */
		ListNode next = null;

		/**
		 * 构造函数
		 * @param val
		 */
		ListNode(int val) {

			this.val = val;
		}
	}

	public static void main(String[] args) {

		//创建第一个链表
		ListNode node = new ListNode(12);
		ListNode node1 = new ListNode(34);
		ListNode node2 = new ListNode(45);
		ListNode node3 = new ListNode(55);
		node.next = node1;
		node1.next = node2;
		node2.next = node3;

		//创建第二个链表
		ListNode node11 = new ListNode(6);
		ListNode node12 = new ListNode(8);
		ListNode node13 = new ListNode(14);
		ListNode node14 = new ListNode(89);
		node11.next = node12;
		node12.next = node13;
		node13.next = node14;

		//遍历第一个链表数据
		ListNode n = node;
		while (n != null) {
			if (n.next != null) {
				System.out.print(n.val + "-->");
			} else {
				System.out.print(n.val);
			}
			n = n.next;
		}
		System.out.println();

		//遍历第二个链表数据
		ListNode n2 = node11;
		while (n2 != null) {
			if (n2.next != null) {
				System.out.print(n2.val + "-->");
			} else {
				System.out.print(n2.val);
			}
			n2 = n2.next;
		}
		System.out.println();

		//链表合并
		ListNode n1 = Merge(node, node11);
		while (n1 != null) {
			if (n1.next != null) {
				System.out.print(n1.val + "-->");
			} else {
				System.out.print(n1.val);
			}
			n1 = n1.next;
		}
		System.out.println();

	}

	/**
	 * 合并链表
	 * @param list1 单调递增的第一个链表
	 * @param list2 单调递增的第二个链表
	 * @return
	 */
	public static ListNode Merge(ListNode list1, ListNode list2) {

		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;

		if (list1.val <= list2.val) {
			list1.next = Merge(list1.next, list2);
			return list1;
		} else {
			list2.next = Merge(list1, list2.next);
			return list2;
		}
	}
}
