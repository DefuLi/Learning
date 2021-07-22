package swordoffer;

// 剑指offer 面试题65 不用加减乘除做加法
public class Add {
    public static void main(String[] args) {
        int a = 5;
        int b = 7;
        Add obj = new Add();
        System.out.println(obj.add(a, b));  // 12
    }

    /**
     * 利用位运算
     * 先计算xor
     * 再计算and
     * 递归
     *
     * 参考链接：https://www.bilibili.com/video/BV1K741127Ax?from=search&seid=15229023264236857766
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        if ((a & b) == 0) return a | b;

        int xor = a ^ b;
        int and = (a & b) << 1;
        int res = add(xor, and);
        return res;
    }

}
