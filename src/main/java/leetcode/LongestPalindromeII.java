package leetcode;

import java.util.HashMap;
import java.util.Map;

// 最长回文串
public class LongestPalindromeII {
    public static void main(String[] args) {
        String s = "abccccdd";
        LongestPalindromeII obj = new LongestPalindromeII();
        System.out.println(obj.longestPalindrome(s));  // 7
    }

    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            res += entry.getValue() % 2 == 0 ? entry.getValue() : entry.getValue() - 1;
        }
        return Math.min(res + 1, s.length());
    }
}
