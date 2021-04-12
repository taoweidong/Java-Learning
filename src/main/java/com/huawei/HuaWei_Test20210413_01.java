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
 * 556. 下一个更大元素 III
 *
 * @author Taoweidong
 */
public class HuaWei_Test20210413_01 {

  public static void main(String[] args) {

    int[][] M = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

    int result = new HuaWei_Test20210413_01().findCircleNum(M);
    System.out.println(result);
  }

  public int findCircleNum(int[][] M) {
    // 默认互不连通
    int n = M.length;
    UF uF = new UF(n);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (M[i][j] == 1) {
          uF.union(i, j);
        }
      }
    }
    return uF.count();
  }
}

class UF {
  // 有多少连通分量
  private int count;
  //  节点x的节点是parent[x]
  private int[] parent;

  public UF(int n) {
    // 默认一开始互不相同
    this.count = n;
    // 父节点指针初始化指向自己
    parent = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
  }

  /**
   * 链接p和q两个点
   *
   * @param p 节点1
   * @param q 节点2
   */
  public void union(int p, int q) {
    int rootP = find(p);
    int rootQ = find(q);
    if (rootP == rootQ) {
      // 说明当前的两个节点就在一颗树上
      return;
    }
    // 如果两个节点的根节点不同，那就说明是在两棵树上，需要将两棵树合并
    parent[rootP] = rootQ;
    // parent[rootq] = rootP; 效果一样
    // 连通分量减一
    count--;
  }

  /**
   * 寻找某个节点的根节点
   *
   * @param x 指定节点
   * @return 根节点
   */
  private int find(int x) {
    while (parent[x] != x) {
      // 进行路径压缩
      parent[x] = parent[parent[x]];
      x = parent[x];
    }
    return x;
  }

  /**
   * 返回图中一共多少连通分量
   *
   * @return 连通分量的个数
   */
  public int count() {
    return count;
  }

  /**
   * 判断两个点是否连通
   *
   * @param p 节点1
   * @param q 节点2
   * @return True:连通 False:不连通
   */
  public boolean connected(int p, int q) {
    int rootP = find(p);
    int rootQ = find(q);
    return rootP == rootQ;
  }
}
