package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列: https://leetcode-cn.com/problems/permutations/
 * 
 */
public class LeetCode_46_Permute {
    public static void main(String[] args) {

    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        permuteAll(nums, new LinkedList<Integer>());
        return result;
    }

    private void permuteAll(int[] nums, LinkedList<Integer> list) {
        if (nums.length == list.size()) {
            // 收集结果，回溯结束
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 检查是否已经添加过了
            if (list.contains(nums[i])) {
                continue;
            }
            // 添加结果
            list.add(nums[i]);
            permuteAll(nums, list);
            list.removeLast();
        }
    }
}
