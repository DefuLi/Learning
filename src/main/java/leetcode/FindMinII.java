package leetcode;

// 寻找旋转排序数组中的最小值 II

/**
 * 我采用的方法是先去除两端重复的数字，然后使用二分法，通过nums[mid]与nums[end]进行比较，
 * 来决定start和end的移动方向，然后加了一些必要的策略。
 *
 * 我看到别人的讲解，发现可以不用先去除两端重复的数字，直接使用二分法，然后通过nums[mid]与nums[end]比较
 * 以此决定start和end的移动方向，然后对于nums[mid]与nums[end]相等时，采用的策略是end--;
 *
 */
public class FindMinII {
    public static void main(String[] args) {
        int[] nums1 = {0, 1, 2, 2, 2, 3, 4, 5};
        int[] nums2 = {1, 2, 2, 2, 3, 4, 5, 0};
        int[] nums3 = {2, 2, 2, 3, 4, 5, 0, 1};
        int[] nums4 = {2, 2, 3, 4, 5, 0, 1, 2};
        int[] nums5 = {3, 4, 5, 0, 1, 2, 2, 2};
        int[] nums6 = {4, 5, 0, 1, 2, 2, 2, 3};
        FindMinII obj = new FindMinII();
        /**
         System.out.println(obj.findMin(nums1));
         System.out.println(obj.findMin(nums2));
         System.out.println(obj.findMin(nums3));
         System.out.println(obj.findMin(nums4));
         System.out.println(obj.findMin(nums5));
         System.out.println(obj.findMin(nums6));
         */
        int[] nums = {10,10,10,-10,-10,-10,-10,-9,-9,-9,-9,-9,-9,-9,-8,-8,-8,-8,-8,-8,-8,-8,-7,-7,-7,-7,-6,-6,-6,-5,-5,-5,-4,-4,-4,-4,-3,-3,-2,-2,-2,-2,-2,-2,-2,-2,-1,-1,-1,-1,-1,0,0,0,0,0,0,0,1,1,1,1,2,2,2,2,2,2,2,3,3,3,4,4,4,5,5,5,5,6,6,6,7,7,7,7,7,8,8,8,8,9,9,9,9,9,9,9,10,10};
        System.out.println(obj.findMin(nums));
    }

    public int findMin(int[] nums) {
        nums = duplicate(nums);  // 经过两端去重
        if (nums.length == 1) return nums[0];  // 只有一个元素
        if (nums[0] < nums[nums.length - 1]) return nums[0];  // 开头就是最小元素
        if (nums[nums.length - 1] < nums[nums.length - 2]) return nums[nums.length - 1];
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (search(nums, mid) == 2) return nums[mid];
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                end = mid - 1;
            }else end = mid;
        }
//        System.out.println(nums[start]);
//        System.out.println(nums[end]);
        return nums[start];
    }

    // 0 左小右大；1 左小右小；2 左大右大(符合)
    public int search(int[] nums, int mid) {
        int start = mid - 1;
        int end = mid + 1;
        int flag1 = 0;
        int flag2 = 0;
        while ((nums[start] == nums[mid] || nums[end] == nums[mid]) && (flag1 == 0 || flag2 == 0)) {
            if (nums[start] == nums[mid]) {
                start--;
                if (start < 0) {
                    start++;
                    flag1 = 1;
                }
            }else flag1 = 1;
            if (nums[end] == nums[mid]) {
                end++;
                if (end > nums.length - 1) {
                    end--;
                    flag2 = 1;
                }
            }else flag2 = 1;
        }
        if (nums[start] < nums[mid] && nums[end] > nums[mid]) return 0;
        if (nums[start] < nums[mid] && nums[end] < nums[mid]) return 1;
        if (nums[start] > nums[mid] && nums[end] > nums[mid]) return 2;
        if (nums[start] == nums[mid] && nums[end] == nums[mid]) return 2;
        if (nums[start] > nums[mid] && nums[end] == nums[mid]) return 2;

        return -1;
    }

    // 对数组去重 仅针对两端
    public int[] duplicate(int[] nums) {
        if (nums.length == 1) return nums;
        // 两端相等 保留左端一个
        if (nums[0] == nums[nums.length - 1]) {
            int temp = nums[0];
            int start = 1;
            int flag1 = 0;
            int flag2 = 0;
            int end = nums.length - 2;
            while ((flag1 == 0 || flag2 == 0) && start < end) {  // flag1 = 1 并且 flag2 = 1跳出循环
                if (nums[start] == temp) start++;
                else flag1 = 1;
                if (nums[end] == temp) end--;
                else flag2 = 1;
            }
            if (start == end) {
                int[] res = {nums[start]};
                return res;
            }
            start--;
            int[] res = new int[end - start + 1];
            for (int i = 0; i < res.length; i++) {
                res[i] = nums[i + start];
            }
            return res;
        }
        // 单端有重复或者两端重复不一致
        if (nums[0] == nums[1] || nums[nums.length - 1] == nums[nums.length - 2]) {
            int start = 1;
            int end = nums.length - 2;
            // 先处理左端重复
            if (nums[0] == nums[1]) {
                while (true) {
                    if (nums[start] == nums[0]) start++;
                    else break;
                }
            }
            if (nums[nums.length - 1] == nums[nums.length - 2]) {
                while (true) {
                    if (nums[end] == nums[nums.length - 1]) end--;
                    else break;
                }
            }
            start--;
            end++;
            int[] res = new int[end - start + 1];
            for (int i = 0; i < res.length; i++) {
                res[i] = nums[i + start];
            }
            return res;
        }
        return nums;
    }
}

