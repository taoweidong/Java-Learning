package com.leetcode;

public class LeetCode_547_FindCircleNum {
  public static void main(String[] args) {
    int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

    //    int[][] isConnected = {{1,0,0}, {0,1,0]}, {0,0,1}};

    System.out.println(new LeetCode_547_FindCircleNum().findCircleNum(isConnected));
  }

  public int findCircleNum(int[][] isConnected) {
    int n = isConnected.length;
    UF uf = new UF(n);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (isConnected[i][j] == 1) {
          uf.union(i, j);
        }
      }
    }

    return uf.count();
  }
}

class UF {
  /** 有多少连通分量 */
  private int count;
  /** 节点x的父节点是parent */
  private int[] parent;

  public UF(int n) {
    this.count = n;
    parent = new int[n];
    //    初始化变量
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
  }

  /**
   * 给定两个节点，判断两个节点是否连通
   *
   * @param left
   * @param right
   * @return
   */
  public boolean isConnected(int left, int right) {
    //    要判断两个元素是否属于同一个集合，只需要看它们的根节点是否相同即可。
    int rootLeft = getRoot(left);
    int rootRight = getRoot(right);

    return rootLeft == rootRight;
  }

  /**
   * 查：找节点的根节点
   *
   * @param n
   * @return
   */
  public int getRoot(int n) {
    while (parent[n] != n) {
      //      此处进行路径压缩
      parent[n] = parent[parent[n]];
      n = parent[n];
    }
    return n;
  }

  /**
   * 并：链接两个节点
   *
   * @param left
   * @param right
   */
  public void union(int left, int right) {
    int rootLeft = getRoot(left);
    int rootRight = getRoot(right);

    if (rootLeft == rootRight) {
      return;
    }

    // 连通的情况下，把left的父节点标记成right
    parent[rootLeft] = rootRight;
    count--;
  }

  public int count() {
    return this.count;
  }
}
