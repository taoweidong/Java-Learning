// 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设
// 网格的四个边均被水包围。
//
// 示例 1:
//
// 输入:
// 11110
// 11010
// 11000
// 00000
//
// 输出: 1
//
//
// 示例 2:
//
// 输入:
// 11000
// 11000
// 00100
// 00011
//
// 输出: 3
//
// Related Topics 深度优先搜索 广度优先搜索 并查集

package com.huawei;

import java.util.*;

/**
 * 100. 相同的树 https://leetcode-cn.com/problems/same-tree/
 *
 * @author Taoweidong
 */
public class HuaWei_Test20210416_01 {

    public static void main(String[] args) {
        // int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        // int result = new HuaWei_Test20210416_01().isSameTree(height);
        // System.out.println(result);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 特殊情况处理
        if (p == null && q == null) {
            return true;
        }

        // 一个为空一个不为空，显然不同
        if (p == null || q == null) {
            return false;
        }

        // 两个不为空，值不相同,这里其实比较的是根节点
        if (p.val != q.val) {
            return false;
        }

        // 这里进行递归比较。比较树的根节点
        // 如果左右节点相同时，满足条件，返回True
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    void plusOne(TreeNode root) {
        if (root == null) {
            return;
        }
        // 节点值增加1
        root.val += 1;

        plusOne(root.left);
        plusOne(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return root;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            // 找到了待删除的节点信息，删除节点
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);

        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    private TreeNode getMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * 插入二叉树中满足条件的节点信息
     *
     * @param root
     *            二叉树
     * @param val
     *            节点信息
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    public void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        preOrder(root.left, res);
        preOrder(root.right, res);
        res.add(root.val);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        // 先将根节点放入队列中
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            // 遍历队列，把当前层的元素从队列取出来，将下层放入队列
            for (int i = 0; i < size; i++) {
                // 取出队列元素，放入集合
                TreeNode current = queue.poll();
                temp.add(current.val);

                if (current.left != null) {
                    // 将当前节点的左节点放入队列中
                    queue.add(current.left);
                }

                if (current.right != null) {
                    // 将当前节点的右节点放入队列中
                    queue.add(current.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
}

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
