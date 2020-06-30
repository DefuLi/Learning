package leetcode;

/**
 * 搜索插入位置
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1, 3};
        int target = 3;
        SearchInsert obj = new SearchInsert();
        System.out.println(obj.searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0 || nums == null) return 0;
        int start = 0;
        int end = nums.length - 1;
        int middle;

        if (nums[start] > target) return 0;
        if (nums[end] < target) return end + 1;
        while (true) {
            middle = (end - start) / 2 + start;
            if (nums[middle] == target) return middle;
            else if (nums[middle] > target && nums[middle - 1] < target) {
                return middle;
            } else if (nums[middle] > target) {
                end = middle;
            } else if (nums[middle] < target && nums[middle + 1] > target) {
                return middle + 1;
            } else {
                start = middle + 1;
            }
        }
    }
}
