package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 最长不含重复字符的子字符串
public class LengthOfLongestSubstringII {
    public static void main(String[] args) {
        String s = "abcabcbb";
        LengthOfLongestSubstringII obj = new LengthOfLongestSubstringII();
        System.out.println(obj.lengthOfLongestSubstring(s));  // 3
    }

    /**
     * 方法一、滑动窗口
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(map.get(s.charAt(i)), left);
            }
            map.put(s.charAt(i), i + 1);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    /**
     * 方法二、动态规划
     * dp[i]表示第i个字符结尾的，不包含重复字符的最长长度
     * 剑指offer 48题题解
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 1;
        int d = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        for (int i = 1; i < n; i++) {
            if (map.containsKey(s.charAt(i))) {
                d = i - map.get(s.charAt(i)) + 1;
                if (d > dp[i - 1] + 1) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = i - map.get(s.charAt(i));
                }
            } else {
                dp[i] = dp[i - 1] + 1;
            }
            map.put(s.charAt(i), i);
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
