package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 两个数组的交集
public class Intersection {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        Intersection obj = new Intersection();
        System.out.println(Arrays.toString(obj.intersection(nums1, nums2)));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        int[] re = {};
        if(nums1.length == 0 || nums2.length == 0) return re;
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if(set1.contains(nums2[i])) res.add(nums2[i]);
        }
        int[] resArr = new int[res.size()];
        int i = 0;
        for (Integer num: res) {
            resArr[i] = num;
            i++;
        }
        return resArr;
    }
}
