package com.leetcode;

public class LeetCode_168_ConvertToTitle {
  public static void main(String[] args) {
    System.out.println(new LeetCode_168_ConvertToTitle().convertToTitle(1));
    System.out.println(new LeetCode_168_ConvertToTitle().convertToTitle(28));
    System.out.println(new LeetCode_168_ConvertToTitle().convertToTitle(701));
    System.out.println(new LeetCode_168_ConvertToTitle().convertToTitle(2147483647));
  }

  public String convertToTitle(int columnNumber) {
    StringBuilder str = new StringBuilder();
    while (columnNumber > 0) {
      columnNumber--;
      str.append((char) (columnNumber % 26 + 'A'));
      //      取剩下的数字
      columnNumber /= 26;
    }
    str.reverse();

    return str.toString();
  }
}
