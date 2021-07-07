package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/***
 * 993. 二叉树的堂兄弟节点
 */
public class LeetCode_993_IsCousins {
  public static void main(String[] args) {
    //
  }

  public boolean isCousins(TreeNode root, int x, int y) {

    Deque<TreeNode> deque = new LinkedList<>();
    deque.add(root);

    int x_index = 0;
    int y_index = 0;
    int index = 1;
    while (!deque.isEmpty()) {
      int count = deque.size();

      for (int i = 0; i < count; i++) {
        TreeNode current = deque.poll();
        if (current.val == x) {
          x_index = index;
        }
        if (current.val == y) {
          y_index = index;
        }

        if (current.left != null) {
          deque.add(current.left);
        }
        if (current.right != null) {
          deque.add(current.right);
        }
      }
      index++;
    }

    if (x_index == y_index && x_index > 2) {
      return true;
    }

    return false;
  }
}
