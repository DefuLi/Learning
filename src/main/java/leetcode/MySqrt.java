package leetcode;

// x的平方根
public class MySqrt {
    public static void main(String[] args) {
        MySqrt obj = new MySqrt();
        System.out.println(obj.mySqrt(2147395599));  // 46339
    }

    /**
     * 需要注意int * int 值溢出
     * 可以将int转换为long类型
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if(x == 0) return 0;
        if(x == 1) return 1;
        if(x == 2) return 1;
        int start = 0;
        int end = x;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long product = (long)mid;
            if(product * product > x) {
                end = mid - 1;
            }else if(product * product < x) {
                start = mid + 1;
            }else {
                return mid;
            }
        }
        return start - 1;
    }
}
