package sortalgorithm;

import java.util.Arrays;

/**
 * 归并排序算法
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 6, 1, 8};
        MergeSort obj = new MergeSort();
        int[] res = obj.mergeSort(arr);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 合并两个数组
     * 创建一个大数组，定义两个指针分别指向left和right子数组
     * 谁小谁就赋值到大数组中
     *
     * @param left
     * @param right
     * @return
     */
    public int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < res.length; i++) {
            if (leftIndex >= left.length) {
                res[i] = right[rightIndex++];
            } else if (rightIndex >= right.length) {
                res[i] = left[leftIndex++];
            } else if (left[leftIndex] > right[rightIndex]) {
                res[i] = right[rightIndex++];
            } else if (left[leftIndex] <= right[rightIndex]) {
                res[i] = left[leftIndex++];
            }
        }
        return res;
    }

    public int[] mergeSort(int[] arr) {
        if (arr.length < 2) return arr;
        int middle = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        int[] leftArr = mergeSort(left);
        int[] rightArr = mergeSort(right);
        return merge(leftArr, rightArr);
    }
}
