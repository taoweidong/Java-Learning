package com.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 变量替换
 * 4
 * xxx=aaa/mm${ttt}/hello
 * yyy=World
 * ttt=MyHello
 * aaa=java/${xxx}/${yyy}/uuu/ooo
 *
 * @author Taoweidong
 */
public class HuaWei_Test20200401_01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //赋值语句行数
            int count = Integer.valueOf(sc.nextLine());
            String result = "";

            Map<String, String> map = new HashMap<>(count);
            for (int i = 0; i < count; i++) {
                String[] arr = sc.nextLine().split("=");
                if (i == count - 1) {
                    result = arr[1];
                } else {
                    map.put(arr[0], arr[1]);
                }
            }

            while (result.contains("$")) {
                result = replaceStr(map, result);
            }

            System.out.println(result);

        }
    }

    private static String replaceStr(Map<String, String> map, String result) {

        String[] arr = result.split("/");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].contains("$")) {

                String key = arr[i].substring(arr[i].indexOf("$") + 2, arr[i].indexOf("}"));
                arr[i] = arr[i].substring(0, arr[i].indexOf("$")) + map.get(key) + arr[i]
                        .substring(arr[i].indexOf("}") + 1);
            }
        }

        return String.join("/", arr);
    }

}
