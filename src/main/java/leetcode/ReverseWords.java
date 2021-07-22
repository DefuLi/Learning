package leetcode;

// 翻转字符串里的单词
public class ReverseWords {
    public static void main(String[] args) {
        String s = "the sky   is bule  ";
        ReverseWords obj = new ReverseWords();
        System.out.println(obj.reverseWords(s));
    }

    /**
     * 这个方法比较耗时，45ms。
     * 字符串拼接比较耗时
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String replace = s.replaceAll("\\s+", " ");
        String[] split = replace.split(" ");
        int start = 0;
        int end = split.length - 1;
        while (start < end) {
            String temp = split[start];
            split[start] = split[end];
            split[end] = temp;
            start++;
            end--;
        }
        String res = "";
        for (int i = 0; i < split.length; i++) {
            res = res + split[i] + " ";
        }
        return res.trim();
    }
    /** 将字符串转换为StringBuilder，省时间，避免了每次拼接都要开辟新的内存。
    public String reverseWords(String s) {
        String[] ss = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = ss.length - 1; i >= 0; i--) {
            if (!ss[i].equals("")) {
                res.append(ss[i].trim());
                if (i != 0) {
                    res.append(" ");
                }
            }
        }
        return res.toString();
    }
    */
}
