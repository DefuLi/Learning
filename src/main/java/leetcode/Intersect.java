package leetcode;

import java.util.*;

// 两个数组的交集Ⅱ
public class Intersect {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        Intersect obj = new Intersect();
        System.out.println(Arrays.toString(obj.intersect(nums1, nums2)));
    }

    /**
     * 先用map1存储nums1数组的值，如果某个键出现两次，就对应的值加1。
     * 然后遍历nums2，遇到map1中相同的，存起来，并且对应的值减1。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] temp = {};
        if(nums1.length == 0 || nums2.length == 0) return temp;
        Map<Integer, Integer> map1 = new HashMap<>();  // 存储nums1的val和index
        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if(!map1.containsKey(nums2[i])){
                continue;
            }else {  // 有交集
                if(map1.get(nums2[i]) >= 1) {
                    list.add(nums2[i]);
                    map1.put(nums2[i], map1.get(nums2[i]) - 1);
                }
            }
        }
        int[] res = list.stream().mapToInt(Integer::valueOf).toArray();
        return res;
    }
}
