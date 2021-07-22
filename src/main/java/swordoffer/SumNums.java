package swordoffer;

// 剑指offer 面试题64 求1+2+···+n
public class SumNums {
    public static void main(String[] args) {
        SumNums obj = new SumNums();
        int n = 9;
        System.out.println(obj.sumNums(n));  // 45
    }

    /**
     * 利用&&短路特征
     * 参考链接：https://leetcode-cn.com/problems/qiu-12n-lcof/solution/mian-shi-ti-64-qiu-1-2-nluo-ji-fu-duan-lu-qing-xi-/
     * @param n
     * @return
     */
    public int sumNums(int n) {
        int sum = n;
        boolean flag = (n > 0) && (sum += sumNums(n - 1)) > 0;
        return sum;
    }
}
