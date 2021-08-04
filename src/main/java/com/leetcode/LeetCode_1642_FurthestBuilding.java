package com.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1642. 可以到达的最远建筑
 */
public class LeetCode_1642_FurthestBuilding {
    public static void main(String[] args) {

        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(2);
        queue.offer(5);
        queue.offer(1);
        queue.offer(3);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int length = heights.length;
        Queue<Integer> queue = new PriorityQueue<>(length);
        for (int i = 1; i < length; i++) {
            int heigh = heights[i] - heights[i - 1];
            if (heigh > 0) {
                queue.offer(heigh);
                if (queue.size() > ladders) {
                    // 梯子用完了，然后从之前用梯子的楼梯中选一个高度差最小的使用砖头
                    bricks -= queue.poll();

                }

                if (bricks < 0) {
                    return i - 1;
                }
            }
        }

        return length - 1;
    }
}
