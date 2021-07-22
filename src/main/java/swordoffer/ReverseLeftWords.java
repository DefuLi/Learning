package swordoffer;

// 剑指offer 面试题58-II 左旋转字符串
public class ReverseLeftWords {
    public static void main(String[] args) {
        String s = "abcdefg";
        int n = 2;
        ReverseLeftWords obj = new ReverseLeftWords();
        System.out.println(obj.reverseLeftWords(s, n));
    }

    /**
     * 做三次反转
     * 第一次反转前n个字符
     * 第二次反转剩余字符
     * 第三次反转整个字符
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        helper(sb, 0, n - 1);
        helper(sb, n, sb.length() - 1);
        helper(sb, 0, sb.length() - 1);  // 反转整个字符串
        return sb.toString();
    }

    /**
     * 按字符反转整个字符串
     *
     * @param sb
     */
    public void helper(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}
