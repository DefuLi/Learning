package swordoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 剑指offer 面试题57-II 和为s的连续正数序列
public class FindContinuousSequence {
    public static void main(String[] args) {
        int target = 9;
        FindContinuousSequence obj = new FindContinuousSequence();
        int[][] res = obj.findContinuousSequence(target);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    /**
     * 使用双指针不断的移动
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> lists = new ArrayList<>();
        int start = 1;
        int end = 2;
        int sum = 3;
        while (start < end) {
            if (sum < target) {
                end++;
                sum += end;
            } else if (sum > target) {
                start++;
                sum -= start - 1;
            } else if (sum == target) {
                List<Integer> sub = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    sub.add(i);
                }
                lists.add(sub);
                end++;
                sum += end;
            }
        }
        int[][] res = new int[lists.size()][];
        for (int i = 0; i < lists.size(); i++) {
            int[] subArr = new int[lists.get(i).size()];
            for (int j = 0; j < lists.get(i).size(); j++) subArr[j] = lists.get(i).get(j);
            res[i] = subArr;
        }
        return res;
    }
}
