package interview;

import java.util.*;

public class KuaishouInterview {
    public static void main(String[] args) {
        /** 第一题
         KuaishouInterview obj = new KuaishouInterview();
         Scanner sc = new Scanner(System.in);
         String str = sc.nextLine();
         int[] res = obj.getCount(str);
         System.out.println(res[0] + " " + res[1] + " " + res[2]);
         */

        /** 第二题
         KuaishouInterview obj = new KuaishouInterview();
         Scanner sc = new Scanner(System.in);
         int R = sc.nextInt();
         int N = sc.nextInt();
         System.out.println(Arrays.toString(obj.GetPowerFactor(R, N)));
         */

        /** 第三题
         KuaishouInterview obj = new KuaishouInterview();
         int[] a = {8, 9, 7};
         int[] b = {5, 8, 3};
         System.out.println(Arrays.toString(obj.WaitInLine(a, b)));
         */

        /** 第四题
        char[][] pos = {{'*', '.', '*', '*', '.'},
                {'*', '.', '*', '*', '*'}, {'*', '.', '*', '*', '.'}};
        KuaishouInterview obj = new KuaishouInterview();
        System.out.println(obj.GetMaxStaffs(pos));
         */
    }

    /**
     * 第一题、括号统计
     * 全部通过
     *
     * 给定一个数学表达式，求完整的括号数、剩余的左括号数、剩余的右括号数
     * 表达式可以不符合要求
     * 3*4+(2-3)()(((())(
     * 返回4 2 0
     * @param str
     * @return
     */
    public int[] getCount(String str) {
        int[] res = new int[3];
        if (str == null || str.length() == 0) return res;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                if (stack.isEmpty()) stack.push(str.charAt(i));  // stack为空
                else {  // stack不为空
                    if (stack.peek() == '(' && str.charAt(i) == ')') {  // res[0]++
                        res[0]++;
                        stack.pop();
                    } else stack.push(str.charAt(i));

                }
            }
        }
        while (!stack.isEmpty()) {
            if (stack.pop() == '(') res[1]++;
            else res[2]++;
        }
        return res;
    }

    /**
     * 第二题、无重复幂因子的N进制完美数之和
     * 全部通过
     *
     * 给定R和N
     * 比如39和3
     * 因为39 = 3^1 + 3^2 + 3^3 N的幂不重复，并且相加等于R，那么返回N的幂 [1 2 3]
     *
     * 比如33和3
     * 因为33 = 3^1 + 3^1 + 3^3 N的幂有重复，返回空[]
     *
     * 比如1和3
     * 因为1 = 3^0 N的幂不重复，返回[0]
     * @param R
     * @param N
     * @return
     */
    public int[] GetPowerFactor(int R, int N) {
        int M = getMaxM(R, N);
        int[] arr = new int[M + 1];
        for (int i = 0; i < M + 1; i++) {
            arr[i] = i;
        }
        ArrayList<ArrayList<Integer>> subArr = getSubArray(arr, M + 1);
        for (int i = 1; i < subArr.size(); i++) {
            double temp = 0;
            for (int j = 0; j < subArr.get(i).size(); j++) {
                temp += Math.pow(N, subArr.get(i).get(j));
            }
            if ((int) temp == R) {
                int[] res = new int[subArr.get(i).size()];
                for (int j = 0; j < res.length; j++) {
                    res[j] = subArr.get(i).get(j);
                }
                return res;
            }
        }
        int[] res = new int[0];
        return res;
    }

    /**
     * 获得最大的M
     *
     * @param R
     * @param N
     * @return
     */
    public int getMaxM(int R, int N) {
        int M = 0;
        while ((int) Math.pow(N, M) <= R) {
            M++;
        }
        return --M;
    }

    /**
     * 获得所有子序列
     *
     * @param arr
     * @param length
     * @return
     */
    private ArrayList<ArrayList<Integer>> getSubArray(int[] arr, int length) {
        ArrayList<ArrayList<Integer>> bList = new ArrayList<>();
        int mark = 0;
        int nEnd = 1 << length;
        for (mark = 0; mark < nEnd; mark++) {
            ArrayList<Integer> aList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                if (((1 << i) & mark) != 0) {
                    aList.add(arr[i]);
                }
            }
            bList.add(aList);
        }
        return bList;
    }

    /**
     * 第三题、顾客排序
     * 20%
     *
     * @param a
     * @param b
     * @return
     */
    public int[] WaitInLine(int[] a, int[] b) {
        int n = a.length;
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        List<List<Integer>> list = new ArrayList<>();
        permute(arr, 0, list);
        int min = Integer.MAX_VALUE;
        int[] res = new int[n];
        for (int i = 0; i < list.size(); i++) {
            int sum = 0;
            boolean flag = true;
            for (int j = 0; j < list.get(i).size(); j++) {
                int k = list.get(i).get(j);
                sum += a[k - 1] * (k - 1) + b[k - 1] * (n - k);
                if (sum >= min) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                min = Math.min(min, sum);
                for (int j = 0; j < list.get(i).size(); j++) {
                    res[j] = list.get(i).get(j);
                }
            }
        }
        return res;
    }

    public void permute(int[] arr, int start, List<List<Integer>> list) {
        if (start == arr.length) {
            List<Integer> sub = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                sub.add(arr[i]);
            }
            list.add(sub);
        } else {
            for (int i = start; i < arr.length; ++i) {
                swap(arr, start, i);
                permute(arr, start + 1, list);
                swap(arr, start, i);
            }
        }
    }

    public void swap(int[] arr, int s, int i) {
        int temp = arr[s];
        arr[s] = arr[i];
        arr[i] = temp;
    }

    /**
     * 第四题、最大可办公员工数
     * 40% 现在修改后应该是ac
     * @param pos
     * @return
     */
    public int GetMaxStaffs(char[][] pos) {
        List<Integer> list = staff(pos);
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            res += (int)((list.get(i) + 1) / 2);
        }
        return res;

    }

    public List<Integer> staff(char[][] grid) {
        List<Integer> list = new ArrayList<>();
        if (grid == null || grid.length == 0 || grid[0].length == 0) return list;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.') {
                    int num = markDFS(grid, i, j, 1);
                    list.add(num);
                }
            }
        }
        return list;
    }

    public int markDFS(char[][] grid, int x, int y, int num) {
        int[] diX = {-1, 1, 0, 0};
        int[] diY = {0, 0, -1, 1};
        Stack<Coordinate11> stack = new Stack<>();
        stack.push(new Coordinate11(x, y));
        grid[x][y] = '*';
        while (!stack.isEmpty()) {
            Coordinate11 coor = stack.pop();

            for (int i = 0; i < 4; i++) {
                Coordinate11 adj = new Coordinate11(coor.x + diX[i], coor.y + diY[i]);
                if (!isInBound(adj, grid)) continue;
                if (grid[adj.x][adj.y] == '.') {
                    grid[adj.x][adj.y] = '*';
                    stack.push(adj);
                    num++;
                }
            }
        }
        return num;
    }

    // 判断adj这个点是否在二维网格中
    public boolean isInBound(Coordinate11 adj, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        return adj.x >= 0 && adj.x < n && adj.y >= 0 && adj.y < m;
    }
}

class Coordinate11 {
    public int x;
    public int y;

    public Coordinate11(int x, int y) {
        this.x = x;
        this.y = y;
    }
}