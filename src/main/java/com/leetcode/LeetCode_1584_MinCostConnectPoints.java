package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 1584. 连接所有点的最小费用
 */
public class LeetCode_1584_MinCostConnectPoints {
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println(new LeetCode_1584_MinCostConnectPoints().minCostConnectPoints(points));

    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Union union = new Union(n);

        List<Edge> edges = new ArrayList<>(n);
        // 建立边关系
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges
                    .add(new Edge(i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])));
            }
        }

        // 排序
        Collections.sort(edges, Comparator.comparingInt(x -> x.weight));

        int sum = 0;
        int count = 0;
        for (Edge edge : edges) {
            if (union.find(edge.i) != union.find(edge.j)) {
                sum += edge.weight;
                union.union(edge.i, edge.j);
                count++;
                if (count == n - 1) {
                    break;
                }
            }
        }

        return sum;
    }

    /**
     * 两点之间以及权值
     */
    class Edge {
        int i;
        int j;
        int weight;

        public Edge(int i, int j, int weight) {
            this.i = i;
            this.j = j;
            this.weight = weight;
        }
    }

    class Union {
        int[] parent;
        int[] size;

        public Union(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = i;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            if (size[rootX] > size[rootY]) {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            } else {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                x = parent[x];
                // 压缩路径
                parent[x] = parent[parent[x]];
            }
            return x;
        }
    }
}
