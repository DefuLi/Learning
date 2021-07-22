package leetcode;

// 二分查找
public class Search {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        Search obj = new Search();
        System.out.println(obj.search(nums, 0));
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0 || nums == null) return -1;
        if (target < nums[0] || target > nums[nums.length - 1]) return -1;
        if(nums[0] == target) return 0;
        if(nums[nums.length - 1] == target) return nums.length - 1;

        int mid = nums.length / 2;
        int end = nums.length - 1;
        int start = 0;
        while (mid > start && mid < end) {
            if(nums[mid] < target) {
                start = mid;
                mid = ((end - mid + 1) / 2) + mid;
            }else if (nums[mid] > target) {
                end = mid;
                mid = ((mid - start + 1) / 2) + start;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
