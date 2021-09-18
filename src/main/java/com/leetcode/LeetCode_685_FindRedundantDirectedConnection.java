package com.leetcode;

public class LeetCode_685_FindRedundantDirectedConnection {
    public static void main(String[] args) {
        //
    }
}

class UF_New {
    private int count = 0;
    private int[] parent;

    public UF_New(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    /**
     * 找根节点
     *
     * @param node
     * @return
     */
    public int find(int node) {
        while (parent[node] != node) {
            // 提升查询效率，进行路径压缩
            parent[node] = parent[parent[node]];
            node = parent[node];
        }
        return node;
    }

    public boolean isConnected(int left, int right) {
        int rootLeft = find(left);
        int rootRight = find(right);

        return rootLeft == rootRight;
    }

    public void union(int left, int right) {
        int rootLeft = find(left);
        int rootRight = find(right);
        if (rootLeft == rootRight) {
            return;
        }
        parent[rootLeft] = rootRight;
        this.count--;
    }

    public int count() {
        return this.count;
    }
}
