package cleancode.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 无重复字符的最长子串
 * <p>
 * 给定一个字符串s，请你找出其中不含有重复字符的最长子串的长度。
 *
 * @author Defu Li
 * @since 2021/8/11 23:38
 */
public class LeetCode3 {
    public static void main(String[] args) {
        String s = " ";
        LeetCode3 obj = new LeetCode3();
        System.out.println(obj.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new LinkedList<>();
        int left = 0;
        int right = 0;
        int maxLen = Integer.MIN_VALUE;
        while (right < s.length()) {
            char addChar = s.charAt(right);
            right++;
            while (queue.contains(addChar)) {
                queue.poll();
                left++;
            }
            queue.offer(addChar);
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
