package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 两数之和
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        TwoSum obj = new TwoSum();
        System.out.println(Arrays.toString(obj.twoSum(nums, 18)));
    }

    /**
     * 时间复杂度是O(n)
     * map中存储(nums[i], i)的值，key为nums值，val为序号
     * 使用for循环对nums迭代，用diffVal记录target - nums[i]的值
     * 判断map中的key是否等于diffVal，如果等于，map(key)与i就是两个返回的索引。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        int[] res = new int[2];
        for (int i = 1; i < nums.length; i++) {
            int diffVal = target - nums[i];
            if(map.containsKey(diffVal)) {
                res[0] = map.get(diffVal);
                res[1] = i;
                return res;
            }else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
