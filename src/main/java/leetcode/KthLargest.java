package leetcode;

import java.util.PriorityQueue;

// Kth Largest Element in a Stream
public class KthLargest {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println(queue.size());


        /**
        int k = 3;
        int[] arr = {4, 5, 8, 2};
        KthLargest obj = new KthLargest(k, arr);
        System.out.println(obj.add(3));  // 4
        System.out.println(obj.add(5));  // 5
        System.out.println(obj.add(10));  // 5
        System.out.println(obj.add(9));  // 8
        System.out.println(obj.add(4));  // 8
         */
    }
    PriorityQueue<Integer> queue;
    int InitK;

    /**
     * 维护一个只有k个元素的小顶堆
     * 当有一个新元素过来的时候，判断其与堆顶元素的大小
     * 如果新元素大于堆顶元素，则删除堆顶元素加入新元素
     * 这样持续到最后，堆顶元素就是第k大的元素
     *
     * @param k
     * @param nums
     */
    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>();  // 默认是小顶堆
        InitK = k;
        if(nums.length == 0 || nums == null) return;
        if(nums.length <= k) {  // nums[]长度小于等于k 只插入 不维护
            for (int i = 0; i < nums.length; i++) queue.offer(nums[i]);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(queue.size() < k) queue.offer(nums[i]);  // 维护一个只有k个元素的小顶堆
            else {
                if(nums[i] > queue.peek()) {
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }
    }

    public int add(int val) {
        if(queue.size() < InitK) {
            queue.offer(val);
            return queue.peek();
        }
        if(val > queue.peek()) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }
}
