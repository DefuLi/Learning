package swordoffer;

// 剑指offer 面试题62 圆圈中最后剩下的数字
public class LastRemaining {
    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        LastRemaining obj = new LastRemaining();
        System.out.println(obj.lastRemaining(n, m));  // 3
    }

    /**
     * 有两种方法可以解决
     * 1、使用链表，循环链表，用Java自带的LinkedList也可以，或者自己实现一个
     * 2、使用数学规律
     * 参考链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }
}
