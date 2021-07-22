package leetcode;

import java.util.Arrays;

// 合并排序的数组
public class Merge {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 0, 0, 0};
        int[] B = {2, 5, 6};
        int m = 3;
        int n = 3;
        Merge obj = new Merge();
        obj.merge(A, m, B, n);  // 1,2,2,3,5,6
        System.out.println(Arrays.toString(A));
    }

    /**
     * 递归的方法 时间复杂度O(m)
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int[] A, int m, int[] B, int n) {
        if (m == 0) {
            for (int i = 0; i < A.length - m; i++) {
                A[i] = B[i];
            }
            return;
        }
        if (n == 0) return;
        helper(A, m - 1, B, n - 1, A.length - 1);
    }

    public void helper(int[] A, int endA, int[] B, int endB, int flag) {
        if (endB < 0) return;
        if (endA < 0) {
            for (int i = flag; i >= 0; i--) {
                A[i] = B[i];
            }
            return;
        }
        if (A[endA] > B[endB]) {
            A[flag] = A[endA];
            helper(A, --endA, B, endB, --flag);
        } else {
            A[flag] = B[endB];
            helper(A, endA, B, --endB, --flag);
        }
    }
}
