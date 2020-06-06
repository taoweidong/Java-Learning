package com.huawei.oo;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * # 【招聘问题】--答案需要验证下
 * > 某公司组织一场公开的招聘活动，假设由于人数和场地的限制，每人每次面试的时长不等，并已经安排给定，用（S1，E1）,（S2，E2）,(sj,Ej)...(si<Ei,均为非负整数)表示每场面试的开始时间和结束时间，
 * >面试采用一对一的方式，即一名面试官同时只能面试一名应试者，一名面试官完成一次面试后可以立即进行下一场面试，且每个面试官的面试人次不超过m。为了支撑招聘活动高效顺利进行，请你计算至少需要多少名面试官。
 * <p>
 * - 输入描述：输入的第一行为面试官的最多面试人次m，第二行为当天总的面试场次n，接下来的n行为面试的起始时间和结束时间，起始时间和结束时间用空格分隔。其中，1<=n,m<=500。
 * - 输出描述：输出一个整数，表示至少需要的面试官数量。
 * <p>
 * - 示例1：
 * 输入：
 * 2
 * 5
 * 1 2
 * 2 3
 * 3 4
 * 4 5
 * 5 6
 * 输出：3
 */
class Interval {
    int start = 0;
    int end = 0;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Huawei_20200606_03 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Interval[] intervals = new Interval[n];
        for (int i = 0; i < n; i++) {
            intervals[i] = new Interval(in.nextInt(), in.nextInt());
        }
        int size = minMeetingRooms(intervals);
        System.out.println(size);
    }

    public static int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // 按照开始时间排序
        Arrays.sort(intervals, (o1, o2) -> (o1.start - o2.start));
        // 按照结束时间排序
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>((o1, o2) -> (o1.end - o2.end));
        heap.offer(intervals[0]);

        // 逐个添加面试官,如果你的开始时间>已有会议的面试官结束时间，就不用开辟会议室了
        // 否则需要新开一个
        for (int i = 1; i < intervals.length; i++) {
            Interval tmp = heap.poll();
            if (tmp.end <= intervals[i].start) {
                tmp.end = intervals[i].end;
            } else {
                heap.offer(intervals[i]);
            }
            heap.offer(tmp);
        }

        return heap.size();
    }


}


