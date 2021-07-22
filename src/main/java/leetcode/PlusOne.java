package leetcode;

import java.util.Arrays;

// 加一
public class PlusOne {
    public static void main(String[] args) {
        int[] digits1 = {4, 3, 2, 1};
        int[] digits2 = {9, 9, 9};
        PlusOne obj = new PlusOne();

        System.out.println(Arrays.toString(obj.plusOne(digits1)));
        System.out.println(Arrays.toString(obj.plusOne(digits2)));
    }

    public int[] plusOne(int[] digits) {
        if (digits[0] == 0) {
            digits[0] = 1;
            return digits;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            int plus = digits[i] + 1;
            if (plus <= 9) {
                digits[i] = plus;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] res = new int[digits.length + 1];
        // 下面可以改进： 直接写成res[0] = 1
        // 因为除了第一个数为1外，其余的肯定为0，new的时候默认也是全为0
        if(digits[0] == 0){
            res[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                res[i+1] = digits[i];
            }
        }
        return res;
    }

}
