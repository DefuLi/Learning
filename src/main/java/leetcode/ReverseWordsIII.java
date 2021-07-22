package leetcode;

// 反转字符串中的单词 III
public class ReverseWordsIII {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        ReverseWordsIII obj = new ReverseWordsIII();
        System.out.println(obj.reverseWords(s));
    }

    public String reverseWords(String s) {
        String[] split = s.trim().split(" ");
        for (int i = 0; i < split.length; i++) {
            char[] charArr = split[i].toCharArray();
            int start = 0;
            int end = charArr.length - 1;
            while (start < end) {
                char temp = charArr[start];
                charArr[start] = charArr[end];
                charArr[end] = temp;
                start++;
                end--;
            }
            split[i] = String.valueOf(charArr);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < split.length; j++) {
            stringBuilder.append(split[j] + " ");
        }
        return stringBuilder.toString().trim();
    }
}
