package com.data.structure;

import java.util.*;

/**
 * 字符串过滤:对于输入字符串检查是否存在非法字符，输出合法字符串(去重)和非法字符串(不去重)
 * abc
 * acv
 * sds
 * sada*(*
 * 3409242
 * 789&*(&(
 * abc
 *
 * @author Taoweidong
 */
public class HuaWei_Test20200403_02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            String str = sc.nextLine().trim();

            //进行逻辑判断
            Set<String> legalStr = new LinkedHashSet<>();
            List<String> noLegalStr = new ArrayList<>();
            while (!"".equals(str)) {

                if (isLegal(str)) {
                    legalStr.add(str);
                } else {
                    noLegalStr.add(str);
                }

                str = sc.nextLine();
            }

            //输出结果
            System.out.println(String.join(" ", legalStr));
            System.out.println(String.join(" ", noLegalStr));


        }
    }

    /**
     * 检查给定字符串是否合法
     *
     * @param str 给定字符串
     * @return True:合法 False:不合法
     */
    private static boolean isLegal(String str) {
        boolean flag = true;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                continue;
            }
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                continue;
            }
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                continue;
            }
            flag = false;
            break;
        }

        return flag;
    }


}
