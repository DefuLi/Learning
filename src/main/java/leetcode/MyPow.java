package leetcode;

// Pow(x, n)
public class MyPow {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = -2;
        MyPow obj = new MyPow();
        System.out.println(obj.myPow(x, n));
    }

    /**
     * 递归
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        if(n == 1) return x;
        if(n == -1) return 1 / x;
        double half = myPow(x, n / 2);
        double rem = myPow(x, n % 2);
        return half * half * rem;
    }
}
