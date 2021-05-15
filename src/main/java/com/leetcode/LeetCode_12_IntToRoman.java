package com.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LeetCode_12_IntToRoman {
  public static void main(String[] args) {

    System.out.println(String.join("", Collections.nCopies(3, "H")));
    System.out.println(new LeetCode_12_IntToRoman().intToRoman(2334));
  }

  public String intToRoman(int num) {
    Map<Integer, String> hashMap = new LinkedHashMap<>(num);
    hashMap.put(1000, "M");
    hashMap.put(900, "CM");
    hashMap.put(500, "D");
    hashMap.put(400, "CD");
    hashMap.put(100, "C");
    hashMap.put(90, "XC");
    hashMap.put(50, "L");
    hashMap.put(40, "XL");
    hashMap.put(10, "X");
    hashMap.put(9, "IX");
    hashMap.put(5, "V");
    hashMap.put(4, "IV");
    hashMap.put(1, "I");

    String result = "";
    for (Map.Entry<Integer, String> item : hashMap.entrySet()) {
      if (num / item.getKey() != 0) {
        int count = num / item.getKey();
        result += String.join("", Collections.nCopies(count, item.getValue()));
        num %= item.getKey();
      }
    }
    return result;
  }
}
