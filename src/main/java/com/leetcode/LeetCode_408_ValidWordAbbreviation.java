package com.leetcode;

public class LeetCode_408_ValidWordAbbreviation {

    public static void main(String[] args) {
        System.out
            .println(new LeetCode_408_ValidWordAbbreviation().validWordAbbreviation("internationalization", "i12iz4n"));

        System.out.println(new LeetCode_408_ValidWordAbbreviation().validWordAbbreviation("apple", "a2e"));
    }

    public boolean validWordAbbreviation(String word, String abbr) {
        char[] chars = abbr.toCharArray();
        // 缩写中的数字，不能出现0
        int num = 0;
        int next = 0;
        for (char c : chars) {
            // 如果是数字则拼接成最后的样子
            if (c >= '0' && c <= '9') {
                if (num == 0 && c == '0') {
                    return false;
                }
                num = num * 10 + (c - '0');
                continue;
            }
            // 更新指针
            next = next + num;
            // 如果next 超过了word的长度，则说明不是word的缩写
            // 如果word和abbr在next位置的字符不一致，则说明不是word的缩写
            if (next >= word.length() || word.charAt(next) != c) {
                return false;
            }
            next++;
            num = 0;
        }
        return next + num == word.length();
    }
}
