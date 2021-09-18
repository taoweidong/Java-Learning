package com.huawei;

import java.util.Scanner;

/**
 * 跳跃比赛:判断是否能够跳到最后 2 2 3 6 8 9 2
 *
 * @author Taoweidong
 */
public class HuaWei_Test20200330_01_01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // 输入参数
            String[] input = sc.nextLine().split(" ");
            int[] nums = new int[input.length];
            // 处理输入数据
            for (int i = 0; i < input.length; i++) {
                nums[i] = Integer.valueOf(input[i]);
            }

            int lastPos = nums.length - 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (i + nums[i] >= lastPos) {
                    lastPos = i;
                }
            }

            System.out.println(lastPos == 0);
        }
    }

}
