package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 把数组排成最小的数
public class MinNumber {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        MinNumber obj = new MinNumber();
        System.out.println(obj.minNumber(nums));  // 3033459
    }

    /**
     * 定义一种新的排序规则
     * 字符串 如果o1 + o2 > o2 + o1 那么排序结果应该是 o2, o1
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(String.valueOf(nums[i]));
        }

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String o12 = o1 + o2;
                String o21 = o2 + o1;
                return o12.compareTo(o21);
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i));
        }
        return stringBuilder.toString();
    }
}
