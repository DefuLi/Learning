package cleancode.leetcode;

import java.util.Arrays;

/**
 * 在D天内送达包裹的能力
 *
 * @author Defu Li
 * @since 2021/8/6 23:40
 */
public class LeetCode1011 {

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        LeetCode1011 obj = new LeetCode1011();
        System.out.println(obj.shipWithinDays(weights, days));
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while (left <= right) {
            int mid = (left + right) / 2;
            int currDay = computeTime(weights, mid);
            if (currDay > days) {
                // 当前的运载能力小了
                left = mid + 1;
            } else if (currDay < days) {
                // 当前运载能力大了
                right = mid - 1;
            } else {
                // 当前运载能力适合，但是需要找到最小的运载能力，收缩右边界
                right = mid - 1;
            }
        }
        return left;
    }

    public int computeTime(int[] weights, int minWeight) {
        int weightsSum = 0;
        int daysSum = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weightsSum + weights[i] > minWeight) {
                daysSum++;
                weightsSum = 0;
                weightsSum += weights[i];
                continue;
            }
            weightsSum += weights[i];
        }
        return daysSum + 1;
    }
}
