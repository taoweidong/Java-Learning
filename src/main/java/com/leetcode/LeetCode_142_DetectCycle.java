package com.leetcode;

public class LeetCode_142_DetectCycle {
  public static void main(String[] args) {
    //
  }

  public ListNode detectCycle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;

    while (true) {
      if (fast == null || fast.next == null) {
        return null;
      }
      fast = fast.next.next;
      slow = slow.next;

      if (slow == fast) {
        break;
      }
    }
    fast = head;
    while (fast != slow) {
      slow = slow.next;
      fast = fast.next;
    }

    return fast;
  }
}
