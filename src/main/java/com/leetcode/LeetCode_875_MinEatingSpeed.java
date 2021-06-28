package com.leetcode;

public class LeetCode_875_MinEatingSpeed {
  public static void main(String[] args) {
    //        int[] piles = {3, 6, 7, 11};
    //        int H = 8;

    //    int[] piles = {30, 11, 23, 4, 20};
    //    int H = 5;

    int[] piles = {30, 11, 23, 4, 20};
    int H = 6;
    System.out.println(new LeetCode_875_MinEatingSpeed().minEatingSpeed(piles, H));
  }

  public int minEatingSpeed(int[] piles, int h) {

    int left = 1;
    // 计算出最大速度
    int right = 0;
    for (int pile : piles) {
      right = Math.max(right, pile);
    }
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (calculation(piles, mid) > h) {
        left = mid + 1;
      } else {
        //  right = mid - 1：   如果此处减1，可能会导致最终结果取的是实际结果的减1的值
        right = mid;
      }
    }

    return left;
  }

  private int calculation(int[] piles, int min) {
    int countSum = 0;
    for (int pile : piles) {
      countSum += (pile + min - 1) / min;
    }
    return countSum;
  }
}
