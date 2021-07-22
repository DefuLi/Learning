package leetcode;

// 寻找两个有序数组的中位数

/**
 * 参考链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
 * 将nums1[]、nums2[]数组分别进行切割，左半边的个数要和右半边的个数相等，
 * 并且满足左半边的最大值小于等于后半边最小值，对于切割点i和j来说，我们只要找到i的值就行
 * 因为i和j满足某种数组关系。
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        FindMedianSortedArrays obj = new FindMedianSortedArrays();
        System.out.println(obj.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums1 == null) {
            if (nums2.length % 2 == 0) return (double) (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2;
            else return nums2[nums2.length / 2];
        }
        if (nums2.length == 0 || nums2 == null) {
            if (nums1.length % 2 == 0) return (double) (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2;
            else return nums1[nums1.length / 2];
        }
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {  // 保证处理最短的数组
            return findMedianSortedArrays(nums2, nums1);
        }
        int cutMin = 0;
        int cutMax = m;
        while (cutMin <= cutMax) {
            int i = (cutMax - cutMin) / 2 + cutMin;
            int j = (m + n + 1) / 2 - i;
            if(j != 0 && i != m && nums2[j - 1] > nums1[i]) {
                cutMin = i + 1;
            }else if(i != 0 && j != n && nums1[i - 1] > nums2[j]) {
                cutMax = i - 1;
            }else {
                int leftMax = 0;
                if(i == 0) leftMax = nums2[j - 1];
                else if (j == 0) leftMax = nums1[i - 1];
                else leftMax = Math.max(nums1[i - 1], nums2[j - 1]);

                if((m + n) % 2 == 1) return leftMax;  // m + n 是奇数，返回左边最大值

                int rightMin = 0;
                if(i == m) rightMin = nums2[j];
                else if (j == n) rightMin = nums1[i];
                else rightMin = Math.min(nums1[i], nums2[j]);

                return (double)(leftMax + rightMin) / 2;
            }
        }
        return 0.0;
    }
}
