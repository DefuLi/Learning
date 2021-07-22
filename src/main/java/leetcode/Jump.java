package leetcode;

// 跳跃游戏II
public class Jump {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        Jump obj = new Jump();
        System.out.println(obj.jump(nums));
    }

    /**
     * 时间复杂度是O(n)
     * 我们从左边的起点开始跳跃的时候，我们应该跳跃到哪一个点比较合适呢？
     * 显然，每次都跳跃最大长度的话，是不行的。例如对于上面 arr = {2, 3, 1, 1, 4} 这个例子，
     * 刚开 arr[0] = 2，那么我们可以跳到 arr[1] = 3 或者 arr[2] = 1 上，显然，我们跳跃 arr[1] = 3 会更好一点。
     *
     * 接着同样的道理，我们可以从 arr[1] = 3 这个位置开始跳跃，
     * 它可以跳跃到 arr[2] = 1, arr[3] = 1, arr[4] = 4 这三个位置，
     * 显然，我们跳到 arr[4] = 4 这个位置好一点
     *
     * 也就是说，我们要跳跃的那个点，可以使得上一次 + 下一次的跳跃总距离最远。
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int sum = 0;
        int end = 0; // 能跳到的最远距离
        int max = 0; // 下一步可以跳到的最远距离
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            // 更新当前点
            if (i == end) {
                end = max;
                sum++;
            }
        }
        return sum;
    }
}
