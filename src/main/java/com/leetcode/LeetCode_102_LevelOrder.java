package com.leetcode;

import java.util.*;

public class LeetCode_102_LevelOrder {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        deque.add(5);

        while (!deque.isEmpty()) {
            System.out.println(deque.poll());
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            // 当前这一层
            int currentCount = deque.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < currentCount; i++) {
                // 队列第一个元素出队列
                TreeNode current = deque.poll();
                currentLevel.add(current.val);

                if (current.left != null) {
                    deque.add(current.left);
                }
                if (current.right != null) {
                    deque.add(current.right);
                }
            }
            result.add(currentLevel);
        }

        return result;
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
