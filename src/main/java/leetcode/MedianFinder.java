package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

// 数据流中的中位数
public class MedianFinder {
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(-1);
        obj.addNum(-2);
        obj.addNum(-3);
        obj.addNum(-4);
        System.out.println(obj.findMedian());
    }

    /**
     * 使用两个优先队列 也就是两个堆
     * 左边是大顶堆 右边是小顶堆
     * 维护好就可以了 可以看剑指offer41题
     */
    PriorityQueue<Integer> max, min;  // 最大堆和最小堆
    /** initialize your data structure here. */
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
        int maxLen = max.size();
        int minLen = min.size();
        if(maxLen >= minLen) {
            // 插入到最小堆中
            if(max.isEmpty()) {
                // 直接插入到最小堆中
                min.offer(num);
            }else {
                int peek = max.peek();
                if(num >= peek) min.offer(num);
                else{
                    max.poll();
                    max.offer(num);
                    min.offer(peek);
                }
            }
        }else {
            // 插入到最大堆中  最小堆一定不为空
            int peek = min.peek();
            if(num <= peek) max.offer(num);
            else {
                min.poll();
                min.offer(num);
                max.offer(peek);
            }
        }
    }

    public double findMedian() {
        int maxLen = max.size();
        int minLen = min.size();
        if((maxLen + minLen) % 2 == 1) {
            return min.peek();
        }else {
            return (double) (max.peek() + min.peek()) / 2;
        }
    }
}
