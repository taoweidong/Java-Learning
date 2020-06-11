package com.offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 寻找给定字符串中的最长元音子串
 */
public class Hello001 {
    //    asdbuiodevauufgh
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();

        //元音字符串
        String a = "aeiouAEIOU";
        int count = 0;
        int temp = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (a.contains(c + "")) {
                temp += 1;
            } else {
                count = Math.max(count, temp);
                temp = 0;
            }
        }
        count = Math.max(count, temp);
        System.out.println(count);
    }
}