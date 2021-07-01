package com.leetcode;

public class LeetCode_323_CountComponents {
  public static void main(String[] args) {
    //
  }

  public int countComponents(int n, int[][] edges) {
    UF uf = new UF(n);
    for (int i = 0; i < edges.length; i++) {
      if (uf.isConnected(edges[i][0], edges[i][1])) {
        continue;
      } else {
        uf.union(edges[i][0], edges[i][1]);
      }
    }
    return uf.count();
  }
}
