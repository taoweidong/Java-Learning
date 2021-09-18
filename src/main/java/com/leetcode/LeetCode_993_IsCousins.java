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
        TreeNode x_parent = null;
        int y_index = 0;
        TreeNode y_parent = null;

        int index = 1;
        while (!deque.isEmpty()) {
            int count = deque.size();

            for (int i = 0; i < count; i++) {
                TreeNode current = deque.poll();

                if (current.left != null) {

                    if (current.left.val == x) {
                        x_index = index;
                        x_parent = current;
                        continue;
                    }
                    if (current.left.val == y) {
                        y_index = index;
                        y_parent = current;
                        continue;
                    }

                    deque.add(current.left);
                }
                if (current.right != null) {

                    if (current.right.val == x) {

                        x_index = index;
                        x_parent = current;
                        continue;
                    }
                    if (current.right.val == y) {
                        y_index = index;
                        y_parent = current;
                        continue;
                    }
                    deque.add(current.right);
                }
            }
            index++;
        }

        if (y_parent != x_parent) {
            if (x_index == y_index) {
                return true;
            }
        }
        return false;
    }
}
