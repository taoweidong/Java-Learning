package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/***
 * 974. 和可被 K 整除的子数组
 */
public class LeetCode_974_SubarraysDivByK {
    public static void main(String[] args) {
        int[] A = {4, 5, 0, -2, -3, 1};
        int K = 5;
        System.out.println(new LeetCode_974_SubarraysDivByK().subarraysDivByK(A, K));
    }

    public int subarraysDivByK(int[] A, int K) {
        int len = A.length;
        int result = 0;
        if (Objects.isNull(A) || len == 0) {
            return result;
        }

        // 记录前缀和
        Map<Integer, Integer> preMap = new HashMap<>(len);
        // 初始化集合
        preMap.put(0, 1);

        int preSum = 0;
        for (int i = 0; i < len; i++) {
            preSum += A[i];
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (preSum % K + K) % K;
            // 根据同余定理 (p-q)%K=0 ---> p%K = q%k
            // 此处求的就是以i结尾的前缀和是否与K整除，如果满足就是要求的答案
            result += preMap.getOrDefault(modulus, 0);
            preMap.put(modulus, preMap.getOrDefault(modulus, 0) + 1);
        }

        return result;
    }
}
