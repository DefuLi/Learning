package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

// 字符串中第一个唯一字符
public class FirstUniqChar {
    public static void main(String[] args) {
        FirstUniqChar obj = new FirstUniqChar();
        String s = "loveleetcode";
        System.out.println(obj.firstUniqChar(s));
    }

    public int firstUniqChar(String s) {
        if (s.length() == 0 || s.trim().length() == 0) return -1;
        char[] charS = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();  // HashMap无序，LinkedHashMap有序
        for (int i = 0; i < charS.length; i++) {
            if (map.containsKey(charS[i])) {
                map.put(charS[i], map.get(charS[i]) + 1);
            } else {
                map.put(charS[i], 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                for (int i = 0; i < charS.length; i++) {
                    if(entry.getKey().equals(charS[i])) return i;
                }
            }
        }
        return -1;
    }
}