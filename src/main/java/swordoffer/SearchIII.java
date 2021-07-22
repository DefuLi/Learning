package swordoffer;

// 剑指offer 53题-1 在排序数组中查找数字 1
public class SearchIII {
    public static void main(String[] args) {
        SearchIII obj = new SearchIII();
        int[] nums = {1};
        int target = 1;
        System.out.println(obj.search(nums, target));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int before = getBefore(nums, target, 0, nums.length - 1);
        int after = getAfter(nums, target, 0, nums.length - 1);
        if(before > -1 && after > -1) {
            return after - before + 1;
        }
        return 0;
    }

    public int getBefore(int[] nums, int target, int start, int end) {
        if(start > end) {
            return -1;
        }
        int middle = (end - start) / 2 + start;
        if (nums[middle] == target) {
            if ((middle - 1 >= 0 && nums[middle - 1] < target) || middle == 0) {
                return middle;
            } else {
                end = middle - 1;
            }
        } else if (nums[middle] > target) {
            end = middle - 1;
        } else if (nums[middle] < target) {
            start = middle + 1;
        }
        return getBefore(nums, target, start, end);
    }

    public int getAfter(int[] nums, int target, int start, int end) {
        if(start > end) {
            return -1;
        }
        int middle = (end - start) / 2 + start;
        if (nums[middle] == target) {
            if ((middle + 1 <= nums.length - 1 && nums[middle + 1] > target) || middle == nums.length - 1) {
                return middle;
            } else {
                start = middle + 1;
            }
        } else if (nums[middle] > target) {
            end = middle - 1;
        } else if (nums[middle] < target) {
            start = middle + 1;
        }
        return getAfter(nums, target, start, end);
    }
}
