package com.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 239. 滑动窗口最大值: https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class HelloWorld_239 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] out = new HelloWorld_239().maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(out));

//        Deque<Integer> deq = new ArrayDeque<>();
//        deq.addFirst(10);
//        deq.addLast(5);
//        deq.addLast(9);
//
//        System.out.println(deq.getFirst());
//
//        deq.removeFirst();
//        System.out.println(deq.getFirst());


    }

    /**
     * 暴力解法
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;

        int[] result = new int[n - k + 1];
        if (n * k == 0) {
            return result;
        }

        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            result[i] = max;
        }


        return result;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];


        int n = nums.length;
        //处理一些特殊情形
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }

        //建立双端队列
        Deque<Integer> deq = new ArrayDeque<>();
        //窗口的左边界
        int left;
        int index = 0;
        //初始出
        for (int i = 0; i < nums.length; i++) {
            //窗口的左边界
            left = i - k + 1;
            //队列为空时，直接添加进去
            if (deq.isEmpty()) {
                deq.add(i);
            } else if (left > deq.peekFirst()) {
                //如果左边值已经不在窗口内，则直接删除
                deq.pollFirst();
            }

            //从队尾开始，把比他小的值丢掉，从队尾开始把小数压缩
            while (!deq.isEmpty() && nums[deq.peekLast()] <= nums[i]) {
                deq.pollLast();
            }
            deq.add(i);

            if (left >= 0) {
                result[index++] = nums[deq.peekFirst()];
            }

        }

        return result;
    }
}
