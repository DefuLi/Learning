package leetcode;

import java.util.HashMap;
import java.util.Map;

// 斐波那契数
public class Fib {
    public static void main(String[] args) {
        int N = 4;
        Fib obj = new Fib();
        System.out.println(obj.fib(N));  // 3
    }

    /**
     * f(n) = f(n - 1) + f(n - 2)
     * 采用HashMap当作缓存 有效的减少重复运算
     * @param N
     * @return
     */
    Map<Integer, Integer> map = new HashMap<>();

    public int fib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        if (map.containsKey(N)) {
            return map.get(N);
        }

        int res = fib(N - 1) + fib(N - 2);
        map.put(N, res);
        return res;
    }
}
