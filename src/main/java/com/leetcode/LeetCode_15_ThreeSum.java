package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_15_ThreeSum {
  public static void main(String[] args) {
    //
  }

  public List<List<Integer>> threeSum(int[] nums) {
    // 存放最终结果
    List<List<Integer>> result = new ArrayList<>(nums.length);
    // 基本排序
    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        return result;
      }
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      // 使用双指针解法
      int left = i + 1;
      int right = nums.length - 1;

      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == 0) {
          List<Integer> list = new ArrayList<>();
          list.add(nums[i]);
          list.add(nums[left]);
          list.add(nums[right]);
          result.add(list);

          while (left < right && nums[left] == nums[left + 1]) {
            // 跳过重复元素
            left++;
          }
          while (left < right && nums[right] == nums[right - 1]) {
            // 跳过重复元素
            right--;
          }

          left++;
          right--;
        } else if (sum < 0) {
          left++;
        } else {
          right--;
        }
      }
    }

    return result;
  }
}
