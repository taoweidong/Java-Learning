package com.basic.grammar;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 集合测试
 * 
 * @author Taoweidong
 */
public class Collection_Test {

  public static void main(String[] args) {
    Set<Integer> set = new HashSet<>();
    set.add(10);
    set.add(50);
    set.add(50);
    set.add(190);
    set.add(4);
    set.add(null);

    // HashSet 是无序的，即插入和遍历的顺序不一致
    for (Integer item : set) {
      System.out.println(item);
    }

    System.out.println("**************************");

    set = new LinkedHashSet<>();
    set.add(10);
    set.add(50);
    set.add(190);
    set.add(190);
    set.add(4);
    set.add(null);
    // LinkedHashSet 是有序的，即插入和遍历的顺序一致
    // 哈希表保证数据唯一性，链表保证数据的有序
    for (Integer item : set) {
      System.out.println(item);
    }

    System.out.println("**************************");


    set = new TreeSet<>();
    set.add(10);
    set.add(50);
    set.add(190);
    set.add(190);
    set.add(4);
    // set.add(null);
    // TreeSet 底层数据结构是二叉树 可自定义排序
    for (Integer item : set) {
      System.out.println(item);
    }

    System.out.println("**************************");

  }

}
