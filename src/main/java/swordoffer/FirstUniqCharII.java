package swordoffer;

import java.util.LinkedHashMap;
import java.util.Map;

// 剑指offer 50题 第一个只出现一次的字符
public class FirstUniqCharII {
    public static void main(String[] args) {
        FirstUniqCharII obj = new FirstUniqCharII();
        String s = "abaccdeff";
        System.out.println(obj.firstUniqChar(s));
    }

    public char firstUniqChar(String s) {
        char res = ' ';
        if (s == null || s.length() == 0) return res;
        if (s.length() == 1) return s.charAt(0);

        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return res;
    }
}
