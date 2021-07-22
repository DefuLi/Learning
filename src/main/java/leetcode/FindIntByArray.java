package leetcode;

// 二维数组的查找
public class FindIntByArray {

    public static void main(String[] args) {
        FindIntByArray findIntByArray = new FindIntByArray();
        int[][] array = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}};
        // System.out.println(array.length); // 行
        // System.out.println(array[0].length);  // 列
        boolean result = findIntByArray.Find(18, array);
        System.out.println(result);
    }

    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int row = 0;
        int col = array[0].length - 1;
        while (row < array.length && col >= 0) {
            if (array[row][col] < target) {
                row++;
            } else if (array[row][col] > target) {
                col--;
            } else if (array[row][col] == target) {
                return true;
            }
        }
        return false;
    }
}
