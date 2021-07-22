package leetcode;

// 最大连续1的个数
public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1};
        FindMaxConsecutiveOnes obj = new FindMaxConsecutiveOnes();
        System.out.println(obj.findMaxConsecutiveOnes(nums));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int flag = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1 && flag == 0){
                start = i;
                flag = 1;
            }
            if(nums[i] == 0 && flag == 1){
                if(res < i - start) {
                    res = i - start;
                }
                flag = 0;
            }
            if(i == nums.length - 1 && flag == 1){
                if(res < i - start + 1){
                    res = i - start + 1;
                }
            }

        }
        return res;
    }
}
