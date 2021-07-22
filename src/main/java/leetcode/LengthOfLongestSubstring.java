package leetcode;

import java.util.HashMap;
import java.util.Map;

// 无重复字符的最长字串
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "tmmzuxt";
        LengthOfLongestSubstring obj = new LengthOfLongestSubstring();
        System.out.println(obj.lengthOfLongestSubstring(s));  // 5
    }

    /**代码可以优化：https://www.cxyxiaowu.com/7494.html
     * 利用滑动窗口，map存储字符和索引
     * 设置left指针，用于计算最大间距
     * 判断当前s.charAt(i)字符是否在map中，如果在，则会有两种情况，
     * 一种是该字符在left左侧，应该跳过继续
     * 一种是在left右侧，应该计算res间距。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) < left) {
                    if (i == s.length() - 1) res = Math.max(res, i - left + 1);
                    map.put(s.charAt(i), i);
                } else {
                    res = Math.max(res, i - left);
                    left = map.get(s.charAt(i)) + 1;
                    map.put(s.charAt(i), i);
                }
            } else {
                if (i == s.length() - 1) res = Math.max(res, i - left + 1);
                map.put(s.charAt(i), i);
            }
        }
        return res;
    }

}
