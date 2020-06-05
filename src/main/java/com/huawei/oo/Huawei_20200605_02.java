package com.huawei.oo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * # 【最大N个数和最小N个数的和】
 * > 给定一个数组，编写一个函数来计算它的最大N个数和最小N个数的和，你需要对数组去重。
 * 说明:
 * 数组中数字范围[0，1000];
 * 最大N个数和最小N个数不能重叠，如果有重叠，输入非法返回-1;
 * 输入非法返回-1；
 * <p>
 * - 输入描述:
 * 第一行输入M,M标识数组大小；
 * 第二行输入M个数，见识数组内容；
 * 第三行输入N,N表达需要计算的最大、最
 * 小N个数。
 * - 输出描述:
 * 输出最大N个数与最小N个数的和。
 * <p>
 * - 示例:
 * 5
 * 95 88 83 64 100
 * 2
 * - 输出:
 * 342
 */
public class Huawei_20200605_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = Integer.valueOf(sc.nextLine().trim());
            String[] input = sc.nextLine().trim().split(" ");
            List<Integer> arr = new ArrayList<>(m);
            for (int i = 0; i < input.length; i++) {
                arr.add(Integer.valueOf(input[i]));
            }
            int n = Integer.valueOf(sc.nextLine().trim());

            //排序
            Collections.sort(arr);

            //检查是否有重叠
            if (arr.size() - n < n) {
                System.out.println(-1);
                return;
            }

            // 计算最大N个数和最小N个数的和
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += arr.get(i);
                count += arr.get(arr.size() - 1 - i);

            }
            System.out.println(count);

        }
    }


}


