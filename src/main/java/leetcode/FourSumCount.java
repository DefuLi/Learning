package leetcode;

import java.util.HashMap;
import java.util.Map;

// 四数相加Ⅱ
public class FourSumCount {
    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};
//        int[] A = {1};
//        int[] B = {-1};
//        int[] C = {0};
//        int[] D = {1};
        FourSumCount obj = new FourSumCount();
        System.out.println(obj.fourSumCount(A, B, C, D));
    }

    /**
     * 计算A和B数组两两相乘结果存入HashMap,
     * 计算C和D数组两两相乘结果的相反数，
     * 当作key去HashMap中查找。
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0) return 0;
        Map<Integer, Integer> mapAB = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                mapAB.put(sum, mapAB.getOrDefault(sum, 0) + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = -C[i] - D[j];
                if(mapAB.containsKey(sum)){
                    res += mapAB.get(sum);
                }
            }
        }
        return res;
    }

    /**
     * 运行正确，但超出时间限制。
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
        if (A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int sum = C[i] + entry.getKey();
                map1.put(sum, map1.getOrDefault(sum, 0) + entry.getValue());
            }
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < D.length; i++) {
            for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
                int sum = D[i] + entry.getKey();
                map2.put(sum, map2.getOrDefault(sum, 0) + entry.getValue());
            }
        }
        return map2.containsKey(0) ? map2.get(0) : 0;
    }
}
