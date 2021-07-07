package com.leetcode;

import java.util.*;

/***
 *剑指 Offer 32 - I. 从上到下打印二叉树
 */
public class LeetCode_32_1_LevelOrder {
  public static void main(String[] args) {
    //
  }

  public int[] levelOrder(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (Objects.isNull(root)) {
      return new int[0];
    }

    Deque<TreeNode> deque = new LinkedList<>();
    deque.add(root);
    while (!deque.isEmpty()) {
      int count = deque.size();
      for (int i = 0; i < count; i++) {
        TreeNode current = deque.poll();
        result.add(current.val);

        if (current.left != null) {
          deque.add(current.left);
        }
        if (current.right != null) {
          deque.add(current.right);
        }
      }
    }

    int[] resultArr = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
      resultArr[i] = result.get(i);
    }

    return resultArr;
  }
}
