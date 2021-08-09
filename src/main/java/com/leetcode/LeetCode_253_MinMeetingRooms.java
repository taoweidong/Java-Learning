package com.leetcode;

import java.util.*;

/**
 * 253. 会议室 II
 */
public class LeetCode_253_MinMeetingRooms {
    public static void main(String[] args) {

        // int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};

        // int[][] intervals = {{7, 10}, {2, 4}};
        int[][] intervals = {{1, 4}, {2, 4}, {4, 7}, {8, 12}};
        System.out.println(new LeetCode_253_MinMeetingRooms().minMeetingRooms(intervals));
        System.out.println(new LeetCode_253_MinMeetingRooms().minMeetingRooms22(intervals));

    }

    public int minMeetingRooms22(int[][] intervals) {

        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) {
            return 0;
        }

        // Min heap
        PriorityQueue<Integer> allocator = new PriorityQueue<Integer>(intervals.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });

        // Sort the intervals by start time
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(final int[] a, final int[] b) {
                return a[0] - b[0];
            }
        });

        // Add the first meeting
        allocator.add(intervals[0][1]);

        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // If the room due to free up the earliest is free, assign that room to this meeting.
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }

            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            allocator.add(intervals[i][1]);
        }

        // The size of the heap tells us the minimum rooms required for all the meetings.
        return allocator.size();
    }

    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        List<MeetingRoom> list = new ArrayList<MeetingRoom>();
        for (int[] item : intervals) {
            list.add(new MeetingRoom(item[0], item[1]));
        }
        // 排序
        Collections.sort(list, new Comparator<MeetingRoom>() {
            @Override
            public int compare(MeetingRoom o1, MeetingRoom o2) {
                return o1.start - o2.start;
            }
        });

        // 会议结束之间排序
        PriorityQueue<MeetingRoom> queue = new PriorityQueue<>(new Comparator<MeetingRoom>() {
            @Override
            public int compare(MeetingRoom o1, MeetingRoom o2) {
                return o1.end - o2.end;
            }
        });
        queue.add(list.get(0));
        // 开始处理排序号的会议室
        for (int i = 1; i < list.size(); i++) {
            MeetingRoom item = list.get(i);
            if (item.start >= queue.peek().end) {
                queue.poll();
            }
            queue.add(item);
        }
        return queue.size();
    }
}

class MeetingRoom {
    public int start;
    public int end;

    public MeetingRoom(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
