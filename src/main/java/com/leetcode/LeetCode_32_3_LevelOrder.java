package com.leetcode;

import java.util.*;

/***
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 */
public class LeetCode_32_3_LevelOrder {
    public static void main(String[] args) {
        //
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int index = 1;
        while (!deque.isEmpty()) {
            int count = deque.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode current = deque.poll();
                if (index % 2 == 0) {
                    currentLevel.add(0, current.val);
                } else {
                    currentLevel.add(current.val);
                }
                if (current.left != null) {
                    deque.add(current.left);
                }

                if (current.right != null) {
                    deque.add(current.right);
                }
            }
            result.add(currentLevel);
            index++;
        }

        return result;
    }
}
