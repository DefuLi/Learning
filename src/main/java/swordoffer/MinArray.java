package swordoffer;

import java.util.Arrays;

// 剑指offer 面试题11 旋转数组的最小数字
public class MinArray {
    public static void main(String[] args) {
        int[] numbers = {3, 4, 5, 1, 2};
        MinArray obj = new MinArray();
        System.out.println(obj.minArray(numbers));
    }

    public int minArray(int[] numbers) {
        if(numbers.length == 1) return numbers[0];
        int start = 0;
        int end = numbers.length - 1;
        // 没有旋转
        if(numbers[start] < numbers[end]) return numbers[start];
        int middle = (end + start) / 2;
        // 无法二分 顺序查找
        if(numbers[start] == numbers[middle] && numbers[middle] == numbers[end]) return Arrays.stream(numbers).min().getAsInt();
        while (start < end) {
            if(numbers[middle] >= numbers[start]) {
                start = middle;
            }else if(numbers[middle] < numbers[start]) {
                end = middle;
            }
            middle = (end + start) / 2;
            if(end - start == 1) return numbers[end];
        }
        return -666;
    }

}
