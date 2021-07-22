package leetcode;

import java.util.HashSet;
import java.util.Set;

// 快乐数
public class IsHappy {
    public static void main(String[] args) {
        int n = 19;
        IsHappy obj = new IsHappy();
        System.out.println(obj.isHappy(n));

    }
    public boolean isHappy(int n) {
        Set<Integer>  set = new HashSet<>();
        set.add(n);
        int squ = getSqu(n);
        while (squ != 1) {
            if(set.contains(squ)) return false;
            else {
                set.add(squ);
                squ = getSqu(squ);
            }
        }
        return true;
    }

    // 获得数的各位平方和
    public int getSqu(int val) {
        String str = String.valueOf(val);
        char[] chars = str.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            int temp = Integer.parseInt(String.valueOf(chars[i]));
            res+=temp*temp;
        }
        return res;
    }
}
