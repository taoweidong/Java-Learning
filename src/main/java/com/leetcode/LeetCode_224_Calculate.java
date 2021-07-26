package com.leetcode;

import java.util.Objects;
import java.util.Stack;

/**
 * 224. 基本计算器
 */
public class LeetCode_224_Calculate {
    public static void main(String[] args) {

        System.out.println(Integer.valueOf("+12"));
        System.out.println(Integer.valueOf("- 12"));

        System.out.println(new LeetCode_224_Calculate().calculate(" -2 + +23 "));

        // System.out.println(new LeetCode_224_Calculate().calculate(" 2-1 + 2 "));
        // System.out.println(new LeetCode_224_Calculate().calculate("1+2"));
        // System.out.println(new LeetCode_224_Calculate().calculate("(1+(4+5+2)-3)+(6+8)"));
        // System.out.println(new LeetCode_224_Calculate().calculate("12+23"));
        // System.out.println(new LeetCode_224_Calculate().calculate("(1+2)-12+23-(10-5)"));

    }

    public boolean isNumber(char ch) {
        return ch - '0' >= 0 && ch - '0' <= '9';
    }

    public int calculate(String s) {

        // 输入：s = "(1+(4+5+2)-3)+(6+8)"
        // 输出：23
        // Stack<>
        Stack<String> number = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char item = arr[i];

            if (isNumber(item)) {
                // 如果是数字，就要继续遍历看下一个是不是数字，如果是证明是一个多位数
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(item);
                for (int j = i + 1; j < arr.length; j++) {
                    if (isNumber(arr[j])) {
                        stringBuilder.append(arr[j]);
                        i = j;
                    } else {
                        break;
                    }
                }
                number.push(stringBuilder.toString());

            } else if (item == '+' || item == '-') {
                // 此处需要检查一下是计算符号还是数字的正负号
                // 通过检查，该字符的前一个字符是否为+/-来进行判断
                if (i == 0) {
                    // 如果是数字，就要继续遍历看下一个是不是数字，如果是证明是一个多位数
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(item);
                    for (int j = i + 1; j < arr.length; j++) {
                        if (isNumber(arr[j])) {
                            stringBuilder.append(arr[j]);
                            i = j;
                        } else {
                            break;
                        }
                    }
                    number.push(stringBuilder.toString());
                } else {
                    if (arr[i - 1] == '+' || arr[i - 1] == '-') {

                    }
                }
            }

            if (isNumber(item)) {
                // 如果是数字，就要继续遍历看下一个是不是数字，如果是证明是一个多位数
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(item);
                for (int j = i + 1; j < arr.length; j++) {
                    if (isNumber(arr[j])) {
                        stringBuilder.append(arr[j]);
                        i = j;
                    } else {
                        break;
                    }
                }
                number.push(stringBuilder.toString());

            } else if (item == '(') {
                // 说明是符号，直接记录起来，后面用于计算
                number.push(String.valueOf(item));
            } else if (item == ')') {
                // 遇到右括号，开始进行计算
                String flag = number.peek();
                while (!Objects.equals(flag, "(")) {
                    // 进行计算
                    // 第一个计算数
                    Integer first = Integer.valueOf(number.pop());

                    // 符号
                    String symbol = number.pop();

                    // 第二个计算数
                    Integer sencond = Integer.valueOf(number.pop());

                    // 更新当前栈顶元素
                    flag = number.peek();
                    if (Objects.equals("(", flag)) {
                        number.pop();
                    }

                    number.push(calc(first, symbol, sencond));

                }

            }
        }

        Stack<String> tempStack = new Stack<>();
        while (!number.isEmpty()) {
            tempStack.push(number.pop());
        }

        while (tempStack.size() != 1) {
            // 第一个计算数
            Integer first = Integer.valueOf(tempStack.pop());

            // 符号
            String symbol = tempStack.pop();

            // 第二个计算数
            Integer sencond = Integer.valueOf(tempStack.pop());
            if (Objects.equals(symbol, "+")) {
                tempStack.push(String.valueOf(first + sencond));
            } else {
                tempStack.push(String.valueOf(first - sencond));
            }
        }

        return Integer.valueOf(tempStack.pop());
    }

    private String calc(int first, String symbol, int sencond) {

        if (Objects.equals(symbol, "+")) {
            int result = first + sencond;
            return String.valueOf(result);
        } else {
            int result = sencond - first;
            return String.valueOf(result);
        }
    }
}
