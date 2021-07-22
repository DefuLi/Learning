package swordoffer;

// 剑指offer 面试题05 替换空格
public class ReplaceSpace {
    public static void main(String[] args) {
        String s = "We are happy.";
        ReplaceSpace obj = new ReplaceSpace();
        System.out.println(obj.replaceSpace(s));
    }

    public String replaceSpace(String s) {
        if(s == null || s.length() < 1) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') sb.append("%20");
            else sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
