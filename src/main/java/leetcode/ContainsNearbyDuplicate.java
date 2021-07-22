package leetcode;

import java.util.HashMap;
import java.util.Map;

// 存在重复元素Ⅱ
public class ContainsNearbyDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        ContainsNearbyDuplicate obj = new ContainsNearbyDuplicate();
        System.out.println(obj.containsNearbyDuplicate(nums, k));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length == 0 || nums.length == 1) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {  // 已存在
                if(i - map.get(nums[i]) <= k) {  // 符合条件
                    return true;
                }else {  // 存在两个值相同，但索引差值大于k
                    map.put(nums[i], i);
                }
            }else {  // map中目前没有存在
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
