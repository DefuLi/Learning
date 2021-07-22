package leetcode;

import java.util.Stack;

// 用两个栈实现队列
public class TwoStackPushPop {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        TwoStackPushPop twoStackPushPop = new TwoStackPushPop();
        twoStackPushPop.push(1);
        twoStackPushPop.push(2);
        twoStackPushPop.push(3);
        System.out.println(twoStackPushPop.pop());
        System.out.println(twoStackPushPop.pop());
        twoStackPushPop.push(4);
        System.out.println(twoStackPushPop.pop());
        twoStackPushPop.push(5);
        System.out.println(twoStackPushPop.pop());
        System.out.println(twoStackPushPop.pop());
    }

    // 入队列
    public void push(int node){
        stack1.push(node);
    }
    // 出队列
    public int pop(){
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
