package sortalgorithm;

import java.util.Arrays;

/**
 * 快速排序算法
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 3, 4, 999};
        QuickSort obj = new QuickSort();
        obj.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 分区
     * 对每一个数组进行分化的代码如下：
     * 初始化pivot为数组第一个元素；
     * 只要left还小于right就进行循环；
     * 外层循环内部如下：
     * 先从右边找一个比枢轴元素小的元素；
     * 将当前left所指元素赋值为找到的元素；
     * 再从左边找一个比枢轴元素大的元素；
     * 将当前right所指元素赋值为找到的元素；
     * 当left和right相等将枢轴元素赋值在此。
     * 最后返回中间元素的索引。
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    public void quickSort(int[] arr, int left, int right) {
        if (arr == null || arr.length < 1) return;
        int pivotIndex = partition(arr, left, right);
        if (pivotIndex > left) quickSort(arr, left, pivotIndex - 1);
        if (pivotIndex < right) quickSort(arr, pivotIndex + 1, right);
    }
}
