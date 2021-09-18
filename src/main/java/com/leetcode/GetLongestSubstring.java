package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取最长顺序子串
 *
 * @author taowd
 */
class GetLongestSubstring {

    public static void main(String[] args) {

        String str = "Hello AbcDefg WXyzorld defgh   002";

        System.out.println(searchStr(str));

    }

    /**
     * 获取最长顺序子串.
     *
     * @param inputStr
     *            待处理字符串
     * @return 最长顺序子串
     */
    public static String searchStr(String inputStr) {

        String resultStr = "";

        char[] data = inputStr.toCharArray();

        // 找子串
        for (int i = 0; i < data.length; i++) {
            int index = i;
            List<Character> temp = new ArrayList<>(data.length);
            for (int j = index + 1; j < data.length; j++) {
                if (!temp.contains(data[index])) {
                    temp.add(data[index]);
                }
                if (data[index] + 1 != data[j]) {
                    break;
                } else {
                    index++;

                }
            }

            if (temp.size() > 1) {
                char[] strData = new char[temp.size()];
                for (int x = 0; x < temp.size(); x++) {
                    strData[x] = temp.get(x);
                }

                String tempStr = new String(strData);
                if (resultStr.length() < tempStr.length()) {
                    resultStr = tempStr;
                }
            }
        }

        return resultStr;
    }

}
