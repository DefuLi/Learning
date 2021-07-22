package swordoffer;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// 剑指offer 面试题59-I 滑动窗口的最大值
// 队列最大值
public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1, -1};
        int k = 1;
        MaxSlidingWindow obj = new MaxSlidingWindow();
        System.out.println(Arrays.toString(obj.maxSlidingWindow(nums, k)));
    }

    /**
     * 使用双端队列 双端队列特点：在队列的头和尾都可以执行插入和删除操作
     * 参考链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/solution/java-dan-diao-shuang-xiang-lian-biao-hua-tu-xiang-/
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) return new int[0];
        int index = 0;
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if(deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            if(i >= (k - 1)) {
                res[index++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
