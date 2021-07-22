package leetcode;

// 字符串相加
public class AddStrings {
    public static void main(String[] args) {

        String num1 = "99";
        String num2 = "1";
        AddStrings obj = new AddStrings();

        System.out.println(obj.addStrings(num1, num2));  // 100
    }

    /**
     * 双指针
     * 如果有一个字符串序列先走到了头，那么后面用0代替它
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) return num2;
        if (num2 == null || num2.length() == 0) return num1;

        int len1 = num1.length();
        int len2 = num2.length();
        StringBuilder sb = new StringBuilder();
        len1--;
        len2--;
        int carry = 0;
        while (len1 >= 0 || len2 >= 0) {
            int in1 = len1 >= 0 ? num1.charAt(len1) - '0' : 0;
            int in2 = len2 >= 0 ? num2.charAt(len2) - '0' : 0;
            int temp = in1 + in2 + carry;
            carry = temp / 10;
            sb.append(temp % 10);
            len1--;
            len2--;
        }
        if(carry == 1) sb.append(1);
        return sb.reverse().toString();
    }

}
