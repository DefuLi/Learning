package cleancode.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串的排列
 *
 * @author Defu Li
 * @since 2021/8/10 23:31
 */
public class LeetCode5673 {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "boaoo";
        LeetCode5673 obj = new LeetCode5673();
        System.out.println(obj.checkInclusion(s1, s2));
    }

    /**
     * 给你两个字符串s1和s2 ，写一个函数来判断s2是否包含s1的排列。
     *
     * @param s1 相当于子串
     * @param s2 长串
     * @return 布尔值
     */
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int right = 0;
        int valid = 0;
        Map<Character, Integer> windows = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            needs.put(s1.charAt(i), needs.getOrDefault(s1.charAt(i), 0) + 1);
        }

        while (right < s2.length()) {
            // 先右移窗口
            char addChar = s2.charAt(right);
            right++;
            if (needs.containsKey(addChar)) {
                windows.put(addChar, windows.getOrDefault(addChar, 0) + 1);
                if (needs.get(addChar).equals(windows.get(addChar))) {
                    valid++;
                }
            }

            while (right - left >= s1.length()) {
                if (valid == needs.size()) {
                    return true;
                }

                // 左移窗口
                char deleteChar = s2.charAt(left);
                left++;
                if (needs.containsKey(deleteChar)) {
                    if (needs.get(deleteChar).equals(windows.get(deleteChar))) {
                        valid--;
                    }
                    windows.put(deleteChar, windows.get(deleteChar) - 1);
                }
            }
        }
        return false;
    }
}
