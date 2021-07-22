package interview;

import java.util.Arrays;

/**
 * 1、打扑克
 * dfs
 * 参考链接：https://blog.csdn.net/Brave_man_O/article/details/104988271
 * <p>
 * 2、最长高昂旋律
 * dp
 */
public class AlibabaInterview {
    public static void main(String[] args) {
        /** 第一题的调用
         int[] nums = {1, 1, 1, 2, 2, 2, 2, 2, 1, 1};  // A 2 3 4 5 6 7 8 9
         AlibabaInterview obj = new AlibabaInterview();
         System.out.println(obj.getCount(nums));
         */

        // 第二题调用
        String[] strings = {"aaa", "bcd", "yyyz", "yz"};
        AlibabaInterview obj = new AlibabaInterview();
        System.out.println(obj.getLongest(strings));  // 11
    }

    /**
     * 最长高昂旋律
     * dp动态规划
     * dp[i] 代表最后的结果中第i个单词做为旋律的结尾 整个旋律的长度
     *
     * @param strings
     * @return
     */
    public int getLongest(String[] strings) {
        Arrays.sort(strings);
        int[] dp = new int[strings.length];
        dp[0] = strings[0].length();
        for (int i = 0; i < strings.length; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                if (j < strings.length && strings[j].charAt(0) > strings[i].charAt(strings[i].length() - 1) && dp[i] + strings[j].length() > dp[j]) {
                    dp[j] = dp[i] + strings[j].length();
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();  // 获得最大值
    }


    /**
     * 打扑克
     * dfs
     * check用来检查是否还有牌可以打
     *
     * @param nums
     * @return
     */
    public int getCount(int[] nums) {
        return dfs(nums, 0);
    }

    int min = Integer.MAX_VALUE;

    public int dfs(int[] nums, int count) {
        if (check(nums)) {  // 还有牌可以打
            int i = 0;  // 代表index = i处有牌
            while (nums[i] == 0) {
                i++;
            }
            if (nums[i] > 0) {  // 单牌
                nums[i]--;
                dfs(nums, count + 1);
                nums[i]++;
            }
            if (nums[i] > 1) {  // 对子
                nums[i] -= 2;
                dfs(nums, count + 1);
                nums[i] += 2;
            }
            // 5连
            if (i + 5 <= nums.length && nums[i] > 0 && nums[i + 1] > 0 && nums[i + 2] > 0 && nums[i + 3] > 0 && nums[i + 4] > 0) {
                for (int j = 0; j < 5; j++) {
                    nums[i + j]--;
                }
                dfs(nums, count + 1);
                for (int j = 0; j < 5; j++) {
                    nums[i + j]++;
                }
            }
            // 3对
            if (i + 3 <= nums.length && nums[i] > 1 && nums[i + 1] > 1 && nums[i + 2] > 1) {
                for (int j = 0; j < 3; j++) {
                    nums[i + j] -= 2;
                }
                dfs(nums, count + 1);
                for (int j = 0; j < 3; j++) {
                    nums[i + j] += 2;
                }
            }

        } else {  // 无牌可打 返回count
            if (count < min) {
                min = count;
            }
        }
        return min;
    }

    public boolean check(int[] nums) {
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                flag = true;
                return flag;
            }
        }
        return flag;
    }
}
