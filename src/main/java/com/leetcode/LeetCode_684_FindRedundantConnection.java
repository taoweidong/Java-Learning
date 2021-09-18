package com.leetcode;

import java.util.Arrays;

public class LeetCode_684_FindRedundantConnection {
    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        System.out.println(Arrays.toString(new LeetCode_684_FindRedundantConnection().findRedundantConnection(edges)));
    }

    public int[] findRedundantConnection(int[][] edges) {
        UF uf = new UF(edges.length + 1);
        for (int i = 0; i < edges.length; i++) {
            if (uf.isConnected(edges[i][0], edges[i][1])) {
                // 如果根节点相同
                return edges[i];
            } else {
                uf.union(edges[i][0], edges[i][1]);
            }
        }
        return null;
    }
}
