package com.leetcode;

import java.util.*;

/** 107. 二叉树的层序遍历 II 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） */
public class LeetCode_107_LevelOrderBottom {
    public static void main(String[] args) {
        //
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            int count = deque.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode current = deque.poll();
                currentLevel.add(current.val);

                if (current.left != null) {
                    deque.add(current.left);
                }
                if (current.right != null) {
                    deque.add(current.right);
                }
            }
            result.add(0, currentLevel);
        }
        return result;
    }
}
