package leetcode;

import java.util.Stack;

// 用栈实现队列
public class MyQueue {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());  // 返回 1
    }

    private Stack<Integer> stack;
    /** Initialize your data structure here. */
    public MyQueue() {
        this.stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        this.stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(empty()) return -1314;
        if(this.stack.size() == 1) return this.stack.pop();
        Stack<Integer> tempStack = new Stack<>();
        int stackSize = this.stack.size();
        for (int i = 0; i < stackSize - 1; i++) {
            tempStack.push(this.stack.pop());
        }
        int peek = this.stack.pop();
        int tempSize = tempStack.size();
        for (int i = 0; i < tempSize; i++) {
            this.stack.push(tempStack.pop());
        }
        return peek;
    }

    /** Get the front element. */
    public int peek() {
        if(empty()) return -1314;
        if(this.stack.size() == 1) return this.stack.peek();
        Stack<Integer> tempStack = new Stack<>();
        int stackSize = this.stack.size();
        for (int i = 0; i < stackSize - 1; i++) {
            tempStack.push(this.stack.pop());
        }
        int peek = this.stack.peek();
        int tempSize = tempStack.size();
        for (int i = 0; i < tempSize; i++) {
            this.stack.push(tempStack.pop());
        }
        return peek;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        boolean res = stack.isEmpty();
        return res;
    }
}
