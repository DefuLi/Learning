package leetcode;


import java.util.Stack;

// 栈的压入、弹出序列
public class ValidateStackSequences {
    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        ValidateStackSequences obj = new ValidateStackSequences();
        System.out.println(obj.validateStackSequences(pushed, popped));  // true
    }

    /**
     * 使用一个辅助栈
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 1) return true;
        Stack<Integer> stack = new Stack<>();
        int j = 0;  // 控制pushed的index
        for (int i = 0; i < popped.length; i++) {
            if (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();

            } else {
                while (j < popped.length && pushed[j] != popped[i]) {
                    stack.push(pushed[j++]);
//                    if (j > popped.length) return false;
                }
                j++;
//                if (pushed[j] == popped[i]) stack.push(pushed[j++]);
            }
        }
        return stack.isEmpty();
    }
}
