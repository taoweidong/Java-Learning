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

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                Node current = queue.poll();
                currentLevel.add(current.val);

                if (current.children != null) {
                    for (Node child : current.children) {
                        queue.add(child);
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
