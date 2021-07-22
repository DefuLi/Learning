package leetcode;

import java.util.Arrays;
import java.util.Collections;

// 旋转数组的最小数字
public class MinNumberInRotateArray {
    public static void main(String[] args) {
        int[] array = {1, 0, 1};
        MinNumberInRotateArray minNumberInRotateArray = new MinNumberInRotateArray();
        int output = minNumberInRotateArray.fun2(array);
        System.out.println(output);
    }

    // 通过Collections.min方法可以直接选择最小值
    public int fun1(int[] array){
        if(array.length == 0){
            return 0;
        }
        Integer[] integers = new Integer[array.length];
        for (int i=0;i<array.length;i++){
            integers[i] = array[i];
        }

        return Collections.min(Arrays.asList(integers));
    }

    // 使用递归 二分法
    public int fun2(int[] array){
        if(array.length == 0){
            return 0;
        }
        if(array.length == 1){
            return array[0];
        }
        if(array.length == 2){
            if (array[0] > array[1]){
                return array[1];
            }else {
                return array[0];
            }
        }
        int middle_index = array.length / 2;
        if(array[middle_index] > array[array.length-1]){
            return fun2(Arrays.copyOfRange(array, middle_index, array.length));
        }
        else if(array[middle_index] < array[array.length-1]){
            return fun2(Arrays.copyOfRange(array, 0, middle_index+1));
        }
        else if(array[middle_index] == array[array.length-1]){
            return fun2(Arrays.copyOfRange(array, 0, array.length-1));
        }

        return -1;
    }
}
