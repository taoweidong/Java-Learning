package com.huawei.oo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 按索引范围翻转文章片断， 辅入一个英文文章片段，翻转
 * 指定区间的单词顺序，标点符号和普通字母一样处理，
 * 副如输入守符串＂1 am a developer, ", 区间[0, 3] ,
 * 刚输仙 "developer a am 1"
 * Stimg reverse words (string s,int start,int end)
 * 输人描述：使用换行隔开三个参数，第一个参数的为英文文章风内容，即英文字符串，第二个下标未翻转起始单饲下标。
 * （下栋从0开始）， 第三个参数为结束单词下标，
 * 输出：
 * 翻转后的的英文文章片段所有单词之间以一个半角空格分隔输出
 * <p>
 * 输入
 * 1 am a developer.
 * 1
 * 2
 * 输出
 * 1 a am developer.
 */
public class Huawei_20200603_04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] arr = sc.nextLine().trim().split(" ");
            List<String> list = Arrays.asList(arr);

            int left = Integer.valueOf(sc.nextLine().trim());
            int right = Integer.valueOf(sc.nextLine().trim());

            while (left < right) {
                Collections.swap(list, left, right);
                left++;
                right--;
            }

            System.out.println(list);

        }


    }


}
