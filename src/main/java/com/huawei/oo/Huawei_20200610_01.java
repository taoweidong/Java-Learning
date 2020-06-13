package com.huawei.oo;

import java.util.*;

/**
 * 坐标轴求面积问题：此代码非正确答案，待调试
 */
public class Huawei_20200610_01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().trim().split(" ");
        int n = Integer.valueOf(input[0]);
        int e = Integer.valueOf(input[1]);
        //开始接受指令
        List<Integer> x = new ArrayList<>();
        Map<Integer, Integer> xMap = new LinkedHashMap<>();
        int ySum = 0;
        for (int i = 0; i < n; i++) {
            String[] temp = sc.nextLine().trim().split(" ");
            ySum += Integer.valueOf(temp[1]);
            xMap.put(Integer.valueOf(temp[0]), ySum);
            x.add(Integer.valueOf(temp[0]));

        }
        xMap.put(e, ySum);
        x.add(e);

        int maxValue = 0;
        for (int i = 1; i < x.size() - 1; i++) {
            int xTemp = xMap.get(x.get(i)) - xMap.get(x.get(i - 1));

            int yTemp = 0;
            for (int j = 0; j < i; j++) {
                yTemp += xMap.get(x.get(j));
            }
            maxValue += (xTemp * yTemp);
        }
        System.out.println(maxValue);
    }
}
