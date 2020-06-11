package com.huawei.oo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hello2 {
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
