package com.leetcode;

import java.util.*;

/***
 * 429. N 叉树的层序遍历
 */
public class LeetCode_429_LevelOrder {
  public static void main(String[] args) {
    //
  }

  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> result = new ArrayList<>();
    if (Objects.isNull(root)) {
      return result;
    }

    Deque<Node> deque = new LinkedList<>();
    deque.add(root);

    while (!deque.isEmpty()) {
      int count = deque.size();
      List<Integer> currentLevel = new ArrayList<>();
      for (int i = 0; i < count; i++) {
        Node current = deque.poll();
        currentLevel.add(current.val);

        if (current.children != null) {
          for (Node child : current.children) {
            deque.add(child);
          }
        }
      }
      result.add(currentLevel);
    }

    return result;
  }
}

/** n叉树结构 */
class Node {
  public int val;
  public List<Node> children;

  public Node() {}

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, List<Node> _children) {
    val = _val;
    children = _children;
  }
}
