package com.nowcoder;

import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName HashMapCountChar
 * @Description 给定一个字符串，获取字符串中每个字符出现的次数
 * @Author Taowd
 * @Version V1.0
 */
public class HashMapCountChar {

    public static void main(String[] args) {
        // 定义字符串
        String strTemp = "abdkbcaajjj99*^*LLLLLLLa";
        // 定义集合:按照ASCII码进行默认排序
        Map<Character, Integer> map = new TreeMap<Character, Integer>();
        // 开始处理
        char[] chTemp = strTemp.toCharArray();

        Character item;
        for (int i = 0; i < strTemp.length(); i++) {
            item = strTemp.charAt(i);
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        // 遍历集合
        for (Map.Entry<Character, Integer> me : map.entrySet()) {
            System.out.println(me.getKey() + "--" + me.getValue());
        }

    }
}
