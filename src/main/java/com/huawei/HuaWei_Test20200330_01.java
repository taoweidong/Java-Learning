package com.huawei;

import java.util.Scanner;

/**
 * 跳跃比赛
 * 2 2 3 6 8 9
 * 2
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
