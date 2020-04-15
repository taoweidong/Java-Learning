package com.offer;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 12.一串只包含字母的字符串(字符串会重复)，每一个字符串代表一种任务，要求，对任务进行排列，其中相同任务指定间隔n,如果没有任务可以排列则置空，求最终排列的任务的最大长度
 * 例如：AAABB  间隔2   任务排列后为：AB_AB_A   最终的长度为7
 * 例如：AAAB  间隔3   任务排列后为：AB_ _A_ _ _A   最终的长度为9
 *
 * @author Taoweidong
 */
public class HuaWeiTest_08 {
    public static void main(String[] args) {
        System.out.println(getTaskLength("AAABBBBB", 2));

    }

    /**
     * 任务重排
     *
     * @param str 任务序列
     * @param n   间隔数
     * @return 重排后任务长度
     */
    public static int getTaskLength(String str, int n) {

        Map<Character, Integer> map = new HashMap<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        //倒叙排序
        PriorityQueue<Character> queue = new PriorityQueue<>((x, y) -> map.get(y) - map.get(x));
        for (Map.Entry<Character, Integer> item : map.entrySet()) {
            queue.add(item.getKey());
        }

        List<String> result = new ArrayList<>();

        //第一个元素
        Character item = queue.poll();
        int count = map.get(item);
        for (int i = 0; i < count; i++) {
            result.add(item.toString());
            for (int j = 0; j < n; j++) {
                result.add("");
            }
        }

        int i = 1;
        while (!queue.isEmpty()) {
            item = queue.poll();
            count = map.get(item);


            for (int j = 0; j < count; j++) {
                result.set(i, item.toString());
                i += 2;
            }
            i += 2;

        }

        System.out.println(JSON.toJSONString(result));


        return 0;
    }
}
