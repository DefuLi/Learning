package leetcode;

import java.util.Stack;

// 目标和
public class FindTargetSumWays {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        FindTargetSumWays find = new FindTargetSumWays();
        System.out.println(find.findTargetSumWays(nums, S));
    }

    public int findTargetSumWays(int[] nums, int S) {
        Stack<kvClass> stack = new Stack<>();
        stack.push(new kvClass(S, 0));
        int res = 0;
        while (!stack.isEmpty()) {
            kvClass head = stack.pop();
            if (head.k == 0 && head.v == nums.length) {
                res++;
            }
            if (head.v < nums.length) {
                stack.push(new kvClass(head.k + nums[head.v], head.v + 1));
                stack.push(new kvClass(head.k - nums[head.v], head.v + 1));
            }

        }
        return res;
    }

    /**
     int res = 0;
     public int findTargetSumWays(int[] nums, int S) {
     //        int res = 0;
     int start = 0;
     return helper(nums, S, start, res);
     }

     public int helper(int[] nums, int S, int start, int res) {
     if (start >= nums.length) {
     if (S == 0) res = res + 1;
     return res;
     }
     res = helper(nums, S + nums[start], start + 1, res);
     res = helper(nums, S - nums[start], start + 1, res);
     return res;
     }
     **/
}

class kvClass {
    public int k;
    public int v;

    public kvClass(int k, int v) {
        this.k = k;
        this.v = v;
    }
}