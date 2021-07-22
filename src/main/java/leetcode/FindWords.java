package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 单词搜索 II

/**
 * 先把words中的所有字符串，构建一颗Trie树
 * 然后使用dfs深度优先搜索，结合visited判断是否已经访问该位置
 *
 */
public class FindWords {
    public static void main(String[] args) {
        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board = {{'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        FindWords obj = new FindWords();
        List<String> list = obj.findWords(board, words);
        for (String str : list) {  // eat oath
            System.out.println(str);
        }
    }

    TrieWords root = new TrieWords();  // Trie树的根节点
    int[] rx = {-1, 1, 0, 0};
    int[] cy = {0, 0, -1, 1};  // 按上下左右进行

    public List<String> findWords(char[][] board, String[] words) {
        for (int i = 0; i < words.length; i++) {  // 构建字典树
            char[] wordsChar = words[i].toCharArray();
            TrieWords node = root;
            for (int j = 0; j < wordsChar.length; j++) node = node.append(wordsChar[j]);
            node.word = words[i];
        }

        Set<String> founded = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.nexts[board[i][j] - 'a'] != null) {  // 判断board中每个字符 然后dfs
                    dfs(board, visited, i, j, root, founded);
                }
            }
        }
        List<String> list = new ArrayList<>();
        list.addAll(founded);
        return list;
    }

    public void dfs(char[][] board, boolean[][] visited, int row, int col, TrieWords node, Set<String> founded) {
        visited[row][col] = true;
        TrieWords curr = node.nexts[board[row][col] - 'a'];
        if (curr.word != null) founded.add(curr.word);  // 增加string 默认null
        for (int i = 0; i < 4; i++) {  // 上下左右进行搜索
            int newR = row + rx[i];
            int newC = col + cy[i];
            if (newR < 0 || newR > board.length - 1 || newC < 0 || newC > board[0].length - 1 || visited[newR][newC] == true)
                continue;
            TrieWords next = curr.nexts[board[newR][newC] - 'a'];
            if (next != null) dfs(board, visited, newR, newC, curr, founded);
        }
        visited[row][col] = false;
    }
}

class TrieWords {
    String word;
    TrieWords[] nexts = new TrieWords[26];

    TrieWords append(char ch) {
        if (nexts[ch - 'a'] != null) {
            return nexts[ch - 'a'];
        } else {
            TrieWords node = new TrieWords();
            nexts[ch - 'a'] = node;
            return node;
        }
    }
}