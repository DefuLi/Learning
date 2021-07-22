package leetcode;

import java.util.Arrays;

// 在排序数组中查找元素的第一个和最后一个位置
public class SearchRange {
    public static void main(String[] args) {
        int[] nums = {2, 2};
        int target = 2;
        SearchRange obj = new SearchRange();
        System.out.println(Arrays.toString(obj.searchRange(nums, target)));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums.length == 0 || nums == null) return res;
        int[] temp = {0, 0};
        if (nums.length == 1 && nums[0] == target) return temp;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                res[0] = findLeft(nums, start, mid, target);
                res[1] = findRigth(nums, mid, end, target);
                return res;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            }
        }
        return res;
    }

    public int findLeft(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] != target) {
                if (nums[mid + 1] == target) return mid + 1;
                start = mid + 1;
            } else {
                if(mid == 0) return 0;
                if (nums[mid - 1] != target) return mid;
                end = mid - 1;
            }
        }
        return start;
    }

    public int findRigth(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] != target) {
                if (nums[mid - 1] == target) return mid - 1;
                end = mid - 1;
            } else {
                if(mid == nums.length - 1) return mid;
                if (nums[mid + 1] != target) return mid;
                start = mid + 1;
            }
        }
        return start;
    }
}
