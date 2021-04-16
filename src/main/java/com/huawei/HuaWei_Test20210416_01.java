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

import java.util.Stack;

/**
 * 100. 相同的树 https://leetcode-cn.com/problems/same-tree/
 *
 * @author Taoweidong
 */
public class HuaWei_Test20210416_01 {

  public static void main(String[] args) {
    //    int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    //    int result = new HuaWei_Test20210416_01().isSameTree(height);
    //    System.out.println(result);
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
