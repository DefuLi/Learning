package cleancode.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 找到字符串中所有字母异位词
 * <p>
 * 给定两个字符串s和p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词指字母相同，但排列不同的字符串。
 *
 * @author Defu Li
 * @since 2021/8/11 23:06
 */
public class LeetCode438 {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        LeetCode438 obj = new LeetCode438();
        List<Integer> result = obj.findAnagrams(s, p);
        for (Integer integer : result
        ) {
            System.out.println(integer);
        }
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> windows = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            needs.put(p.charAt(i), needs.getOrDefault(p.charAt(i), 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s.length()) {
            char addChar = s.charAt(right);
            right++;
            if (needs.containsKey(addChar)) {
                windows.put(addChar, windows.getOrDefault(addChar, 0) + 1);
                if (windows.get(addChar).equals(needs.get(addChar))) {
                    valid++;
                }
            }

            while (right - left >= p.length()) {
                if (valid == needs.size()) {
                    list.add(left);
                }
                char deleteChar = s.charAt(left);
                left++;
                if (needs.containsKey(deleteChar)) {
                    if (needs.get(deleteChar).equals(windows.get(deleteChar))) {
                        valid--;
                    }
                    windows.put(deleteChar, windows.get(deleteChar) - 1);
                }
            }
        }
        return list;
    }
}
