// 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
// 。假定每组输入只存在唯一答案。
//
// 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
//
// 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
//
// Related Topics 数组 双指针

package com.leetcode.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 最接近的三数之和
 *
 * @author Taoweidong
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            // 排序
            Arrays.sort(nums);

            // 记录初始结果
            int result = nums[0] + nums[1] + nums[2];

            for (int i = 0; i < nums.length; i++) {

                int start = i + 1;
                int end = nums.length - 1;

                while (start < end) {
                    // 临时变量
                    int temp = nums[start] + nums[end] + nums[i];
                    // 判断距离
                    if (Math.abs(target - temp) < Math.abs(target - result)) {
                        result = temp;
                    }

                    // 调整位置
                    if (temp > target) {
                        end--;
                    } else if (temp < target) {
                        start++;
                    } else {
                        return result;
                    }
                }
            }
            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}