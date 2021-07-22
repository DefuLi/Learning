package leetcode;

// 实现strStr()
public class StrStr {
    public static void main(String[] args) {
        String haystack = "aaaaa";
        String needle = "ll";
        StrStr obj = new StrStr();
        System.out.println(obj.strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        int hayLen = haystack.length();  // 5
        int needLen = needle.length();   // 2
        int nums = hayLen - needLen;  // 3
        if (nums < 0) return -1;

        for (int i = 0; i < nums + 1; i++) {
            String subStr = haystack.substring(i, i + needLen);
            if(subStr.equals(needle)) return i;
        }
        return -1;
    }
}
