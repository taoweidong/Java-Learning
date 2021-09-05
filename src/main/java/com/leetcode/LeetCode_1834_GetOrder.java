package com.leetcode;

import java.util.*;

/**
 * 1834. 单线程 CPU
 */
public class LeetCode_1834_GetOrder {
    public static void main(String[] args) {
        int[][] tasks = {{1, 2}, {2, 4}, {3, 2}, {4, 1}};
        int[] result = new LeetCode_1834_GetOrder().getOrder(tasks);
        System.out.println(Arrays.toString(result));
    }

    class Task {
        /**
         * 任务编号
         */
        int id;
        /**
         * 任务顺序:入队时间
         */
        int enqueueTime;
        /**
         * 任务执行时间
         */
        int processingTime;

        public Task(int id, int enqueueTime, int processingTime) {
            this.id = id;
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
        }
    }

    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        List<Task> taskList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            taskList.add(new Task(i, tasks[i][0], tasks[i][1]));
        }
        // 按照任务顺序排序
        Collections.sort(taskList, Comparator.comparingInt(x -> x.enqueueTime));

        // 优先队列，选择任务执行时间最短的任务优先执行
        // 则 CPU 将会选择 执行时间最短 的任务开始执行。如果多个任务具有同样的最短执行时间，则选择下标最小的任务开始执行。
        PriorityQueue<Task> queue = new PriorityQueue<Task>((x, y) -> {
            return x.processingTime != y.processingTime ? x.processingTime - y.processingTime : x.id - y.id;
        });

        // 收集结果
        int[] result = new int[n];
        int now = 0;
        int i = 0;
        int index = 0;
        while (i < n) {
            // 把所有 入队时间 <= 当前时间 的任务放入到堆中
            while (i < n && taskList.get(i).enqueueTime <= now) {
                queue.add(taskList.get(i));
                i++;
            }
            // 当前堆内无任务执行(CPU空闲)
            if (queue.isEmpty()) {
                // 更新当前时间
                now = taskList.get(i).enqueueTime;
                while (i < n && taskList.get(i).enqueueTime <= now) {
                    queue.add(taskList.get(i));
                    i++;
                }
            }

            // 此时堆中有任务执行: 取一个任务进行执行
            Task task = queue.poll();
            // 更新结果
            result[index++] = task.id;
            now += task.processingTime;

        }

        while (!queue.isEmpty()) {
            result[index++] = queue.poll().id;
        }

        return result;
    }
}
