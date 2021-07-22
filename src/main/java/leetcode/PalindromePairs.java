package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 回文对
public class PalindromePairs {
    public static void main(String[] args) {
        String[] words = {"a", ""};
        PalindromePairs obj = new PalindromePairs();
        List<List<Integer>> res = obj.palindromePairs(words);
        for (int i = 0; i < res.size(); i++) {  // 01103224
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.println(res.get(i).get(j));
            }
        }
    }

    TriePalind head = new TriePalind();

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        buildTrie(words);  // 构建Trie树

        for (int i = 0; i < words.length; i++) {
            // 第一种情况 对称
            StringBuilder sB = new StringBuilder(words[i]).reverse();
            int index = search(sB.toString());
            if (index != -1 && index != i) {
                res.add(Arrays.asList(i, index));
            }

            // 第二种情况 前缀回文
            for (String str: getSuffix(words[i])) {
                index = search(str);
                if(index != -1 && index != i) {
                    res.add(Arrays.asList(index, i));
                }
            }

            // 第三种情况 后缀回文
            for (String str: getPrefix(words[i])) {
                index = search(str);
                if(index != -1 && index != i) {
                    res.add(Arrays.asList(i, index));
                }
            }
        }
        return res;
    }

    // 构建Trie树
    public void buildTrie(String[] words) {
        for (int i = 0; i < words.length; i++) {
            TriePalind root = head;
            for (int j = 0; j < words[i].length(); j++) {
                root = root.append(words[i].charAt(j));
            }
            root.isWord = true;
            root.index = i;
        }
    }

    // 搜索Trie树 如果有返回index 如果没有返回-1
    public int search(String word) {
        TriePalind root = head;
        for (int i = 0; i < word.length(); i++) {
            if (root.nexts[word.charAt(i) - 'a'] != null) {
                root = root.nexts[word.charAt(i) - 'a'];
            } else {
                return -1;
            }
        }
        if (root.isWord == true) return root.index;
        return -1;
    }

    // 判断一个字符串是否为回文数
    public boolean isPalindrome(String word) {
        int start = 0;
        int end = word.length() - 1;
        while (start <= end) {
            if (word.charAt(start) == word.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    // 若前缀回文 获取后缀反序列
    public List<String> getSuffix(String word) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (isPalindrome(word.substring(0, i + 1))) {
                list.add(new StringBuilder(word.substring(i + 1, word.length())).reverse().toString());
            }
        }
        return list;
    }

    // 若后缀回文 获取前缀反序列
    public List<String> getPrefix(String word) {
        List<String> list = new ArrayList<>();
        for (int i = word.length() - 1; i >= 0; i--) {
            if (isPalindrome(word.substring(i, word.length()))) {
                list.add(new StringBuilder(word.substring(0, i)).reverse().toString());
            }
        }
        return list;
    }
}

class TriePalind {
    TriePalind[] nexts = new TriePalind[26];
    boolean isWord = false;
    int index;

    TriePalind append(char ch) {
        if (nexts[ch - 'a'] != null) {
            return nexts[ch - 'a'];
        } else {
            TriePalind node = new TriePalind();
            nexts[ch - 'a'] = node;
            return node;
        }
    }
}