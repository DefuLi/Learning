package swordoffer;

// 剑指offer 面试题58-I 翻转单词顺序
public class ReverseWordsII {
    public static void main(String[] args) {
        String s = "a good   example";
        ReverseWordsII obj = new ReverseWordsII();
        System.out.println(obj.reverseWords(s));
    }

    /**
     * 剑指offer题解的空间复杂度是O(n) 并且复杂我个人认为不是好方法
     * 用StringBuilder是个好方法 简洁 虽然在空间和时间上没有提升
     * 注意：上述方法没有办法保证多个空格的情况，还是要用剑指offer的方法
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        s = s.trim();
        String[] strArr = s.split("\\s+");  // 这里保证了分隔字符串时 依据的规则是一个或多个空格
        int start = 0;
        int end = strArr.length - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = strArr.length - 1; i >= 0; i--) {
            sb.append(strArr[i] + " ");
        }
        return sb.toString().trim();
    }

    /**
     * 剑指offer的方法 这个方法可以应用中间有多个空格的情况 并且保证中间的多个空格数量不变
     *
     * @param s
     * @return
     */
    public String reverseWords1(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder(s);
        helper(sb, 0, sb.length() - 1);  // 先对整体倒序
        int start = 0;
        int end = 0;
        while (end < sb.length()) {
            if(sb.charAt(end) != ' ') {
                while (end < sb.length() && sb.charAt(end) != ' ') {
                    end++;
                }
                helper(sb, start, end - 1);
            }else {
                while (sb.charAt(end) == ' ') {
                    end++;
                }
                start = end;
            }
        }
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
