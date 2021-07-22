package leetcode;

// 寻找旋转排序数组中的最小值
public class FindMin {
    public static void main(String[] args) {
        int[] nums = {2, 1};
        FindMin obj = new FindMin();
        System.out.println(obj.findMin(nums));
    }

    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums[0] < nums[nums.length - 1]) return nums[0];
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1]) return nums[mid];
            else if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                end = mid - 1;
            }
        }
        return nums[start];
    }
}
