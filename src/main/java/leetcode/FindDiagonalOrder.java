package leetcode;

import java.util.Arrays;

// 对角线遍历
public class FindDiagonalOrder {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        FindDiagonalOrder obj = new FindDiagonalOrder();
        int[] res = obj.findDiagonalOrder(matrix);
        System.out.println(Arrays.toString(res));
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return new int[0];
        }
        if(matrix.length == 1){  // 仅为一行
            return matrix[0];
        }
        int [] temp = new int[matrix.length];
        if(matrix[0].length == 1){  // 仅为一列
            for (int i = 0; i < matrix.length; i++) {
                temp[i] = matrix[i][0];
            }
            return temp;
        }
        int i = 0;
        int j = 0;
        int m = matrix.length;  // 行
        int n = matrix[0].length;  // 列
        int[] res = new int[m * n];
        for (int k = 0; k < m * n; k++) {
            res[k] = matrix[i][j];
            if ((i + j) % 2 == 0) {  // 上
                if (i == 0 && j < n - 1) {
                    j++;
                } else if (i < m -1 && j == n - 1) {
                    i++;
                } else {
                    i--;
                    j++;
                }
            } else {  // 下
                if (i < m -1 && j == 0) {
                    i++;
                } else if (i == m - 1 && j < n -1 ) {
                    j++;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return res;
    }
}
