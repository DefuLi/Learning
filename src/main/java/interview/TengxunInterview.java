package interview;

import java.util.HashSet;
import java.util.Set;

/**
 * 打气球
 * n代表可以打n枪
 * m代表有m种气球颜色
 * nums[i]代表第i次打中气球的颜色， 0代表没有打中
 * 求连续打中所有气球颜色的最少次数
 *
 * 例如：
 * n = 12, m = 5
 * nums = {2, 5, 3, 1, 3, 2, 4, 1, 0, 5, 4, 3}
 * 输出：6 是{5, 3, 1, 3, 2, 4}序列
 *
 * 另一种方法是使用滑动窗口，一开始先找到符合条件的窗口，然后往后移动不断的缩小窗口。
 *
 */
public class TengxunInterview {
    public static void main(String[] args) {
        int n = 12;
        int m = 5;
        int[] nums = {2, 5, 3, 1, 3, 2, 4, 1, 0, 5, 4, 3};
        TengxunInterview obj = new TengxunInterview();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(obj.getIndexCount(nums, i, m), min);
        }
        System.out.println(min);
    }

    public int getIndexCount(int[] nums, int index, int m) {
        Set<Integer> set = new HashSet<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.size() == m) {
                end = i - 1;
                break;
            }
            if (nums[i] == 0) {
                set.clear();
                continue;
            }
            set.add(nums[i]);
        }
        set.clear();
        for (int i = end; i >= 0; i--) {
            if (set.size() == m) {
                start = i + 1;
                break;
            }
            set.add(nums[i]);
        }
        int res = end - start + 1;
        return res;
    }
}
