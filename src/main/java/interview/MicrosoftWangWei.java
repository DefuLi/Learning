package interview;

import java.util.Arrays;

/**
 * @author Defu Li
 * @date 2021/3/28 9:41
 */
public class MicrosoftWangWei {
    public static void main(String[] args) {
        int[] A = {5, 2, 4, 6, 3, 7};
        MicrosoftWangWei obj = new MicrosoftWangWei();
        System.out.println(obj.getMin(A));
    }

    public int getMin(int[] A) {
        int len = A.length;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= len - 4; i++) {
            for (int j = i + 2; j <= len - 2; j++) {
                int sum = A[i] + A[j];
                if(sum < min) {
                    min = sum;
                }
            }
        }
        return min;
    }


}
