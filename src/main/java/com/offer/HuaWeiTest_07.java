package com.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 *
 * @author Taoweidong
 */
public class HuaWeiTest_07 {
    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));

    }

    /**
     * 罗马数字转整数
     *
     * @param str
     *            罗马数字
     * @return 整数
     */
    public static int romanToInt(String str) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int count = 0;
        for (int i = 0; i < str.length();) {
            if (i + 1 < str.length() && map.containsKey(str.substring(i, i + 2))) {
                count += map.get(str.substring(i, i + 2));
                i += 2;
            } else if (map.containsKey(str.substring(i, i + 1))) {
                count += map.get(str.substring(i, i + 1));
                i += 1;
            } else {
                // 不合法的字符串
                return -1;
            }
        }

        return count;
    }
}
