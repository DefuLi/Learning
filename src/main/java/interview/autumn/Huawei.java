package interview.autumn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 行星碰撞
 */
public class Huawei {
    public static void main(String[] args) {
        int[] arr = {10, 2, -5};
        Huawei obj = new Huawei();
        List<Integer> list = obj.getRes(arr);
        for (Integer item: list) {
            System.out.println(item);
        }
    }

    public List<Integer> getRes(int[] arr) {
        List<Integer> list = new ArrayList<>();
        if(arr == null || arr.length < 1) return list;

        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if(stack.peek() > 0 && arr[i] < 0) {
                // 碰撞
                while (!stack.isEmpty() && stack.peek() > 0) {
                    if(stack.peek() > Math.abs(arr[i])) {
                        break;
                    }else {
                        stack.pop();
                    }
                }
            }

            if(!stack.isEmpty() && (stack.peek() < 0 || (stack.peek() > 0 && arr[i] > 0))) {
                stack.push(arr[i]);
            }
        }
        for (Integer item: stack) {
            list.add(item);
        }
        return list;
    }
}
