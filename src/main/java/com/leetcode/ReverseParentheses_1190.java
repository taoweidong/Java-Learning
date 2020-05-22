package com.leetcode;

import java.util.Stack;

/**
 * 1190. 反转每对括号间的子串
 *
 * @author Taoweidong
 */
public class ReverseParentheses_1190 {
    public String reverseParentheses(String s) {

        //接受结果
        Stack<String> stack = new Stack<>();

        for (Character item : s.toCharArray()) {
            if (item == '(') {
                stack.push("");
            } else if (item == ')') {

            }
        }

        return "";
    }
}
