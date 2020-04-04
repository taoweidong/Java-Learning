package com.huawei;

import java.util.Scanner;

/**
 * 寻找最长连续子串
 * 给定一串字符，里面有些字符有连续出现的特点，请寻找这些连续出现字符中最长的串，
 * 如果最长的串有多个，请输出字符ASCII码最小的那一串
 * 输入1：asdkljadjUUUUUUUUUU
 * 输出1：UUUUUUUUUU
 * 输入2：aaaahjdshdjshjcccc
 * 输出2：aaaa
 *
 * @author Taoweidong
 */
public class HuaWei_Test20200329_03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //输入参数
            String str = sc.nextLine();
            char[] chars = str.toCharArray();

            int start = 0;
            int maxLength = 0;

            for (int i = 0, j = 0; j < chars.length; j++) {
                if (j == 0) {
                    maxLength = 0;
                    continue;
                }

                if (chars[j] != chars[j - 1]) {
                    //如果新的连续字符串长度比原来的长，那么就更新起始位置和长度
                    if (maxLength < j - i) {
                        maxLength = j - i;
                        start = i;
                    }
                    //如果长度相同，则输出ASCII码较小的一串
                    if (maxLength == j - i && chars[start] > chars[j - 1]) {
                        start = i;
                    }
                    //更新索引位置，开始新的连续字符串的比较
                    i = j;
                }

                if (j == chars.length - 1) {
                    if (maxLength < j - i + 1) {
                        maxLength = j - i + 1;
                        start = i;
                    }
                    if (maxLength == j - i + 1 && chars[start] > chars[j - 1]) {
                        start = i;
                    }
                    //最后一个位置了，不需要再更新索引位置了
                }
            }
            System.out.println(str.substring(start, start + maxLength));

        }
    }

}
