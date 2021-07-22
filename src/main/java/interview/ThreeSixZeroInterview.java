package interview;

import java.util.Scanner;
import java.util.Stack;

/**
 * 360笔试
 */
public class ThreeSixZeroInterview {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String or = sc.nextLine();
//        String ta = sc.nextLine();
//        Main obj = new Main();
//        System.out.println(obj.getLeastNum(or, ta));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ThreeSixZeroInterview obj = new ThreeSixZeroInterview();
        System.out.println(obj.getP(n, m));

    }

    int A = 0;
    int B = 0;

    /**
     * 抽奖 运行不对
     *
     * @param n
     * @param m
     * @return
     */
    public float getP(int n, int m) {
        if (n == 0) {
            B += 1;
            return 0;
        }
        A += 1;
        if (m != 0) {
            B += 1;
            if (m == 1) {
                return 0;
            } else if (m == 2) {
                getP(n - 1, m - 2);
            } else {
                getP(n, m - 3);
                getP(n - 1, m - 2);
            }
        } else return 0;
        return A / (A + B);
    }

    /**
     * DNA匹配
     *
     * @param or
     * @param ta
     * @return
     */
    public int getLeastNum(String or, String ta) {
        Stack<Character> stack = new Stack<>();
        int num = 0;
        for (int i = 0; i < or.length(); i++) {
            if (or.charAt(i) != ta.charAt(i)) {
                if (stack.isEmpty()) {
                    stack.push(ta.charAt(i));
                } else {
                    if (stack.peek() != ta.charAt(i)) {
                        stack.pop();
                        num++;
                    } else {
                        stack.push(ta.charAt(i));
                    }
                }
            }
        }
        int size = stack.size();
        return num + size;
    }
}
