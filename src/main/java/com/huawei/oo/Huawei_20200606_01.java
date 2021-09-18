package com.huawei.oo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * # 【集五福】 > 集五福作为近年来大家喜闻乐见迎新春活动，集合爱国福，富强福，和谐福，敬业福，友善福，即可分享超大红包。
 * 以0和1组成的长度为5的字符串代表每个人所得到的福卡，每一位代表一种福卡，1表示已经获得该福卡，单类型福卡不超过1张，随机抽取一个不超过10人团队，求该团队最多可以集齐多少套五福。
 * <p>
 * >https://blog.csdn.net/JiandongHan/article/details/81259106
 * <p>
 * - 输入描述: 输入类似11010，00110，由0，1组成的长度为5的字符串，代表指定团队中每个人福卡获得情况。 注意1:1人也可以是一个团队； 注意2:多人之间的福卡以英文逗号隔开。 - 输出描述: 输出该团队能凑齐多少套五福。
 * <p>
 * - 示例1: 输入: 11001,11110,11001,11110 输出: 0
 */
public class Huawei_20200606_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String[] split = input.split(",");
            // 用来统计最终福卡的个数
            int[] counts = new int[] {0, 0, 0, 0, 0};

            // 注意点1： 随机抽取一个不超过10人团队，也就是最多只有9个人(具体考试时进行测试)
            // 思路：将每个人的福卡对应的位置添加，最终进行排序，排序后最大的也就是能收集到的最多的福卡

            for (int i = 0; i < split.length; i++) {
                char[] ticket = split[i].toCharArray();
                for (int j = 0; j < ticket.length; j++) {
                    if (ticket[j] == '1') {
                        counts[j]++;
                    }
                }
            }
            Arrays.sort(counts);
            System.out.println(counts[0]);
        }
    }

}
