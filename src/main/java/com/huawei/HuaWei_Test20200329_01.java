package com.huawei;

import java.util.Scanner;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 * Related Topics 字符串 动态规划
 *
 * @author Taoweidong
 */
public class HuaWei_Test20200329_01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //输入参数
            String input = sc.nextLine();

            if (input == null || input.length() == 1) {
                System.out.println("");
            }

            String result = "";
            for (int i = 0; i < input.length(); i++) {
                //以i为中心的最长回文子串
                String str = palindrome(input, i, i);
                //以i和i+1为中心的最长回文子串
                String str2 = palindrome(input, i, i + 1);

                result = result.length() > str.length() ? result : str;
                result = result.length() > str2.length() ? result : str2;

            }

            //输出结果
            System.out.println(result);
        }
    }

    /**
     * 判断是否为回文子串
     *
     * @param str   待判断的字符串
     * @param left  中心左边
     * @param right 中心右边
     * @return 回文串
     */
    public static String palindrome(String str, int left, int right) {

        //中心扩散法
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            //如果中心两边的字符相同，则进行位置移动，继续检查下一位
            left--;
            right++;
        }


        return str.substring(left + 1, right);
    }
}
