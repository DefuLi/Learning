package cleancode.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 *
 * @author Defu Li
 * @since 2021/8/9 23:39
 */
public class LeetCode76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        LeetCode76 obj = new LeetCode76();
        System.out.println(obj.minWindow(s, t));
    }


    public String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();
        for (char ch : t.toCharArray()) {
            needs.put(ch, needs.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char currChar = s.charAt(right);
            right++;
            if (needs.containsKey(currChar)) {
                window.put(currChar, window.getOrDefault(currChar, 0) + 1);
                if (needs.get(currChar).equals(window.get(currChar))) {
                    valid++;
                }
            }
            // 判断左侧窗口是否收缩
            while (valid == needs.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char deleteChar = s.charAt(left);
                left++;
                if (needs.containsKey(deleteChar)) {
                    if (window.get(deleteChar).equals(needs.get(deleteChar))) {
                        valid--;
                    }
                    window.put(deleteChar, window.get(deleteChar) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, len + start);
    }
}
