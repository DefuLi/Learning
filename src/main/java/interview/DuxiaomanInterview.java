package interview;

import java.util.*;

public class DuxiaomanInterview {
    public static void main(String[] args) {
        DuxiaomanInterview obj = new DuxiaomanInterview();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(obj.getSum(n, m, a, b));
    }

    /**
     * 度小满
     * 第一题、滑动窗口
     * @param n
     * @param m
     * @param a
     * @param b
     * @return
     */
    public int getSum(int n, int m, int a, int b) {
        if (n < a || m < b) return 0;
        int[][] NMArr = genNMArr(n, m);
        int[] res = new int[(n - 2) * (m - 2)];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int index = 0;
        for (int j = 0; j < m - b + 1; j++) {
            for (int i = 0; i < n - a + 1; i++) {
                for (int k = j; k < j + b; k++) {
                    for (int l = 0; l < i + a; l++) {
                        priorityQueue.add(NMArr[l][k]);
                    }
                }
                res[index++] = priorityQueue.peek();
                priorityQueue.clear();
            }
        }

        return Arrays.stream(res).sum();
    }

    public int[][] genNMArr(int n, int m) {
        int[][] NMArr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                NMArr[i][j] = ((i + 1) * (j + 1)) % 10;
            }
        }
        return NMArr;
    }

/** 第二题、传送门
 * package jvm;
 *
 * import java.util.Scanner;
 *
 * public class Main {
 *     public static void main(String[] args) {
 *         Scanner sc = new Scanner(System.in);
 *         int N = sc.nextInt();
 *         int A = sc.nextInt();
 *         int B = sc.nextInt();
 *         int C = sc.nextInt();
 *         int[] arr = new int[N];
 *         for (int i = 0; i < N; i++) {
 *             arr[i] = sc.nextInt();
 *         }
 *
 *         Main obj = new Main();
 *         System.out.println(obj.helper(arr, 0, 0, A, B, C, N, 0));
 *     }
 *
 *     int option1 = Integer.MAX_VALUE;
 *     int option2 = Integer.MAX_VALUE;
 *     int option3 = Integer.MAX_VALUE;
 *
 *     public int helper(int[] arr, int index, int money, int A, int B, int C, int N, int count) {
 *         if (index == N - 1 || money >= Integer.MAX_VALUE) return money;
 *
 *         option1 = helper(arr, arr[index] - 1, money + A, A, B, C, N, count + 1);
 *
 *         if (arr[index] - 2 >= 0) {
 *             option2 = helper(arr, arr[index] - 2, money + B, A, B, C, N, count + 1);
 *         }
 *
 *         if (arr[index] < N) {
 *             option3 = helper(arr, arr[index], money + C, A, B, C, N, count + 1);
 *         }
 *
 *         return Math.min(Math.min(option1, option2), option3);
 *
 *     }
 *
 *     /**
 *      * def fun(n,a,b,c,ai,cost,mincost,x):
 *      *     if cost > mincost[0]:
 *      *         return
 *      *     if x == n:
 *      *         if cost < mincost[0]:
 *      *             mincost[0] = cost
 *      *         return
 *      *
 *      *
 *      *
 *      *     if ai[x - 1] > 1:
 *      *         ai[x -1] -= 1
 *      *         fun(n,a,b,c,ai,cost + b,mincost,x)
 *      *         ai[x - 1] += 1
 *      *
 *      *
 *      *     if ai[x - 1] < n:
 *      *         ai[x -1] += 1
 *      *         fun(n,a,b,c,ai,cost + c,mincost,x)
 *      *         ai[x - 1] -= 1
 *      *     fun(n,a,b,c,ai,cost + a,mincost,ai[x - 1])
 *      *
 *      * if __name__ == "__main__":
 *      *     n,a,b,c = list(map(int ,input().split()))
 *      *     ai = list(map(int ,input().split()))
 *      *     mincost = [float('inf')]
 *      *     if ai[0] == n:
 *      *         mincost[0] = a
 *      *     elif ai[0] < n:
 *      *         mincost[0] = (n -ai[0])*c + a
 *      *     elif ai[0] > n:
 *      *         mincost[0] = (ai[0] -n)*b + a
 *      *     fun(n,a,b,c,ai,0,mincost,1)
 *      *     print(mincost[0])
 *      */

}
