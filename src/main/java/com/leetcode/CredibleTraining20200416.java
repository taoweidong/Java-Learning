package com.leetcode;

/**
 * 可信训练-元音字母转换的问题
 * https://www.cnblogs.com/mist2019/p/10325920.html
 *
 * @author Taoweidong
 */
public class CredibleTraining20200416 {

    public static void main(String[] args) {
        System.out.println(vowelToUpperCase("Who Love Solo"));
    }


    /**
     * 元音字母转大写
     *
     * @param str
     * @return
     */
    public static String vowelToUpperCase(String str) {

        StringBuilder out = new StringBuilder(str.length());

        for (char c : str.toCharArray()) {
            if (isVowel(c)) {
                out.append(String.valueOf(c).toUpperCase());
            } else {
                out.append(String.valueOf(c).toLowerCase());
            }
        }
        return out.toString();
    }

    /**
     * 判断给定字符是否是元音字符
     *
     * @param c 待判断字符
     * @return True:元音字符  False:非元音字符
     */
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
