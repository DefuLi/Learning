package leetcode;

// 1~n整数中1出现的次数
public class CountDigitOne {
    public static void main(String[] args) {
        CountDigitOne obj = new CountDigitOne();
        System.out.println(obj.countDigitOne(3234));
    }

    /**
     * 参考链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/javadi-gui-by-xujunyi/
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        return f(n);
    }

    /**
     * f(i)代表1~i出现1的个数
     * i == 3234 => high = 3、pow = 1000、last = 234
     * @param i
     * @return
     * f(pow - 1) + last + 1 + f(last)  当且仅当high == 1
     * pow + high * f(pow - 1) + f(last)  当且仅当high != 1
     */
    public int f(int i) {
        if(i <= 0) return 0;
        String s = String.valueOf(i);
        int high = s.charAt(0) - '0';
        int pow = (int)Math.pow(10, s.length() - 1);
        int last = i - high * pow;
        if(high == 1) {
            return f(pow - 1) + last + 1 + f(last);
        }else{
            return pow + high * f(pow - 1) + f(last);
        }
    }
}
