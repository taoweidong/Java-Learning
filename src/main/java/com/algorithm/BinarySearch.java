package com.algorithm;

public class BinarySearch {
  public static void main(String[] args) {
    int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int target = 4;
    System.out.println(binarySearch(number, target));
  }

  public static int binarySearch(int[] number, int target) {
    int left = 0;
    int right = number.length - 1;

    while (left <= right) {
      // 注意：使用下面这种方式可以解决溢出的问题
      int mid = left + (right - left) / 2;
      if (number[mid] == target) {
        return mid;
      } else if (number[mid] < target) {
        left = mid + 1;
      } else if (number[mid] > target) {
        right = mid - 1;
      }
    }
    return -1;
  }

  public int mySqrt(int x) {
    if (x < 2) {
      return x;
    }
    int left = 1;
    int right = x / 2 + 1;

    while (left <= right) {
      long mid = left + (right - left) / 2;
      if (mid * mid > x) {
        right = (int) (mid - 1);
      } else if (mid * mid < x) {
        left = (int) (mid + 1);
      } else {
        return (int) mid;
      }
    }
    return right;
  }
}
