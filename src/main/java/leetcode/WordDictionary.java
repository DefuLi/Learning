package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// 添加与搜索单词 - 数据结构设计

/**
 * 先构造一颗Trie树，然后递归的查找
 * 通过全部测试用例，但时间超限
 */
public class WordDictionary {
    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("pad"));  // false
        System.out.println(obj.search("bad"));  // true
        System.out.println(obj.search(".ad"));  // true
        System.out.println(obj.search("b.."));  // true

    }

    /**
     * Initialize your data structure here.
     */
    TrieNode head;  // 头节点

    public WordDictionary() {
        head = new TrieNode(null);
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode curr = head;
        for (int i = 0; i < word.length(); i++) {
            if (curr.map.get(word.charAt(i)) != null) {
                if (i == word.length() - 1) {
                    curr.map.get(word.charAt(i)).flag = true;
                }
                curr = curr.map.get(word.charAt(i));
            } else {
                TrieNode node = new TrieNode(word.charAt(i));
                if (i == word.length() - 1) {
                    node.flag = true;
                }
                curr.map.put(word.charAt(i), node);
                curr = node;
            }
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        TrieNode root = head;
        boolean res = helper(root, word, 0);
        return res;
    }

    List<Boolean> list = new ArrayList<>();
    public boolean helper(TrieNode curr, String word, int i) {
        boolean res = false;
        if(i == word.length() && curr.flag == true) return true;
        if(i == word.length() && curr.flag == false) return false;
        if (word.charAt(i) == '.') {
            for (Map.Entry<Character, TrieNode> entry : curr.map.entrySet()) {
                list.add(helper(entry.getValue(), word, i + 1));
            }
        } else {
            if (curr.map.get(word.charAt(i)) != null) {
                list.add(helper(curr.map.get(word.charAt(i)), word, i + 1));
            } else return false;
        }

        for (int j = 0; j < list.size(); j++) {
            if(list.get(j) == true) return true;
        }
        return true;
    }
}
