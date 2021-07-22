package leetcode;

import java.util.Arrays;

// 打印从1到最大的n位数
public class PrintNumbers {
    public static void main(String[] args) {
        int n = 1;
        PrintNumbers obj = new PrintNumbers();
        int[] res = obj.printNumbers(n);
        System.out.println(Arrays.toString(res));
    }

    public int[] printNumbers(int n) {
        int max = getMax(n) - 1;
        System.out.println(max);
        int[] res = new int[max];
        for (int i = 1; i <= max; i++) {
            res[i - 1] = i;
        }
        return res;
    }

    /**
     * 递归 快速幂方法
     * 获得10的n次方  n一定是正整数
     *
     * @param n
     * @return
     */
    public int getMax(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        int in = n / 2;  // n为9 a为4
        int re = n % 2;  // b为1
        int a = getMax(in);
        int b = getMax(re);
        int res = a * a * b;
        return res;
    }
}
