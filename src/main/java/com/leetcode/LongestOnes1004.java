package com.leetcode;

/**
 * 1004. 最大连续1的个数 III:https://leetcode-cn.com/problems/max-consecutive-ones-iii/
 *
 * @author Taoweidong
 */
public class LongestOnes1004 {
  public static void main(String[] args) {
    //
  }

  public int longestOnes(int[] A, int K) {

    int left = 0;
    int right = 0;

    int zeroCount = 0;
    int result = 0;
    while (right < A.length) {
      if (A[right] == 0) {
        zeroCount++;
      }

      while (zeroCount > K) {
        if (A[left] == 0) {
          zeroCount--;
        }
        left++;
      }
      result = Math.max(result, right - left + 1);
      right++;
    }

    return result;
  }
}
