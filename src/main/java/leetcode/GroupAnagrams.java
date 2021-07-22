package leetcode;

import java.util.*;

// 字母异位词分组
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams obj = new GroupAnagrams();
        obj.groupAnagrams(strs);
    }

    /**
     * 核心思想是对char[]进行排序，排序后的string可以当作键。
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0 || strs == null) return new ArrayList<List<String>>();
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            if (map.containsKey(Arrays.toString(temp))) {  // map的键为排序好的string，值为list的索引
                int index = map.get(Arrays.toString(temp));
                list.get(index).add(strs[i]);
            } else {
                List<String> sub = new ArrayList<>();
                sub.add(strs[i]);
                int size = list.size();
                list.add(sub);
                map.put(Arrays.toString(temp), size);
            }
        }
        return list;
    }
}
