package leetcode;

import java.util.Stack;

// 逆波兰表达式求值
public class EvalRPN {
    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        EvalRPN ev = new EvalRPN();
//        System.out.println(6/-122);
        System.out.println(ev.evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                int c = a + b;
                stack.push(c);
            } else if (tokens[i].equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                int c = b - a;
                stack.push(c);
            } else if (tokens[i].equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                int c = a * b;
                stack.push(c);
            } else if (tokens[i].equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                int c = (int) b / a;
                stack.push(c);
            } else stack.push(Integer.parseInt(tokens[i]));
        }
        return stack.peek();
    }
}
