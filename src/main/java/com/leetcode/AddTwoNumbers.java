package com.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * 题目描述：给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。<br/>
 * 时间复杂度：O(max⁡(m,n))，假设 mmm 和 nnn 分别表示 l1l1l1 和 l2l2l2 的长度，上面的算法最多重复 max⁡(m,n)次。<br/>
 * 空间复杂度：O(max⁡(m,n))， 新列表的长度最多为 max⁡(m,n)+1。<br/>
 * @author Taowd
 * @version 2019年1月20日
 * @see AddTwoNumbers
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(9);
		ListNode l2 = new ListNode(9);
		// ListNode l3 = new ListNode(9);
		l1.next = l2;
		// l2.next = l3;

		ListNode l01 = new ListNode(8);
		ListNode l02 = new ListNode(8);
		ListNode l03 = new ListNode(8);
		l01.next = l02;
		l02.next = l03;

		ListNode result = new AddTwoNumbers().addTwoNumbers(l1, l01);

		List<Integer> listNode = new ArrayList<Integer>();
		while (result != null) {
			listNode.add(result.val);
			result = result.next;
		}

		System.out.println(JSON.toJSONString(listNode));

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dumHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dumHead;
		int carry = 0;// 存放进位的值
		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = x + y + carry;
			carry = sum / 10;// 取整
			curr.next = new ListNode(sum % 10);
			// 最终结果的一位的值
			curr = curr.next;
			if (p != null)
				p = p.next;
			if (q != null)
				q = q.next;
		}
		// 如果链表最后一位是进位的计算，进位的值存在carry中
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}

		return dumHead.next;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
