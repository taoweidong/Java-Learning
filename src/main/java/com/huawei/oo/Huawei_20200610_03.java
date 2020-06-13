package com.huawei.oo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 给定字符串(包含大写字符，小写字符，数字，符号)用-相连，按照规则生成一个新串，并输出
 * 规则1：第一个-之前的字符串不变，后面的字符串按照给定数字n进行截取，每n个字符，组成一个新子串，将新子串用-相连
 * 规则2：如果截取的子串中，大写字符的个数>小写字符的个数，则将小写字符转换为大写
 * 规则3：如果截取的子串中，大写字符的个数<小写字符的个数，则将大写字符转换为小写
 * 规则4：如果截取的子串中，大写字符的个数=小写字符的个数，不变
 * <p>
 * 该答案已经验证 OK
 */
public class Huawei_20200610_03 {
    //12abc-abCABc-4aB@
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine().trim());
        String input = sc.nextLine().trim();

        if (!input.contains("-")) {
            System.out.println(input);
            return;
        }

        //取出首个子串
        String first = input.substring(0, input.indexOf("-"));
        //取出后面所有的字符串
        String endStr = input.substring(input.indexOf("-")).replace("-", "");

        List<String> result = new ArrayList<>();
        result.add(first);
        while (endStr.length() != 0) {
            String temp = endStr;
            if (endStr.length() >= n) {
                temp = endStr.substring(0, n);
            }

            int upperCount = 0;
            int lowerCount = 0;
            for (char item : temp.toCharArray()) {
                if ('A' <= item && item <= 'Z') {
                    upperCount++;
                }
                if ('a' <= item && item <= 'z') {
                    lowerCount++;
                }
            }

            if (upperCount > lowerCount) {
                temp = temp.toUpperCase();
            } else if (upperCount < lowerCount) {
                temp = temp.toLowerCase();
            }

            result.add(temp);
            if (endStr.length() > n) {
                endStr = endStr.substring(n);
            } else {
                break;
            }
        }

        System.out.println(String.join("-", result));
    }
}
