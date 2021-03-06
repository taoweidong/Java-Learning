package com.huawei;

import java.util.Scanner;

/**
 * 跳跃比赛
 * 2 2 3 6 8 9
 * 2
 * https://leetcode-cn.com/problems/jump-game-ii/solution/hui-su-dp-yi-ji-tan-xin-jie-fa-by-liuchuan1992/
 * 贪心算法解决：贪心的思路在于每次确定一个层级或者上下界。然后根据上下界确定下一个循环的范围，这里要注意的是可能会存在跳不过去的场景，虽然题目没有说，
 * 我们假设如果最终不能跳到最后一个位置，则返回-1 (1,0,0,0,4) -> -1
 *
 * @author Taoweidong
 */
public class HuaWei_Test20200330_01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //输入参数
            String[] input = sc.nextLine().split(" ");
            int[] arr = new int[input.length];
            //处理输入数据
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.valueOf(input[i]);
            }

            //标识结束为止
            int end = 0;
            //标识最大长度
            int maxLength = 0;
            //标识走的步数，也就是最终输出的结果
            int step = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                maxLength = Math.max(maxLength, i + arr[i]);
                if (i == end) {
                    end = maxLength;
                    step++;
                }
            }
            System.out.println(step);
        }
    }

}
