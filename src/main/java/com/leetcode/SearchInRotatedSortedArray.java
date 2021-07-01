//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找

package com.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 搜索旋转排序数组
 * @author Taoweidong
 */
public class SearchInRotatedSortedArray {

	public static int[] stringToIntegerArray(String input) {

		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return new int[0];
		}

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for (int index = 0; index < parts.length; index++) {
			String part = parts[index].trim();
			output[index] = Integer.parseInt(part);
		}
		return output;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			int[] nums = stringToIntegerArray(line);
			line = in.readLine();
			int target = Integer.parseInt(line);

			int ret = new Solution().search(nums, target);

			String out = String.valueOf(ret);

			System.out.print(out);
		}
	}
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	public int search(int[] nums, int target) {

		//排除特殊情况
		if (nums.length == 0) {
			return -1;
		}
		if (nums.length == 1) {
			if (nums[0] == target) {
				return 0;
			} else {
				return -1;
			}
		}

		//先找到旋转点
		int rotation_point = getRotationPoint(nums);

		//根据旋转点判断target在旋转点左边还是右边：采用旋转点进行分割后两边的序列值均是有序的，所以可以采用二分查找法进行下一步操作
		if (nums[rotation_point] == target) {
			return rotation_point;
		}

		//使用二分查找法，检查target是否在指定的区间内
		//没有经过旋转
		if (rotation_point == 0) {
			return search(nums, 0, nums.length - 1, target);
		}
		if (nums[0] > target) {
			return search(nums, rotation_point, nums.length - 1, target);
		} else {
			return search(nums, 0, rotation_point, target);
		}
	}

	/**
	 * 二分查找最终结果
	 */
	public int search(int[] nums, int left, int right, int target) {

		while (left <= right) {
			int center = (left + right) / 2;
			if (nums[center] == target) {
				return center;
			} else {
				if (target < nums[center]) {
					right = center - 1;
				} else {
					left = center + 1;
				}
			}
		}
		return -1;

	}

	/**
	 * 获取旋转数组的旋转点
	 */
	public int getRotationPoint(int[] nums) {

		int left = 0;
		int right = nums.length - 1;

		if (nums[left] < nums[right]) {
			return 0;
		}

		while (left <= right) {
			int center = (left + right) / 2;
			if (nums[center] > nums[center + 1]) {
				return center + 1;
			} else {
				if (nums[center] < nums[left]) {
					right = center - 1;
				} else {
					left = center + 1;
				}
			}
		}
		return 0;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

