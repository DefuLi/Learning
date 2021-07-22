package leetcode;

import java.util.LinkedList;
import java.util.Queue;

// 用队列实现栈
public class MyStack {
    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.top());  // 2
        System.out.println(obj.pop());  // 2
        System.out.println(obj.top());  // 1
    }

    Queue<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack() {
        this.queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        this.queue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(empty()) return -1314;
        Queue<Integer> tempQueue = new LinkedList<>();
        int queueSize = this.queue.size();
        for (int i = 0; i < queueSize - 1; i++) {
            tempQueue.offer(this.queue.poll());
        }
        int res = this.queue.poll();
//        tempQueue.offer(this.queue.poll());
        while (!tempQueue.isEmpty()){
            this.queue.offer(tempQueue.poll());
        }
        return res;
    }

    /** Get the top element. */
    public int top() {
        if(empty()) return -1314;
        Queue<Integer> tempQueue = new LinkedList<>();
        int queueSize = this.queue.size();
        for (int i = 0; i < queueSize - 1; i++) {
            tempQueue.offer(this.queue.poll());
        }
        int res = this.queue.peek();
        tempQueue.offer(this.queue.poll());
        while (!tempQueue.isEmpty()){
            this.queue.offer(tempQueue.poll());
        }
        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        boolean res = queue.isEmpty();
        return res;
    }
}
