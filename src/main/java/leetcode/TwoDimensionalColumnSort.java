package leetcode;

import java.util.Arrays;
import java.util.Comparator;

// 按列排序
// 第一列如果值相同 按第二列大小排序 后面同理
public class TwoDimensionalColumnSort {
    public static void main(String[] args) {
        int[][] a = {{5, 0, 0}, {5, 0, 2}, {5, 2, 0}};
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int len = o1.length;
                for (int i = 0; i < len; i++) {
                    if (o1[i] == o2[i]) continue;
                    else return o2[i] - o1[i];
                }
                return 0;
            }
        });

        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }
}
