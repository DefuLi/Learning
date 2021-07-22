package interview;

import java.util.*;

public class WangyiInterview {
    public static void main(String[] args) {
        /** 第一题
        Solution obj = new Solution();
        Scanner sc = new Scanner(System.in);
        String[] num = sc.nextLine().split(",");
        String num1 = num[0].substring(1,num[0].length() - 1);
        String num2 = num[1].substring(1, num[1].length() - 1);
        System.out.println(obj.add(num1, num2));
        */

        /** 第二题
         Solution obj = new Solution();
         Scanner sc = new Scanner(System.in);
         int N = sc.nextInt();
         int[] W = new int[N];
         int[] T = new int[N];
         for (int i = 0; i < N; i++) {
         W[i] = sc.nextInt();
         }
         for (int i = 0; i < N; i++) {
         T[i] = sc.nextInt();
         }
         long M = sc.nextInt();
         System.out.println(obj.getReM(N, W, T, M));
         */

        /** 第三题
        Solution obj = new Solution();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 3
        int M = sc.nextInt();  // 4
        String[] names = new String[N];
        for (int i = 0; i < N; i++) {
            names[i] = sc.nextLine();
        }
        List<String> list = new ArrayList<>();
        while (!sc.nextLine().equals("0 0 N 0 0")) {
            list.add(sc.nextLine());
        }
        List<String> res = obj.getTeams(N, M, names, list);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
         */

        /** 第四题
        Solution obj = new Solution();
        int[][] boxes = {{5, 4, 3}, {5, 4, 5}, {6, 6, 6}};
        System.out.println(obj.maxBoxes(boxes));  // 2
         */
    }

    /**
     * 第一题、有小数的9进制加法
     * @param num1
     * @param num2
     * @return
     */
    public String add (String num1, String num2) {
        if(num1 == null || num1.length() == 0) return num2;
        if(num2 == null || num2.length() == 0) return num1;

        // 先分离num1和num2的整数小数部分
        String num1In, num1Re, num2In, num2Re;
        StringBuilder sb1In = new StringBuilder();
        StringBuilder sb1Re = new StringBuilder();
        StringBuilder sb2In = new StringBuilder();
        StringBuilder sb2Re = new StringBuilder();

        boolean flag1 = true;
        boolean flag2 = true;
        for (int i = 0; i < num1.length(); i++) {
            if(flag1) {
                if(num1.charAt(i) == '.') flag1 = false;
                else sb1In.append(num1.charAt(i));
            }else {
                sb1Re.append(num1.charAt(i));
            }
        }

        for (int i = 0; i < num2.length(); i++) {
            if(flag2) {
                if(num2.charAt(i) == '.') flag2 = false;
                else sb2In.append(num2.charAt(i));
            }else {
                sb2Re.append(num2.charAt(i));
            }
        }

        if(sb1Re.length() == 0 && sb2Re.length() == 0) {  // 没有小数
            return addStrings(sb1In.toString(), sb2In.toString());
        }else {
            String in = addStrings(sb1In.toString(), sb2In.toString());
            int count = Math.max(sb1Re.toString().length(), sb2Re.toString().length());  // 位数
            String re = addStrings(sb1Re.toString(), sb2Re.toString());
            if(re.length() > count) {
                re = re.substring(1);
                in = addStrings(in, "1");
            }
            return in + "." + re;
        }
    }

    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) return num2;
        if (num2 == null || num2.length() == 0) return num1;

        int len1 = num1.length();
        int len2 = num2.length();
        StringBuilder sb = new StringBuilder();
        len1--;
        len2--;
        int carry = 0;
        while (len1 >= 0 || len2 >= 0) {
            int in1 = len1 >= 0 ? num1.charAt(len1) - '0' : 0;
            int in2 = len2 >= 0 ? num2.charAt(len2) - '0' : 0;
            int temp = in1 + in2 + carry;
            carry = temp / 9;
            sb.append(temp % 9);
            len1--;
            len2--;
        }
        if(carry == 1) sb.append(1);
        return sb.reverse().toString();
    }

    /**
     * 第二题、聪明的厂长
     *
     * @param N
     * @param W
     * @param T
     * @param M
     * @return
     */
    public long getReM(int N, int[] W, int[] T, long M) {
        int[] dp = new int[N];
        Arrays.sort(W);
        Arrays.sort(T);
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = i; j < N; j++) {
                if (W[i] >= T[j]) {
                    count++;
                } else break;
            }
            dp[i] = count;
        }
        long mu = 1;
        for (int i = 0; i < dp.length; i++) {
            mu *= dp[i];
        }

        return mu % M;
    }

    /**
     * 第三题、组队
     * @param N
     * @param M
     * @param names
     * @param list
     * @return
     */
    public List<String> getTeams(int N, int M, String[] names, List<String> list) {
        StringBuilder[] sbs = new StringBuilder[M];


        return null;
    }

    /**
     * 第四题、整理快递盒
     * @param boxes
     * @return
     */
    public int maxBoxes(int[][] boxes) {
        Arrays.sort(boxes, new Comparator<int[]>() {
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
        int count = 1;
        for (int i = 0; i < boxes.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < boxes[0].length; j++) {
                if(boxes[i][j] <= boxes[i + 1][j]) flag = false;
            }
            if(flag == true) count++;
        }
        return count;
    }
}
