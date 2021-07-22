package leetcode;

import java.util.ArrayList;
import java.util.List;

// 最小栈

/**
 * 我自己的方法比较笨，获得min时选择了排序
 * 其实有个好方法，就是使用一个辅助栈 存储最小元素
 * 可以参考  https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/solution/mian-shi-ti-30-bao-han-minhan-shu-de-zhan-fu-zhu-z/
 *
 * 经过腾讯面试官的提醒 可以进一步优化 还可以使用不同步的辅助栈
 * https://leetcode-cn.com/problems/min-stack/solution/shi-yong-fu-zhu-zhan-tong-bu-he-bu-tong-bu-python-/
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());  // 返回-3
        minStack.pop();
        System.out.println(minStack.top());  // 返回0
        System.out.println(minStack.getMin());  // 返回-2
    }
    /**好方法
    Stack<Integer> A, B;
    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }
    public void push(int x) {
        A.add(x);
        if(B.empty() || B.peek() >= x)
            B.add(x);
    }
    public void pop() {
        if(A.pop().equals(B.peek()))
            B.pop();
    }
    public int top() {
        return A.peek();
    }
    public int min() {
        return B.peek();
    }
    */


    private List<Integer> list;
    /** initialize your data structure here. */
    public MinStack() {
        list = new ArrayList<>();
    }

    public void push(int x) {
        list.add(x);
    }

    public void pop() {
        if(!list.isEmpty()){
            list.remove(list.size()-1);
        }
    }

    public int top() {
        return list.get(list.size()-1);
    }

    public int getMin() {
        List<Integer> tempList = new ArrayList<>(list);
        int temp1 = top();
        pop();
        while (list.size() > 0) {
            if(temp1 >= top()) {
                temp1 = top();
                pop();
                continue;
            }else if (temp1 < top()){
                pop();
                continue;
            }
        }
        list = tempList;
        return temp1;
    }
}
