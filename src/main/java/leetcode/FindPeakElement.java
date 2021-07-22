package leetcode;

// 寻找峰值
public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {3, 4, 3, 2, 1};
        FindPeakElement obj = new FindPeakElement();
        System.out.println(obj.findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums[1] < nums[0]) return 0;
        if (nums[nums.length - 2] < nums[nums.length - 1]) return nums.length - 1;
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            } else if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
                if(nums[start] > nums[start+1] && nums[start] > nums[start - 1]) return start;
            } else if (nums[mid] < nums[mid - 1]) {
                end = mid - 1;
                if(nums[end] > nums[end + 1] && nums[end] > nums[end - 1]) return end;
            }
        }
        return 0;
    }
}
