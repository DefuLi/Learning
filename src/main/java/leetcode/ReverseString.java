package leetcode;

import java.util.Arrays;

// 反转字符串
public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        ReverseString obj = new ReverseString();
        obj.reverseString(s);
    }

    /**
     * 递归
     *
     * @param s
     */
    public void reverseString(char[] s) {
        helper(s, 0, s.length - 1);
        System.out.println(Arrays.toString(s));
    }

    public void helper(char[] s, int start, int end) {
        if (start >= end) return;
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        helper(s, ++start, --end);
    }

    /**
     * 这个迭代的方法
     *
     * @param s
     */
    public void reverseString1(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char temp;
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
        System.out.println(Arrays.toString(s));
    }

}
