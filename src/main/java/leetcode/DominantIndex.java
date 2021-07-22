package leetcode;

// 至少是其他数字两倍大的最大数
public class DominantIndex {
    public static void main(String[] args) {
        int[] nums1 = {3, 6, 1, 0};
        int[] nums2 = {1, 2, 3, 4};
        DominantIndex obj = new DominantIndex();
        System.out.println(obj.dominantIndex(nums1));
        System.out.println(obj.dominantIndex(nums2));
    }

    public int dominantIndex(int[] nums) {
        if(nums.length == 1) return 0;
        int max = nums[0];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        if(index == 0) nums[index] = nums[index+1];
        else nums[index] = nums[index-1];
        int maxSecond = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(maxSecond < nums[i]) maxSecond = nums[i];
        }
        if(max >= maxSecond*2) return index;
        return -1;
    }
}
