package leetcode;

// 有效的完全平方数
public class IsPerfectSquare {
    public static void main(String[] args) {
        int num1 = 16;
        int num2 = 14;
        IsPerfectSquare obj = new IsPerfectSquare();
        System.out.println(obj.isPerfectSquare(num1));
        System.out.println(obj.isPerfectSquare(num2));
    }

    public boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        if (num == 0 || num == 1) return true;
        if (num == 2) return false;
        int start = 0;
        int end = num / 2;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            long product = (long) mid * mid;
            long right = (long) (mid + 1) * (mid + 1);
            long left = (long) (mid - 1) * (mid - 1);
            if ((int) product == num) {
                return true;
            } else if (product < num && right > num) {
                return false;
            } else if (product > num && left < num) {
                return false;
            } else if (product < num && right <= num) {
                start = mid + 1;
            } else if(product > num && left >= num) {
                end = mid - 1;
            }
        }
        return false;
    }
}
