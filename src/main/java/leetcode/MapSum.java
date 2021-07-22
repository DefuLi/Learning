package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Map Sum Pairs

/**
 * 计算sum时，求出prefix及其以后的节点中flag==true时的num和
 * 采用深度优先搜索。
 */
public class MapSum {
    public static void main(String[] args) {
        MapSum obj = new MapSum();
        obj.insert("apple", 3);
        System.out.println(obj.sum("ap"));  // 3
        obj.insert("app", 2);
        System.out.println(obj.sum("ap"));  // 5
    }

    TrieNode head;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        head = new TrieNode(null);
    }

    public void insert(String key, int val) {
        TrieNode root = head;
        for (int i = 0; i < key.length(); i++) {
            if (root.map.get(key.charAt(i)) != null) {
                if(i == key.length() - 1) {
                    root.map.get(key.charAt(i)).flag = true;
                    root.map.get(key.charAt(i)).num = val;
                }
                root = root.map.get(key.charAt(i));
            }else {
                TrieNode node = new TrieNode(key.charAt(i));
                root.map.put(key.charAt(i), node);
                if(i == key.length() - 1) {
                    node.flag = true;
                    node.num = val;
                }
                root = node;
            }
        }
    }

    public int sum(String prefix) {
        TrieNode root = head;
        int sumRes = 0;
        if(prefix.length() == 0) return sumRes;
        root = root.map.get(prefix.charAt(0));

        for (int i = 1; i < prefix.length(); i++) {
            if(root != null) {
                // if(root.flag == true) sumRes += root.num;
                root = root.map.get(prefix.charAt(i));
            }else return 0;
        }
        if(root == null) return 0;
        // if(root.flag == true) sumRes += root.num;
        Stack<TrieNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TrieNode node = stack.pop();
            if(node.flag == true) sumRes += node.num;
            for (Map.Entry<Character, TrieNode> entry:node.map.entrySet()) {
                stack.push(entry.getValue());
            }
        }
        return sumRes;
    }
}

class TrieNode {
    Character ch;
    int num;
    boolean flag;
    Map<Character, TrieNode> map;

    TrieNode(Character ch) {
        this.ch = ch;
        this.num = 0;
        flag = false;
        this.map = new HashMap<>();
    }
}