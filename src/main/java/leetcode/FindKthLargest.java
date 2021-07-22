package leetcode;

// 数组中的第K个最大元素
public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums = {2,1};
        int k = 2;
        FindKthLargest obj = new FindKthLargest();
        System.out.println(obj.findKthLargest(nums, k));  // 4
    }

    // 交换
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int select(int[] nums, int start, int end, int currindex) {
        int currval = nums[currindex];
        int tempStart = start;
        int tempEnd = end;
        swap(nums, currindex, end);  // 先把currindex和end元素互换
        end--;
        while (start < end) {
            if (nums[start] > currval) {
                if(nums[end] <= currval) {
                    swap(nums, start, end);
                    end--;
                    start++;
                }else end--;
            } else start++;
        }
        if(nums[start] > nums[tempEnd]) swap(nums, start, tempEnd);
        else swap(nums, ++start, tempEnd);
        return start;
    }

    public int helper(int[] nums, int start, int end, int k) {
        if(start == end) return nums[start];
        int index = select(nums, start, end, start);
        if (index == k) return nums[k];
        else if (index < k) {
            return helper(nums, index + 1, end, k);
        } else {
            return helper(nums, start, index - 1, k);
        }

    }

    /**
     * 使用的是快速选择的算法 分治
     * 先选择一个点，将小于该点值的数放在该点的左边  大于等于该点值的数放在右边 这就是select函数做的事
     * select函数返回的值是该点伪排序后的index  注意不是真排序，因为只是分区了而已
     * 如果select的index和我们要找的k位置一样，说明找到了 返回即可
     * 如果index大于了我们要找的k，说明了我们要找的k在start index-1的区间，递归即可。
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        if(len == 1) return nums[0];
        int res = helper(nums, 0, len - 1, len - k);
        return res;
    }
}
