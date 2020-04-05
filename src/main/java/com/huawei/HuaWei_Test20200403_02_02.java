package com.huawei;

import java.util.*;
import java.util.regex.Pattern;

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
public class HuaWei_Test20200403_02_02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            String str = sc.nextLine().trim();

            //进行逻辑判断
            Set<String> legalStr = new LinkedHashSet<>();
            List<String> noLegalStr = new ArrayList<>();
            while (!"".equals(str)) {
                //检查字符串是否合法
                if (Pattern.matches("[a-zA-Z0-9]+", str)) {
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
}
