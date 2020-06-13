package com.huawei;

import java.util.*;

/**
 * 德州扑克:
 * https://blog.csdn.net/nameofcsdn/article/details/70339592
 */
public class Panduanpaixing {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("2 H");
        list.add("3 S");
        list.add("4 S");
        list.add("5 S");
        list.add("6 S");
        System.out.println(getType(list));

    }

    // J 红 , 1 黑 ,J 红 , 1 黑 ,J 红 ,
    public static int getType(ArrayList<String> list) {
        int type = 7;
        //存储数字
        List<Integer> listNumber = new ArrayList<>();
        //存储颜色
        List<String> listColor = new ArrayList<>();

        //用于检查有几个数字不同
        Set<Integer> setNum = new TreeSet<>();
        //用于检查几个数字相同
        Set<String> setColor = new TreeSet<>();  // 颜色相同 一个值
        Map<String, Integer> map = new HashMap<>(); // 数字 数显的频率
        list.stream().forEach(str -> {
            String[] strs = str.split(" ");
            String strNumber = strs[0];
            String strColor = strs[1];
            //统计每个数字出现的个数
            if (map.containsKey(strNumber)) {
                map.put(strNumber, map.get(strNumber) + 1);
            } else {
                map.put(strNumber, 1);
            }
            switch (strNumber) {
                case "J":
                    listNumber.add(11);
                    setNum.add(11);
                    break;
                case "Q":
                    listNumber.add(12);
                    setNum.add(12);
                    break;
                case "K":
                    listNumber.add(13);
                    setNum.add(13);
                    break;
                case "A":
                    listNumber.add(1);
                    setNum.add(1);
                    break;
                default:
                    listNumber.add(Integer.parseInt(strNumber));
                    setNum.add(Integer.parseInt(strNumber));
            }
            listColor.add(strColor);
            setColor.add(strColor);
        });
        // 判断同花 4
        if (setColor.size() == 1) {  //同花
            //判断同花顺 1
            if (setNum.size() == 5) {
                if (isShun(listNumber)) {
                    type = 1; // 同花顺
                }
            } else {
                type = 4; //同花
            }
        }
        // 顺子 5
        if (setColor.size() != 1) {
            if (setNum.size() == 5) {
                if (isShun(listNumber)) {
                    type = 5;
                }
            }
        }
        // 检查是否是：三条6  四条2 葫芦3
        if (setNum.size() == 3) {  // 22 33 1;   333  1 2
            if (map.containsValue(3)) {
                type = 6;
            }
        }
        //检查四条
        if (setNum.size() == 2) {  // 1111 2； 11 333
            if (map.containsValue(3)) {
                type = 3;
            }
            if (map.containsValue(4)) {
                type = 2;
            }
        }
        return type;
    }

    public static boolean isShun(List<Integer> listNumber) { // 顺子
        //排序
        Collections.sort(listNumber);

        boolean isThs = true;
        for (int i = 1; i < 5; i++) {
            if (i != 1) {
                if (listNumber.get(i) - 1 != listNumber.get(i - 1)) {
                    isThs = false;
                    break;
                }
            }
        }
        return isThs;
    }
}
