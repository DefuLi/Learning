package swordoffer;

import java.util.Arrays;

// 剑指offer 面试题66 构建乘积数组
public class ConstructArr {
    public static void main(String[] args) {
        ConstructArr obj = new ConstructArr();
        int[] a = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(obj.constructArr(a)));
    }

    /**
     * 构建c[] d[]
     * 累乘得到c[] d[]具体的值
     * 参考剑指offer题解
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        int[] res = new int[a.length];
        if(a.length == 0) return res;
        int[] c = new int[a.length];
        int[] d = new int[a.length];
        c[0] = 1;
        d[a.length - 1] = 1;
        for (int i = 1; i < a.length; i++) {
            c[i] = c[i - 1] * a[i - 1];
            d[a.length - i - 1] = d[a.length - i] * a[a.length - i];
        }
        for (int i = 0; i < a.length; i++) {
            res[i] = c[i] * d[i];
        }
        return res;
    }
}
