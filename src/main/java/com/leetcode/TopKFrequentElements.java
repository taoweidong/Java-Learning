// 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//
// 示例 1:
//
// 输入: nums = [1,1,1,2,2,3], k = 2
// 输出: [1,2]
//
//
// 示例 2:
//
// 输入: nums = [1], k = 1
// 输出: [1]
//
// 说明：
//
//
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
//
// Related Topics 堆 哈希表

package com.leetcode;

import java.util.*;

/**
 * 前 K 个高频元素
 * 
 * @author Taoweidong
 */
public class TopKFrequentElements {

    public static void main(String[] args) {

        Solution solution = new TopKFrequentElements().new Solution();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        List<Integer> result = solution.topKFrequent(nums, k);
        System.out.println(result);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> topKFrequent(int[] nums, int k) {

            // 统计个数
            Map<Integer, Integer> map = new HashMap<>();
            for (int item : nums) {
                map.put(item, map.getOrDefault(item, 0) + 1);
            }

            // 排序：使用堆排序 PriorityQueue：为堆的数据结构
            // 默认升序队列
            PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> map.get(n2) - map.get(n1));
            for (Integer item : map.keySet()) {
                // 如果堆中的小于题目要求的前k个数据，则直接添加
                if (heap.size() < k) {
                    heap.add(item);
                } else {
                    // 如果堆中的数据已经大于题目要求的前k个数据，则需要判断和当前
                    if (map.get(item) > map.get(heap.peek())) {
                        // 删除堆中的数据
                        heap.remove();
                        // 把新数据添加进去
                        heap.add(item);
                    }
                }
            }

            // 输出结果
            List<Integer> result = new ArrayList<>();
            while (!heap.isEmpty()) {
                result.add(heap.poll());
            }

            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}