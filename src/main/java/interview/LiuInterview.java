package interview;

import java.util.Stack;

/**
 * @author Defu Li
 * @since 2020/9/25 18:55
 */
public class LiuInterview {

    public static void main(String[] args) {
        LiuInterview obj = new LiuInterview();
        String str = "$c$df";
        System.out.println(obj.getProcessLen(str));
    }

    public int getProcessLen(String str) {
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '$') {
                if(!stack.empty()) {
                    stack.pop();
                    continue;
                }else {
                    continue;
                }
            }
            stack.push(chars[i]);
        }
        return stack.size();
    }
}
