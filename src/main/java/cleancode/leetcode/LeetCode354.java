package cleancode.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 俄罗斯套娃信封问题
 *
 * @author Defu Li
 * @since 2021/8/23 23:30
 */
public class LeetCode354 {
    public static void main(String[] args) {
        int[][] envelopes = {{2, 3}, {6, 7}, {5, 4}, {5, 5}};
        LeetCode354 obj = new LeetCode354();
        System.out.println(obj.maxEnvelopes(envelopes));
    }

    public int maxEnvelopes(int[][] envelopes) {
        sortArr(envelopes);
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        int[] col2 = new int[dp.length];
        for (int i = 0; i < dp.length; i++) {
            col2[i] = envelopes[i][1];
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (col2[j] < col2[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public void sortArr(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });
    }
}
