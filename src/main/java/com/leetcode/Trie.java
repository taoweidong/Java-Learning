package com.leetcode;

public class Trie {

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("apple");
    // 返回 True
    System.out.println(trie.search("apple"));
    // 返回 False
    System.out.println(trie.search("app"));
    // 返回 True
    System.out.println(trie.startsWith("app"));
    trie.insert("app");
    // 返回 True
    System.out.println(trie.search("app"));
  }

  /** 指向子节点的指针数组：当前的字符的直接相邻的下个字符的数组 */
  private Trie[] children;
  /** 标记该节点是否为字符串的结尾：判断当前字符是不是某个字符串的结尾 */
  private boolean isEnd;

  public Trie() {
    // 初始化
    children = new Trie[26];
    isEnd = false;
  }

  public void insert(String word) {
    //    获取前缀树
    Trie node = this;

    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);

      // 计算当前字符在前缀树中的索引
      int index = ch - 'a';
      if (node.children[index] == null) {
        // 当前的位置没有Trie,说明该字符没有插入过
        node.children[index] = new Trie();
      }
      // 把当前字符的前缀树作为下个搜索的节点，Trie中的children数组其实就是插入单词
      node = node.children[index];
    }
    // 标记当前这个字符就是某个字符串的结尾
    node.isEnd = true;
  }

  public boolean search(String word) {
    Trie node = searchPrefix(word);

    return node != null && node.isEnd;
  }

  private Trie searchPrefix(String word) {

    Trie node = this;

    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      // 当前字符
      int index = ch - 'a';
      // 如果没有搜索到，说明当前字符后面没有字符了，没有能够完全匹配的前缀，直接返回false
      if (node.children[index] == null) {
        return null;
      }
      node = node.children[index];
    }
    // 这里返回最后字符的前缀树
    return node;
  }

  public boolean startsWith(String prefix) {
    return searchPrefix(prefix) != null;
  }
}
