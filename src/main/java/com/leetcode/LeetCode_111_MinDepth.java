package com.leetcode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 */
public class LeetCode_111_MinDepth {
    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        // 存储根节点
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            // 当前层有多少个节点需要遍历处理
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left == null && currentNode.right == null) {
                    return depth;
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }

            }

            // 当前层遍历结束，增加深度个数
            depth++;
        }

        return depth;
    }
}
