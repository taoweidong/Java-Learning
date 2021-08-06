package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 402. 移掉 K 位数字
 */
public class LeetCode_402_RemoveKdigits {
    public static void main(String[] args) {

        // String num = "1432219";
        // int k = 3;

        // String num = "0200";
        // int k = 1;

        // String num = "10";
        // int k = 2;

        // String num = "123456789";
        // int k = 4;

        // String num = "212342";
        // int k = 6;

        String num = "10200";
        int k = 1;
        String result = new LeetCode_402_RemoveKdigits().removeKdigits(num, k);
        System.out.println(result);

    }

    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            char current = num.charAt(i);
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > current) {
                stack.pollLast();
                k -= 1;
            }
            stack.offerLast(current);
        }

        for (int i = 0; i < k; i++) {
            stack.pollLast();
        }

        StringBuilder result = new StringBuilder();
        boolean flag = true;
        while (!stack.isEmpty()) {
            char c = stack.pollFirst();
            if (flag && c == '0') {
                continue;
            }
            flag = false;
            result.append(c);
        }

        return result.length() == 0 ? "0" : result.toString();
    }
}
