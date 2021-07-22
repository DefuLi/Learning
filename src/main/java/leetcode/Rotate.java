package leetcode;

// 旋转数组
public class Rotate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        Rotate obj = new Rotate();
        obj.rotate(nums, k);
    }

    /**
     * 这个方法的时间复杂度是O(n)，空间复杂度O(1)
     * 首先反转nums数组，然后分别反转索引k之前数组和之后数组
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 这种方法的时间复杂度是O(k*n)
     * 空间复杂度是O(1)
     * 每次旋转，都先用temp变量保存nums[]最后一个元素，
     * 然后每个元素往后移动一位，最后将temp赋值给nums[0]
     * 移动k次
    public void rotate(int[] nums, int k) {
        int len = nums.length;  // 7
        k = k % len;  // 3
        int step = 0;
        while (step < k) {
            int temp = nums[len - 1];
            for (int i = len - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
            step++;
        }
        System.out.println(Arrays.toString(nums));
    }
     */
}
