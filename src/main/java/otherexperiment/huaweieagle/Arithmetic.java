package otherexperiment.huaweieagle;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Defu Li
 * @date 2021/3/15 21:45
 */
public class Arithmetic {
    /**
     * 四则表达式
     */

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String expression = cin.nextLine();
        cin.close();
        String result = calculate(expression);
        System.out.println(result);
    }

    // https://leetcode-cn.com/problems/basic-calculator-ii/solution/ji-ben-ji-suan-qi-ii-by-leetcode-solutio-cm28/

    // 待实现函数，在此函数中填入答题代码
    private static String calculate(String expression) {
        if (expression == null || expression.equals("") || expression.length() == 0) {
            return "error";
        }

        int num = 0;
        int len = expression.length();
        for (int i = 0; i < len; i++) {
            if(Character.isDigit(expression.charAt(i))) {
                num = num * 10 + expression.charAt(i) - '0';
            }
            if(!Character.isDigit(expression.charAt(i))) {

            }
        }

        Stack<Character> stack = new Stack<>();
        stack.push(expression.charAt(0));  // 先装入第一个字符
//        int len = expression.length();
        for (int i = 1; i < len; i++) {
            if (expression.charAt(i) == '*') {
                int first = stack.pop() - 48;
                int second = expression.charAt(i + 1);
                int calResult = first * second;
                stack.push((char) (calResult + 48));
                i++;
            } else if (expression.charAt(i) == '/') {
                int first = stack.pop() - 48;
                int second = expression.charAt(i + 1);
                if (second == 0) {
                    return "error";
                }
                int calResult = first / second;
                stack.push((char) (calResult + 48));
                i++;
            }else {
                stack.push(expression.charAt(i));
            }
        }
        return "";
    }
}
