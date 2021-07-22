package leetcode;

import java.util.ArrayList;
import java.util.List;

// 单词替换

/**
 * 构造一个Trie树即可
 */
public class ReplaceWords {
    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
        String sentence = "the cattle was rattled by the battery";
        ReplaceWords obj = new ReplaceWords();
        System.out.println(obj.replaceWords(dict, sentence));  // the cat was rat by the bat
    }

    TrieNode head = new TrieNode(null);  // 头节点

    public String replaceWords(List<String> dict, String sentence) {
        buildTrie(dict);
        TrieNode root = head;
        String[] strArr = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            stringBuilder.append(search(root ,strArr[i]) + " ");
        }
        return stringBuilder.toString().trim();
    }

    // 构建一颗Trie
    public void buildTrie(List<String> dict) {
        for (String str : dict) {
            TrieNode curr = head;
            for (int i = 0; i < str.length(); i++) {
                if (curr.map.get(str.charAt(i)) != null) {
                    if (i == str.length() - 1) {
                        curr.map.get(str.charAt(i)).flag = true;
                    }
                    curr = curr.map.get(str.charAt(i));
                } else {
                    TrieNode node = new TrieNode(str.charAt(i));
                    if (i == str.length() - 1) {
                        node.flag = true;
                    }
                    curr.map.put(str.charAt(i), node);
                    curr = node;
                }
            }
        }
    }
    // 给定word，如果Trie树中有该word的前缀，则进行替换
    public String search(TrieNode root, String word) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if(root.map.get(word.charAt(i)) != null) {
                res.append(word.charAt(i));
                if(root.map.get(word.charAt(i)).flag == true) {
                    return res.toString();
                }
                root = root.map.get(word.charAt(i));
            }else {
                return word;
            }
        }
        return res.toString();
    }
}
