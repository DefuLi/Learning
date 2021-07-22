package leetcode;

import java.util.*;

// 实现 Trie (前缀树)
public class Trie {

    public static void main(String[] args) {

        Trie obj = new Trie();
        obj.insert("apple");
        System.out.println(obj.search("apple"));  // true
        System.out.println(obj.search("app"));  // false
        System.out.println(obj.startsWith("app"));  // true
        obj.insert("app");
        System.out.println(obj.search("app"));  // true

    }

    /**
     * Initialize your data structure here.
     */
    boolean flag = false;  // 如果是字符串终止节点 flag = 1
    Map<Character, Trie> map;  // 存储子节点

    public Trie() {
        map = new HashMap<>();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            if (node.map.get(word.charAt(i)) == null) {
                Trie curr = new Trie();
                node.map.put(word.charAt(i), curr);
                if(i == word.length() - 1) curr.flag = true;
                node = curr;
            }else {
                if(i == word.length() - 1) node.map.get(word.charAt(i)).flag = true;
                node = node.map.get(word.charAt(i));
            }
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            if (node.map.get(word.charAt(i)) == null) {
                return false;
            }else {
                if(i == word.length() - 1){
                    if(node.map.get(word.charAt(i)).flag == false) return false;
                }
                node = node.map.get(word.charAt(i));
            }
        }
        return true;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            if (node.map.get(prefix.charAt(i)) == null) {
                return false;
            }
            node = node.map.get(prefix.charAt(i));
        }
        return true;
    }
}

