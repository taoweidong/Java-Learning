package com.huawei.oo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * 最大括号深度：
 * > 现有一字符串仅有'('，')'，'{'，'}'，'[',']'六种括号组成。
 * 若字符串满足以下条件之一，则视为无效字符串：
 * 1、任意类型的左右括号数量不相等。
 * 2、存在未按正确顺序（先左后右）闭合的括号。
 * 输出括号的最大嵌套深度，若字符串无效，输出0。0=<字符串长度<=100000。
 * <p>
 * - 输入描述：
 * 一个只包含'('，')'，'{'，'}'，'[',']'字符串。
 * - 输出描述：
 * 一个整数，最大的括号深度
 * <p>  ()(({[]})){[]}  -- 3
 * - 示例1：
 * 输入
 * []
 * 输出
 * 1
 */
public class Huawei_20200603_03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //字符映射表
            Map<Character, Character> map = new HashMap(3);
            map.put('(', ')');
            map.put('[', ']');
            map.put('{', '}');
            //输入数据处理
            String str = sc.nextLine();

            //如果为空或者为奇数个，则为非法字符串
            if ("".equals(str.trim()) || str.length() % 2 != 0) {
                System.out.println(0);
                return;
            }

            //记录字符
            Stack<Character> stackChar = new Stack<>();

            //最长有效括号子串的长度 ()(){}[]
            int maxLength = 0;
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if ('(' == str.charAt(i) || '[' == str.charAt(i) || '{' == str.charAt(i)) {
                    stackChar.add(str.charAt(i));
                    maxLength = Math.max(maxLength, count);
                    count = 0;
                } else {
                    if (!stackChar.isEmpty()) {
                        if (map.get(stackChar.peek()).equals(str.charAt(i))) {
                            //出栈
                            stackChar.pop();
                            count++;

                        } else {
                            System.out.println(0);
                            return;
                        }
                    } else {
                        System.out.println(0);
                        return;
                    }

                }
            }

            //检查字符串是否有效
            if (!stackChar.isEmpty()) {
                System.out.println(0);
                return;
            }

            maxLength = Math.max(maxLength, count);
            System.out.println(maxLength);

        }


    }


}
