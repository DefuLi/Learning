package swordoffer;

// 剑指offer 面试题04 二维数组中的查找
public class FindNumberIn2DArray {
    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15},
                            {2, 5, 8, 12, 19},
                            {3, 6, 9, 16, 22},
                            {10, 13, 14, 17, 24},
                            {18, 21, 23, 26, 30}};
        FindNumberIn2DArray obj = new FindNumberIn2DArray();
        System.out.println(obj.findNumberIn2DArray(matrix, 5));
    }

    /**
     * 从右上角开始比对
     * 淘汰不符合的行或列
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int r = 0;
        int c = matrix[0].length - 1;
        while (r < matrix.length && c >= 0) {
            if(matrix[r][c] > target) {
                c--;
            }else if(matrix[r][c] < target) {
                r++;
            }else return true;
        }
        return false;
    }
}
