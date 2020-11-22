package com.leetcode;

public class LeetCode_141_HasCycle {
  public static void main(String[] args) {
    //
  }

  public boolean hasCycle(ListNode head) {
    // 解法思路：⽤两个指针，⼀个跑得快，⼀个跑得慢。如果不含有环，跑得
    // 快的那个指针最终会遇到 null，说明链表不含环；如果含有环，快指针最终
    // 会超慢指针⼀圈，和慢指针相遇，说明链表含有环。
    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      if (fast == slow) {
        return true;
      }
    }
    return false;
  }
}
