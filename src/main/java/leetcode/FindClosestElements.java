package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 找到 K 个最接近的元素
public class FindClosestElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 7};
        int k = 4;
        int x = 6;
        FindClosestElements obj = new FindClosestElements();
        List<Integer> list = obj.findClosestElements(arr, k, x);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * 我的方法：先用二分法找到index索引，arr[index]最接近x。
     * 然后设置两个指针flagLeft = index - 1; flagRight = index + 1;
     * 根据指向的值与x的距离，对flagLeft--或flagRight++;
     * 最后要对list进行升序排序，这一步时间复杂度O(nlogn) 不划算！
     *
     * 一个好方法是前部分找index和我方法一样，采用二分法。
     * 找到index后设置flagLeft = index - k - 1; flagRight = index + k - 1;
     * 这个意思是在[flagLeft, flagRight]之间必然有k个有序的数是符合的。
     * 然后使用策略增大flagLeft，或者减小flagRight，目的是缩小范围，直至只有k个。
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        // x值小于等于arr[]中最小值
        if (x <= arr[0]) {
            for (int i = 0; i < k; i++) {
                list.add(arr[i]);
            }
            return list;
        }
        // x值大于等于arr[]中最大值
        if (x >= arr[arr.length - 1]) {
            for (int i = arr.length - k; i < arr.length; i++) {
                list.add(arr[i]);
            }
            return list;
        }
        int start = 0;
        int end = arr.length - 1;
        int index = 0;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (arr[mid] == x) {
                index = mid;
                break;
            } else if (arr[mid] > x && arr[mid - 1] <= x) {
                if (Math.abs(arr[mid] - x) > Math.abs(arr[mid - 1] - x)) {
                    index = mid - 1;
                } else {
                    index = mid;
                }
                break;
            } else if (arr[mid] < x && arr[mid + 1] >= x) {
                if (Math.abs(arr[mid] - x) > Math.abs(arr[mid + 1] - x)) {
                    index = mid + 1;
                } else {
                    index = mid;
                }
                break;
            } else if (arr[mid] > x && arr[mid - 1] > x) {
                end = mid;
            } else if (arr[mid] < x && arr[mid + 1] < x) {
                start = mid;
            }
        }
        int flagLeft = index - 1;
        int flagRigth = index + 1;
        list.add(arr[index]);
        while (list.size() < k) {
            if (Math.abs(arr[flagLeft] - x) < Math.abs(arr[flagRigth] - x)) {
                list.add(arr[flagLeft]);
                flagLeft--;
            } else if (Math.abs(arr[flagLeft] - x) > Math.abs(arr[flagRigth] - x)) {
                list.add(arr[flagRigth]);
                flagRigth++;
            } else if (Math.abs(arr[flagLeft] - x) == Math.abs(arr[flagRigth] - x)) {
                list.add(arr[flagLeft]);
                flagLeft--;
            }
            int size = list.size();
            if (flagLeft < 0) {
                for (int i = flagRigth; i < flagRigth + k - size; i++) {
                    list.add(arr[i]);
                }
                Collections.sort(list);
                return list;
            }

            if (flagRigth > arr.length - 1) {
                for (int i = flagLeft; i > flagLeft - k + size; i--) {
                    list.add(arr[i]);
                }
                Collections.sort(list);
                return list;
            }
        }
        Collections.sort(list);
        return list;
    }
}
