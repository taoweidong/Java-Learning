package com.offer;

import java.util.Objects;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 */
public class Offer_22_GetKthFromEnd {
    public static void main(String[] args) {
        // ListNode root = new ListNode(1);
        // root.next = new ListNode(2);
        // root.next.next = new ListNode(3);
        // root.next.next.next = new ListNode(4);
        // root.next.next.next.next = new ListNode(5);

        ListNode root = new ListNode(1);
        // root.next = new ListNode(2);
        // root.next.next = new ListNode(3);
        // root.next.next.next = new ListNode(4);
        // root.next.next.next.next = new ListNode(5);

        ListNode kthFromEnd = new Offer_22_GetKthFromEnd().getKthFromEnd(root, 1);
        System.out.println(kthFromEnd.val);

    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (k < 0) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (k > 0 && !Objects.isNull(fast)) {
            fast = fast.next;
            k--;
        }

        while (!Objects.isNull(fast)) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
