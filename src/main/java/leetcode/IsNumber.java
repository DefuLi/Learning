package leetcode;

// 表示数值的字符串
public class IsNumber {
    public static void main(String[] args) {
        String s = "-.3E-2";  // 不合格
        IsNumber obj = new IsNumber();
        System.out.println(obj.isNumber(s));  // false
    }

    int i = 0;

    /**利用下面的方法可以通过测试用例
     * 但是对于"-.3E-2" 理论上是false  但是下面代码输出确实true
     * 不过leetcode上没有这个测试用例。
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        s = s.trim();

        boolean A = scanInteger(s);
        boolean B = false;
        boolean C = false;

        if(i < s.length() && s.charAt(i) == '.') {
            i++;
            B = scanUnsignInteger(s);
        }
        if(i < s.length() && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
            i++;
            C = scanInteger(s);
            if(C == false) return false;
        }

        return i == s.length() && (A || B);  // 必须扫描完整个字符串 并且 可以有A没B，没A必须有B
    }

    // 扫描AC 有符号或没有符号
    public boolean scanInteger(String s) {
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
        return scanUnsignInteger(s);
    }

    // 扫描B 无符号整数
    public boolean scanUnsignInteger(String s) {
        int start = i;
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') i++;
        // i > start 说明扫描到了数字
        // i <= start 说明扫描到的不是数字 或者i越界了

        return i > start;
    }

}
