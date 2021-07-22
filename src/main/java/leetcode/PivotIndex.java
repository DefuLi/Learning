package leetcode;

// 寻找数组的中心索引
public class PivotIndex {
    public static void main(String[] args) {
        int[] nums = { };
        PivotIndex obj = new PivotIndex();
        System.out.println(obj.pivotIndex(nums));
    }

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if(nums.length == 0) return -1;
        if(sum - nums[0] == 0) return 0;
        int leftSum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            int pivot = sum - nums[i + 1];
            if (leftSum * 2 == pivot) return i + 1;
        }
        if(sum - nums[nums.length - 1] == 0) return nums.length - 1;
        return -1;
    }
}
