package com.huawei.oo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * # 【招聘问题】 > 某公司组织一场公开的招聘活动，假设由于人数和场地的限制，每人每次面试的时长不等，并已经安排给定，用（S1，E1）,（S2，E2）,(sj,Ej)...(si<Ei,均为非负整数)表示每场面试的开始时间和结束时间，
 * >面试采用一对一的方式，即一名面试官同时只能面试一名应试者，一名面试官完成一次面试后可以立即进行下一场面试，且每个面试官的面试人次不超过m。为了支撑招聘活动高效顺利进行，请你计算至少需要多少名面试官。
 * <p>
 * - 输入描述：输入的第一行为面试官的最多面试人次m，第二行为当天总的面试场次n，接下来的n行为面试的起始时间和结束时间，起始时间和结束时间用空格分隔。其中，1<=n,m<=500。 -
 * 输出描述：输出一个整数，表示至少需要的面试官数量。
 * <p>
 * 解题思路： 1、首先对所有面试的场次进行汇总，并按照开始和结束时间递增排序 2、总面试场次不为空时，把一个面试官可以面的所有场次m从总面试中分配，每分配一次，面试官+1 - 示例1： - 示例1： 输入： 2 5 1 2 2 3 3
 * 4 4 5 5 6 输出：3
 * <p>
 * 输入： 2 5 1 6 2 6 3 4 4 5 5 6 输出：4
 * <p>
 * 输入： 2 5 1 6 2 6 3 6 4 6 5 6 输出：5
 * <p>
 * 输入： 2 5 1 4 2 3 3 5 2 6 4 6 输出：3
 * <p>
 * 输入： 3 6 2 3 3 4 4 5 1 4 4 6 5 6 输出：2
 * <p>
 * 输入： 1 6 1 4 2 3 3 4 4 5 5 6 6 7 输出：6
 * <p>
 * 输入： 3 9 1 10 2 7 8 12 3 19 10 20 11 30 29 35 36 40 37 38 输出：4
 */

class IntervalNew implements Comparable<IntervalNew> {
    Integer start = 0;
    Integer end = 0;

    public IntervalNew(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(IntervalNew o) {
        if (this.start != o.start) {
            return this.start.compareTo(o.start);
        }
        return this.end.compareTo(o.end);
    }
}

public class Huawei_20200606_04 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 面试官的最多面试人次m
        int m = in.nextInt();
        // 当天总的面试场次n
        int n = in.nextInt();
        // 所有的面试场次信息
        IntervalNew[] intervals = new IntervalNew[n];
        for (int i = 0; i < n; i++) {
            intervals[i] = new IntervalNew(in.nextInt(), in.nextInt());
        }
        int size = minMeetingRooms(intervals, m);
        System.out.println(size);
    }

    public static int minMeetingRooms(IntervalNew[] intervals, int m) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        List<IntervalNew> heap = new ArrayList<>();
        for (IntervalNew interval : intervals) {
            heap.add(interval);
        }
        // 按照开始时间排序:递增排序
        Collections.sort(heap);

        int minMeeter = 0;
        while (!heap.isEmpty()) {
            // 默认第一个为该面试官面试的第一场面试，因为已经排过序了，是最早面试的一个
            IntervalNew first = heap.remove(0);
            int index = m - 1;
            // 遍历剩余的场次，找到m-1场的场次，条件为：前一场的场次end时间小于等于尝试检查的场次的start时间
            // 此处必须使用正序删除
            for (int i = 0; i < heap.size(); i++) {
                if (index > 0) {
                    if (first.end <= heap.get(i).start) {
                        // 在面试场次里面找满足条件的，找到一个就从面试总场次中删除
                        // 更新上次面试的场次信息
                        first = heap.remove(i);
                        index--;
                        // list正序删除时，会漏掉元素，需要重新调整索引
                        i--;
                        continue;
                    }
                } else {
                    break;
                }
            }
            // 面试官++
            minMeeter++;
        }

        return minMeeter;
    }

}
