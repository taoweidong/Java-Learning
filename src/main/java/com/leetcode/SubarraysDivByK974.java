package com.leetcode;

import java.util.HashMap;

/**
 * 974. 和可被 K 整除的子数组
 *
 * @author Taoweidong
 */
public class SubarraysDivByK974 {
  public static void main(String[] args) {
    //
  }

  public int subarraysDivByK(int[] A, int K) {
    int count = 0;
    // 前缀和
    int pre = 0;
    // 哈希表记录
    HashMap<Integer, Integer> map = new HashMap<>(K);
    // 初始值，自己就满足的情况
    map.put(0, 1);

    for (int i = 0; i < A.length; i++) {
      pre += A[i];
      // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
      int module = (pre % K + K) % K;

      // sum取模后得到的区间是[-(K-1),(K-1)]，然后我们看到如果为负数的话那是不是数组的下标访问会有问题(当前指针前移)，
      // 这个时候如果加上一个K的话区间就变成了[1,2K-1]它取模不就将所有的下标都保证为正了。
      int same = map.getOrDefault(module, 0);
      count += same;

      // 记录结果
      map.put(module, same + 1);
    }
    return count;
  }
}
