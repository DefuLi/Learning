package leetcode;

import java.util.Arrays;
import java.util.Stack;

// 每日温度
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperatures dt = new DailyTemperatures();
        int[] re = dt.dailyTemperatures(temperatures);
        for (int i = 0; i < re.length; i++) {
            System.out.println(re[i]);
        }
    }

    public int[] dailyTemperatures(int[] T) {
        int[] re = new int[T.length];
        Arrays.fill(re, 0);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty()){
                if(T[i] > T[stack.peek()]){  // 升高 解决的关键在于栈中存储的是索引值，
                                            // 判断是第几个比当前值大的话，直接用索引相减。
                    re[stack.peek()] = i - stack.peek();
                    stack.pop();
                }else break;
            }
            stack.push(i);
        }
        return re;
    }
}
