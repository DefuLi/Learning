package swordoffer;

// 剑指offer 面试题67 把字符串转换成整数
public class StrToInt {
    public static void main(String[] args) {
        StrToInt obj = new StrToInt();
        String str = "+1";
        System.out.println(obj.strToInt(str));
    }

    /**
     * res = res * 10 + (chars[j] - '0');
     * @param str
     * @return
     */
    public int strToInt(String str) {
        if (str.trim().length() == 0) return 0;
        char[] chars = str.trim().toCharArray();  // 去空格并转字符数组
        int sign = 1;  // 默认是正数
        int i = 0;
        long res = 0;
        if (chars[0] == '-') {
            sign = -1;
            i = 1;
        }else if(chars[0] == '+') {
            i = 1;
        }
        for (int j = i; j < chars.length; j++) {
            if (chars[j] > '9' || chars[j] < '0') break;
            res = res * 10 + (chars[j] - '0');
            if (res > Integer.MAX_VALUE) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        return sign == 1 ? (int) res : (int) -res;
    }
}
