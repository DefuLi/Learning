package cleancode.leetcode;

import java.util.Arrays;

/**
 * 爱吃香蕉的珂珂
 *
 * @author Defu Li
 * @since 2021/8/6 23:10
 */
public class LeetCode875 {

    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = Arrays.stream(piles).max().getAsInt();

        while (min <= max) {
            int mid = (min + max) / 2;
            int time = getTimeForSpeed(mid, piles);
            if (time > h) {
                // 速度太慢
                min = mid + 1;
            } else if (time < h) {
                // 速度太快
                max = mid - 1;
            } else {
                // 速度合适，寻找速度最小值，也就是左边界
                max = mid - 1;
            }
        }
        return min;
    }

    public int getTimeForSpeed(int speed, int[] piles) {
        int currTime = 0;
        for (int i = 0; i < piles.length; i++) {
            int temp = piles[i] % speed == 0 ? piles[i] / speed : piles[i] / speed + 1;
            currTime += temp;
        }
        return currTime;
    }
}
