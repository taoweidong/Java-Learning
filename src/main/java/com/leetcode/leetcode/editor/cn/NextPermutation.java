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

package com.leetcode.leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * 下一个排列
 *
 * @author Taoweidong
 */
public class NextPermutation {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        Solution solution = new NextPermutation().new Solution();
        solution.nextPermutation(nums);

        System.out.println(JSON.toJSONString(nums));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
         * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
         * 必须原地修改，只允许使用额外常数空间。
         * <p>
         * 题干的意思是：找出这个数组排序出的所有数中，刚好比当前数大的那个数。
         * <p>
         * 比如当前 nums = [1,2,3]。这个数是123，找出1，2，3这3个数字排序可能的所有数，排序后，比123大的那个数 也就是132
         * <p>
         * 如果当前 nums = [3,2,1]。这就是1，2，3所有排序中最大的那个数，那么就返回1，2，3排序后所有数中最小的那个，也就是1，2，3 -> [1,2,3]
         * <p>
         *
         * @param nums
         */
        public void nextPermutation(int[] nums) {
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) {
                    int j = nums.length - 1;

                    //交換
                    for (; j > i && nums[j] <= nums[i]; j--) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        Arrays.sort(nums, i + 1, nums.length);
                        return;

                    }
                }
            }
            Arrays.sort(nums);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}