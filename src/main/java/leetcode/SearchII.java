package leetcode;

// 搜索旋转排序数组
public class SearchII {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,1,2,3};
        int target = 8;
        SearchII obj = new SearchII();
        System.out.println(obj.search(nums, target));
    }

    /**
     * 还有一种方法是，先使用二分查找找到旋转的下标，
     * 然后再使用二分查找找左半边或者右半边范围内的数
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if(nums[mid] > nums[end]) {  // mid大于end
                if(nums[mid] == target) return mid;
                if(nums[end] == target) return end;
                if(nums[start] == target) return start;
                if(nums[end] > target ){
                    start = mid + 1;
                }else if(nums[end] < target && nums[mid] > target){
                    end = mid - 1;
                }else if(nums[end] < target && nums[mid] < target) {
                    start = mid + 1;
                } else return mid;
            }else if(nums[mid] < nums[end]){  // mid小于end
                if(nums[mid] == target) return mid;
                if(nums[end] == target) return end;
                if(nums[start] == target) return start;
                if(nums[mid] > target){
                    end = mid - 1;
                }else if(nums[mid] < target && nums[end] < target) {
                    end = mid - 1;
                }else if(nums[mid] < target && nums[start] < target) {
                    start = mid + 1;
                }else if(nums[mid] < target && nums[end] > target) {
                    start = mid + 1;
                }
            }else{
                if(nums[mid] == target) return mid;
                else return -1;
            }
        }
        return -1;
    }
}
