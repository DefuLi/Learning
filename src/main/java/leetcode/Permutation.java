package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 字符串的排列
public class Permutation {
    public static void main(String[] args) {
        String s = "abc";
        Permutation obj = new Permutation();
        String[] res = obj.permutation(s);
        for (String item : res) {
            System.out.println(item);
        }
    }

    /**
     * 递归
     * 先确定第一个位置上的字符 怎么确定呢？
     * 让第一个位置上的字符分别与字符串上所有位置字符进行交换
     *
     * 再确定第二个位置上字符
     * 让第二个位置上字符分别与字符串上第二个位置及其之后的字符进行交换
     *
     * 递归结束的条件是index == length - 1
     * @param s
     * @return
     */
    public String[] permutation(String s) {
        if (s == null || s.length() == 0) return new String[0];

        char[] chars = s.toCharArray();
        List<String> list = new ArrayList<>();
        int length = chars.length;
        helper(chars, list, 0, length);

        Set<String> set = new HashSet<>(list);
        String[] res = new String[set.size()];
        int i = 0;
        for (String item: set) {
            res[i++] = item;
        }
        return res;
    }

    public void helper(char[] chars, List<String> list, int index, int length) {
        if (index == length - 1) {
            list.add(chars2str(chars));
            return;
        }

        for (int i = index; i < length; i++) {
             char temp = chars[index];
             chars[index] = chars[i];
             chars[i] = temp;
             helper(chars, list, index + 1, length);
             
             temp = chars[index];
             chars[index] = chars[i];
             chars[i] = temp;
        }

    }

    private String chars2str(char[] chars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }
}
