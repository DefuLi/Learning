package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 三角形最小路径和
public class MinimumTotal {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(2));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(3, 4));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(6, 5, 7));
        List<Integer> list4 = new ArrayList<>(Arrays.asList(4, 1, 8, 3));
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);

        MinimumTotal obj = new MinimumTotal();
        System.out.println(obj.minimumTotal(triangle));  // 11
    }

    /**
     * 状态转移方程为：
     * dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0 || triangle == null) return 0;
        int size = triangle.size();
        int[][] dp = new int[size][size];  // 用于存储每个i,j位置最小路径和
        for (int i = 0; i < triangle.get(size - 1).size(); i++) {
            dp[size - 1][i] = triangle.get(size - 1).get(i);
        }
        for (int i = size - 2; i >= 0 ; i--) {  // 从下往上
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
