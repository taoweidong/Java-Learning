package com.data.structure;

import com.alibaba.fastjson.JSON;

import java.util.*;

/** 队列：先进先出 */
public class QueueDemo {

    public static void main(String[] args) {

        Queue<Integer> list = new LinkedList<>();
        list.add(12);
        list.add(2);
        list.add(8);
        list.add(67);
        list.add(233);

        System.out.println(JSON.toJSONString(list));

        list.poll();
        System.out.println(JSON.toJSONString(list));

        // System.out.println(Collections.min(list));

        System.out.println("***********************");
    }

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;
    }
}
