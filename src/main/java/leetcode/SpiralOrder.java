package leetcode;

import java.util.*;

// 螺旋矩阵
public class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        SpiralOrder obj = new SpiralOrder();
        System.out.println(Arrays.toString(obj.spiralOrder(matrix)));
    }

    /**
     * 都是打印螺旋矩阵
     * 一个是Leetcode上的题
     * 一个是剑指offer上的题
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        int k = 0;
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int[] list = new int[matrix.length * matrix[0].length];
        if (matrix.length == 1) {  // 一行
            for (int i : matrix[0]) {
                list[k++] = i;
            }
            return list;
        }
        if (matrix[0].length == 1) {  // 一列
            for (int i = 0; i < matrix.length; i++) {
                list[k++] = matrix[i][0];
            }
            return list;
        }

        int flag = 0;
        int m = matrix.length;  // 行
        int n = matrix[0].length;  // 列
        int i = 0;
        int j = 0;
        boolean[] visited = new boolean[m * n];
        while (k != m * n) {
            if (flag == 0) {
                while (j < n && (i * n + j < m * n) && !visited[i * n + j]) {
                    list[k++] = matrix[i][j];
                    visited[i * n + j] = true;
                    j++;
                }
                flag = 1;
                j--;
                i++;
            } else if (flag == 1) {
                while (i < m && (i * n + j < m * n) && !visited[i * n + j]) {
                    list[k++] = matrix[i][j];
                    visited[i * n + j] = true;
                    i++;
                }
                flag = 2;
                i--;
                j--;
            } else if (flag == 2) {
                while (j >= 0 && (i * n + j < m * n) && !visited[i * n + j]) {
                    list[k++] = matrix[i][j];
                    visited[i * n + j] = true;
                    j--;
                }
                flag = 3;
                j++;
                i--;
            } else if (flag == 3) {
                while (i >= 0 && (i * n + j < m * n) && !visited[i * n + j]) {
                    list[k++] = matrix[i][j];
                    visited[i * n + j] = true;
                    i--;
                }
                flag = 0;
                i++;
                j++;
            }
        }

        return list;
    }
    /**
     public static void main(String[] args) {
     int[][] matrix = {{3}, {2}};
     SpiralOrder obj = new SpiralOrder();
     List<Integer> list = obj.spiralOrder(matrix);
     for (int i = 0; i < list.size(); i++) {
     System.out.println(list.get(i));
     }
     }

     public List<Integer> spiralOrder(int[][] matrix) {
     List<Integer> list = new ArrayList<>();
     Set<String> set = new HashSet<>();
     if (matrix == null || matrix.length == 0) {
     return list;
     }
     if (matrix.length == 1) {  // 一行
     for (int i : matrix[0]) {
     list.add(i);
     }
     return list;
     }
     if (matrix[0].length == 1) {  // 一列
     for (int i = 0; i < matrix.length; i++) {
     list.add(matrix[i][0]);
     }
     return list;
     }

     int flag = 0;
     int m = matrix.length;  // 行
     int n = matrix[0].length;  // 列
     int i = 0;
     int j = 0;
     //        list.add(matrix[i][j]);
     //        set.add(String.valueOf(i) + String.valueOf(j));
     while (list.size() != m * n) {
     if (flag == 0) {
     while (j < n && !set.contains(String.valueOf(i) + String.valueOf(j))) {
     list.add(matrix[i][j]);
     set.add(String.valueOf(i) + String.valueOf(j));
     j++;
     }
     flag = 1;
     j--;
     i++;
     } else if (flag == 1) {
     while (i < m && !set.contains(String.valueOf(i) + String.valueOf(j))) {
     list.add(matrix[i][j]);
     set.add(String.valueOf(i) + String.valueOf(j));
     i++;
     }
     flag = 2;
     i--;
     j--;
     } else if (flag == 2) {
     while (j >= 0 && !set.contains(String.valueOf(i) + String.valueOf(j))) {
     list.add(matrix[i][j]);
     set.add(String.valueOf(i) + String.valueOf(j));
     j--;
     }
     flag = 3;
     j++;
     i--;
     } else if (flag == 3) {
     while (i >= 0 && !set.contains(String.valueOf(i) + String.valueOf(j))) {
     list.add(matrix[i][j]);
     set.add(String.valueOf(i) + String.valueOf(j));
     i--;
     }
     flag = 0;
     i++;
     j++;
     }
     }

     return list;
     }
     **/
}
