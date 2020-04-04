package com.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 给出一个仅包含字母的字符串，不包含空格，统计字符串中各个字母出现的次数，并按照字母出现的次数从大到小
 * 的顺序输出各个字母及其出现的次数信息，如果次数相同，按照自然顺序进行排序
 *
 * @author Taoweidong
 */
public class HuaWei_Test20200328_04 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //输入参数
            String str = sc.nextLine();

            //统计字符出现的个数
            Map<Character, Integer> map = new HashMap<>(str.length());
            for (Character item : str.toCharArray()) {
                map.put(item, map.getOrDefault(item, 0) + 1);
            }

            //进行降序排列
            PriorityQueue<Character> queue = new PriorityQueue<>((x, y) -> map.get(y) - map.get(x));
            for (Character item : map.keySet()) {
                queue.add(item);
            }

            //输出结果
            while (!queue.isEmpty()) {
                Character ch = queue.poll();
                System.out.print(ch + " " + map.get(ch) + "\n");
            }

        }
    }
}
