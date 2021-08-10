package com.leetcode;

import java.util.Objects;

public class LeetCode_116_Connect {
    public static void main(String[] args) {

    }

    public Node connect11(Node root) {
        if (Objects.isNull(root) || Objects.isNull(root.left)) {
            return root;
        }

        root.left.next = root.right;

        connect11(root.left);
        connect11(root.right);

        return root;
    }

    public Node connect(Node root) {
        if (Objects.isNull(root) || Objects.isNull(root.left)) {
            return root;
        }
        connectTarget(root.left, root.right);
        return root;
    }

    private void connectTarget(Node left, Node right) {
        if (Objects.isNull(left) || Objects.isNull(right)) {
            return;
        }

        left.next = right;

        connectTarget(left.left, left.right);
        connectTarget(right.left, right.right);
        connectTarget(left.right, right.left);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
