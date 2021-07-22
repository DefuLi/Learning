package leetcode;

// 最长公共前缀
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"bcd", "bc"};
        LongestCommonPrefix obj = new LongestCommonPrefix();
        System.out.println(obj.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int minLen = strs[0].length();
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLen) minLen = strs[i].length();
        }
        for (int i = 0; i < minLen + 1; i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].substring(0, i).equals(strs[j + 1].substring(0, i))) {
                    res = strs[j].substring(0, i);
                } else {
                    res = strs[j].substring(0, i - 1);
                    return res;
                }
            }
        }
        return res;
    }
}
