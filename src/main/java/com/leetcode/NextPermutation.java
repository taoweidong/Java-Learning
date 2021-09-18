// 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
// 必须原地修改，只允许使用额外常数空间。
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
// 1,2,3 → 1,3,2
// 3,2,1 → 1,2,3
// 1,1,5 → 1,5,1
// Related Topics 数组

package com.leetcode;

import java.util.Arrays;

/**
 * 下一个排列
 *
 * @author Taoweidong
 */
public class NextPermutation {

    public static void main(String[] args) {

        Solution solution = new NextPermutation().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void nextPermutation(int[] nums) {

            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) {
                    int j = nums.length - 1;
                    for (; j > i && nums[j] <= nums[i]; j--) {
                        // 找到下一个更大的排列而不是任意更大排列
                    }
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    Arrays.sort(nums, i + 1, nums.length);
                    return;
                }
            }

            Arrays.sort(nums);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
