package swordoffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

// 剑指offer 面试题59-II 队列的最大值
public class MaxQueue {
    public static void main(String[] args) {

    }

    Deque<Integer> maxDeque;
    Queue<Integer> queue;
    public MaxQueue() {
        maxDeque = new LinkedList<>();
        queue = new LinkedList<>();
    }

    public int max_value() {
        if(maxDeque.isEmpty()) return -1;
        return maxDeque.peekFirst();
    }

    /**
     * value > maxDeque.peekLask() 这里不能是大于等于，不然最后删除的时候，会出问题
     * push->2 push->2 pop pop可以测试上述情况
     * @param value
     */
    public void push_back(int value) {
        while (!maxDeque.isEmpty() && value > maxDeque.peekLast()) {
            maxDeque.pollLast();
        }
        maxDeque.addLast(value);
        queue.offer(value);
    }

    public int pop_front() {
        if(queue.isEmpty()) return -1;
        int front = queue.peek();
        if(front == maxDeque.peekFirst()) maxDeque.pollFirst();
        return queue.poll();
    }
}
