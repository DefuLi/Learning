package leetcode;

import java.util.*;

// 最长连续序列

/**
 * 使用并查集
 * 合并的原则是当前val存在val-1，那么合并val和val-1
 * 用sizeMap记录每个小集合的老大的手下数
 * 返回最大的max即可
 */
public class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = {9, 4, 7, 3, 5, 8, 6};
        LongestConsecutive obj = new LongestConsecutive();
        System.out.println(obj.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        UnionFind unionFind = new UnionFind(nums);
        for (int i = 0; i < nums.length; i++) {
            if (unionFind.father.containsKey(nums[i] - 1)) {
                unionFind.Union(nums[i], nums[i] - 1);
            }
        }
        return unionFind.max;
    }
}

class UnionFind {
    int max;
    Map<Integer, Integer> father;
    Map<Integer, Integer> size;

    public UnionFind(int[] nums) {  // 构造函数
        max = 1;
        father = new HashMap<>(nums.length);
        size = new HashMap<>(nums.length / 2);
        for (int i = 0; i < nums.length; i++) {
            father.put(nums[i], nums[i]);  // 先假定val父亲还是自己 后面再合并
            size.put(nums[i], 1);  // 默认长度为1
        }
    }

    public int Find(int val) {
        int valFather = father.get(val);
        while (true) {
            int temp = father.get(valFather);
            if (temp == valFather) {
                father.put(val, temp);
                return temp;
            }
            valFather = temp;
        }
    }

    public void Union(int a, int b) {
        int aFather = Find(a);
        int bFather = Find(b);
        if (aFather != bFather) {
            int aSize = size.get(aFather);
            int bSize = size.get(bFather);
            if (aSize >= bSize) {
                father.put(bFather, aFather);
                size.put(aFather, aSize + bSize);
            } else {
                father.put(aFather, bFather);
                size.put(bFather, aSize + bSize);
            }
            max = Math.max(max, aSize + bSize);
        }
    }
}