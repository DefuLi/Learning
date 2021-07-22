package interview;

import java.util.*;

/**
 * 1、最小公倍数与最大公约数  巧妙的思路：最小公倍数最大的时候就是n*(n-1),此时最大公约数是1
 * 2、还原数列
 * 3、树上上升序列
 */
public class BaiduInterview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        int[][] all = new int[n][1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            int[] temp = {arr[i]};
            all[i] = temp;
            priorityQueue.add(temp);
        }

        int count = 0;
        while (priorityQueue.peek()[0] >= n) {
            int[] poll = priorityQueue.peek();
            poll[0] = poll[0] - n;
            for (int i = 0; i < all.length; i++) {
                if (all[i] != poll) {
                    all[i][0] = all[i][0] + 1;
                }
            }
            int[] temp = priorityQueue.poll();
            priorityQueue.add(temp);
            count++;
        }
        System.out.println(count);
    }
}
    /*    *//**
     * 第一题主函数
     * @param n
     * @return
     *//*
    public int getMax(int n) {
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                max = Math.max(max, getLcm(j, i) - getGcd(j, i));
            }
        }
        System.out.println(max);
        return max;
    }

    *//**
     * 最大公约数
     * @param a
     * @param b
     * @return
     *//*
    public int getGcd(int a, int b) {
        if(a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (a % b != 0) {
            return getGcd(b, a % b);
        }
        return b;
    }

    *//**
     * 最小公倍数
     *
     * @param a
     * @param b
     * @return
     *//*
    public int getLcm(int a, int b) {
        int gcd = getGcd(a, b);
        int lcm = (a * b) / gcd;
        return lcm;
    }*/


