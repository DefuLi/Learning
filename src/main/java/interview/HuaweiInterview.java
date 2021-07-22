package interview;

import java.util.*;

public class HuaweiInterview {
    public static void main(String[] args) {
        HuaweiInterview obj = new HuaweiInterview();
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[m + 1];
        arr[0] = 0;
        for (int i = 1; i < m + 1; i++) {
            arr[i] = sc.nextInt();
        }
        obj.getMinSeq(m, k, arr);
    }

    /**
     * 第三题、子序列和最小值的最大值
     * 参考链接：https://www.luogu.com.cn/problemnew/solution/UVA714
     * @param m
     * @param k
     * @param arr
     */
    public void getMinSeq(int m, int k, int[] arr) {
//        int max = Arrays.stream(arr).max().getAsInt();
        int sum = Arrays.stream(arr).sum();
        int max = sum / m;
        while (max < sum) {
            int middle = (max + sum) >> 1;
            if (getNum(m, arr, middle) > k) max = middle + 1;
            else sum = middle;
        }
        printSeq(m, k, arr, max);
    }

    public int getNum(int m, int[] arr, int index) {
        int sum = 0;
        int count = 1;
        for (int i = 0; i < m + 1; i++) {
            if (sum + arr[i] > index) {
                count++;
                sum = arr[i];
            } else sum += arr[i];
        }
        return count;
    }

    public void printSeq(int m, int k, int[] arr, int index) {
        int sum = 0;
        int count = k;
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < m + 1; i++) {
            list.add(false);
        }
        for (int i = m; i >= 0; i--) {
            if (count > i) {
                list.set(i, true);
                count--;
            } else if (arr[i] + sum > index) {
                list.set(i, true);
                count--;
                sum = arr[i];
            } else {
                sum += arr[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(arr[0]) + " ");
        if (list.get(0)) {
            sb.append("/");
        }
        for (int i = 1; i < m + 1; i++) {
            sb.append(" " + String.valueOf(arr[i]));
            if (list.get(i)) {
                sb.append(" " + "/");
            }
        }
        System.out.println(sb.toString().trim().substring(3).trim());
    }
}

/**
 * 第一题 数字查找
 * public static void main(String[] args) {
 * //        Scanner sc = new Scanner(System.in);
 * //        String str = sc.nextLine();
 * String str = "3d50J,Aa3";
 * char[] chars = str.trim().toCharArray();
 * TreeMap<Integer, Integer> map = new TreeMap<>();
 * for (int i = 0; i < chars.length; i++) {
 * if(chars[i] <= '9' && chars[i] >= '0') {
 * map.put(chars[i] - '0', map.getOrDefault(chars[i] - '0', 0) + 1);
 * }
 * }
 * StringBuilder sb = new StringBuilder();
 * for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
 * for (int i = 0; i < entry.getValue(); i++) {
 * sb.append(entry.getKey());
 * }
 * }
 * System.out.println(sb.toString());
 * }
 *
 */

/**
 * 第二题、报文过滤
 *     public static void main(String[] args) {
 *         Main obj = new Main();
 *         Scanner sc = new Scanner(System.in);
 *         String str = sc.nextLine();
 * //        String str = "5a 12 5b ba 34 5b bb 88 05 5a 75 cd bb 62 5a 34 cd 78 cc da fb 06 5a ";
 *         System.out.println(obj.isTrue(str));
 *     }
 *
 *     public String isTrue(String str) {
 *         String[] strings = str.trim().split("5a");
 *         List<String> list = new ArrayList<>();
 *         for (int i = 0; i < strings.length; i++) {
 *             if(strings[i].trim().length() == 0) continue;
 *             String subStr = strings[i].trim().substring(strings[i].trim().length() - 2);
 *             int subLen = Integer.parseInt(subStr, 16);
 *             String[] subStrings = strings[i].trim().split(" ");
 *             int flag = subStrings.length - 1;
 *             for (int j = 0; j < subStrings.length - 1; j++) {
 *                 if(subStrings[j].equals("5b") && j + 1 < subStrings.length - 1 && (subStrings[j + 1].equals("ba") || subStrings[j + 1].equals("bb"))) {
 *                     flag--;
 *                 }
 *             }
 *             if(flag == subLen) list.add(strings[i]);
 *         }
 *         StringBuilder sb = new StringBuilder();
 *         for (int i = 0; i < list.size(); i++) {
 *             sb.append("5a");
 *             sb.append(list.get(i));
 *         }
 *         sb.append("5a");
 *         return sb.toString().trim();
 *     }
 */