package cleancode.leetcode;

import org.openxmlformats.schemas.drawingml.x2006.chart.STRadarStyle;

import java.util.Arrays;

/**
 * 最大子矩阵
 *
 * @author Defu Li
 * @since 2021/8/25 23:10
 */
public class LeetCode1724 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 5}, {-1, 2, -4, -3}, {0, -1, 7, 6}};
        LeetCode1724 obj = new LeetCode1724();
        obj.getMaxMatrix(matrix);
    }

    public int[] getMaxMatrix(int[][] matrix) {
        int[] position = new int[4];
        int row = matrix.length;
        int col = matrix[0].length;
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < row; i++) {
            int sum[] = new int[matrix[i].length];
            for (int j = i; j < row; j++) {
                int dp = 0;
                int startCol = 0;
                for (int k = 0; k < col; k++) {
                    sum[k] += matrix[j][k];
                    dp += sum[k];
                    if (dp > maxValue) {
                        maxValue = dp;
                        position[0] = i;
                        position[1] = startCol;
                        position[2] = j;
                        position[3] = k;
                    }
                    if (dp < 0) {
                        startCol = k + 1;
                        dp = 0;
                    }
                }
            }
        }
        return position;
    }
}
