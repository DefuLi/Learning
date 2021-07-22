package leetcode;

import java.util.HashMap;
import java.util.Map;

// 爬楼梯
public class ClimbStairs {
    public static void main(String[] args) {
        int n = 3;
        ClimbStairs obj = new ClimbStairs();
        System.out.println(obj.climbStairs(n));  // 3
    }

    Map<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if(map.containsKey(n)) return map.get(n);

        int res = climbStairs(n - 1) + climbStairs(n - 2);
        map.put(n, res);
        return res;
    }
}
