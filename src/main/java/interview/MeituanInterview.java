package interview;

import java.util.*;

/**
 * 1、数字置换
 * 2、同心圆
 * 3、子序列计数
 * 4、小仓的射击练习3
 * 5、套娃前缀和
 */
public class MeituanInterview {
    public static void main(String[] args) {
/*      对于a超过5位小数可以运行正确
       double a = 1.555515;
        float b = (float)(Math.round(a*100000))/100000;
        System.out.println(b);*/

        // 这个方法可以保留小数点后5位，四舍五入  并且位数不够补0
        // round方法是把小数四舍五入转换为整数的
        double n = 1.25555;
        System.out.printf("%.4f", n);

/*        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        MeituanInterview obj = new MeituanInterview();
        ArrayList<ArrayList<Integer>> allSub = obj.getSubArray(arr, num);

//        System.out.println(allSub.size());
        int count = 0;
        for (int i = 1; i < allSub.size(); i++) {
            boolean flag = true;
            for (int j = 0; j < allSub.get(i).size(); j++) {
                if(allSub.get(i).get(j) % (j + 1) != 0){
                    flag = false;
                }
            }
            if(flag == true){
                count++;
            }
        }
        System.out.println(count);*/
    }


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
}


//        System.out.println(new DecimalFormat("#,##0.00000").format(new Double("1.6")));
/**
 * Main obj = new Main();
 * Scanner sc = new Scanner(System.in);
 * int num = sc.nextInt();
 * List<Integer> arr = new ArrayList<>();
 * while (sc.hasNext()) {
 * arr.add(sc.nextInt());
 * }
 * <p>
 * System.out.println(obj.replace(-12, arr));
 * <p>
 * Scanner sc = new Scanner(System.in);
 * int nums = sc.nextInt();
 * int[] arrR = new int[nums];
 * for (int i = 0; i < arrR.length; i++) {
 * arrR[i] = sc.nextInt();
 * }
 * <p>
 * float area;
 * if (nums == 0) {
 * System.out.println(0.00000);
 * } else {  // 至少有一个 nums >= 1
 * area = (float) Math.PI * arrR[0] * arrR[0];  // 第一个
 * if (nums % 2 == 0) {  // 偶数个
 * if (nums > 2) {
 * for (int i = 2; i < nums - 1; i += 2) {
 * area += (float) (Math.PI * arrR[i] * arrR[i] - Math.PI * arrR[i - 1] * arrR[i - 1]);
 * }
 * }
 * } else {  // 奇数个
 * if (nums >= 3) {
 * for (int i = 2; i < nums; i += 2) {
 * area += (float) (Math.PI * arrR[i] * arrR[i] - Math.PI * arrR[i - 1] * arrR[i - 1]);
 * }
 * }
 * }
 * System.out.println(new DecimalFormat("#,##0.00000").format(new Float(area)));
 * //            System.out.println((float) Math.round(area * 100000) / 100000 );
 * }
 * <p>
 * def replace(num, arr):
 * map = dict()
 * res = []
 * for key, val in enumerate(arr):
 * map[key + 1] = val
 * if num < 0:
 * res.append('-')
 * num = abs(num)
 * num = str(num)
 * for subitem in num:
 * res.append(map[int(subitem)])
 * <p>
 * return int(''.join(res))
 * <p>
 * if __name__ == "__main__":
 * num = int(input())
 * arr = input().split()
 * end = replace(num, arr)
 * print(end)
 * <p>
 * <p>
 * public int replace(int num, List<Integer> arr) {
 * Map<Integer, Integer> map = new HashMap<>();
 * StringBuilder sb = new StringBuilder();
 * for (int i = 0; i < arr.size(); i++) {
 * map.put(i + 1, arr.get(i));
 * }
 * if(num < 0) {
 * sb.append('-');
 * num = Math.abs(num);
 * }
 * String temp = String.valueOf(num);
 * for (int i = 0; i < temp.length(); i++) {
 * sb.append(map.get(Integer.valueOf(temp.substring(i, i+1))));
 * }
 * return Integer.valueOf(sb.toString());
 * }
 * <p>
 * Scanner sc = new Scanner(System.in);
 * int nums = sc.nextInt();
 * int[] arrR = new int[nums];
 * for (int i = 0; i < arrR.length; i++) {
 * arrR[i] = sc.nextInt();
 * }
 * <p>
 * float area;
 * if (nums == 0) {
 * System.out.println(0.00000);
 * } else {  // 至少有一个 nums >= 1
 * area = (float) Math.PI * arrR[0] * arrR[0];  // 第一个
 * if (nums % 2 == 0) {  // 偶数个
 * if (nums > 2) {
 * for (int i = 2; i < nums - 1; i += 2) {
 * area += (float) (Math.PI * arrR[i] * arrR[i] - Math.PI * arrR[i - 1] * arrR[i - 1]);
 * }
 * }
 * } else {  // 奇数个
 * if (nums >= 3) {
 * for (int i = 2; i < nums; i += 2) {
 * area += (float) (Math.PI * arrR[i] * arrR[i] - Math.PI * arrR[i - 1] * arrR[i - 1]);
 * }
 * }
 * }
 * System.out.println(new DecimalFormat("#,##0.00000").format(new Float(area)));
 * //            System.out.println((float) Math.round(area * 100000) / 100000 );
 * }
 * <p>
 * def replace(num, arr):
 * map = dict()
 * res = []
 * for key, val in enumerate(arr):
 * map[key + 1] = val
 * if num < 0:
 * res.append('-')
 * num = abs(num)
 * num = str(num)
 * for subitem in num:
 * res.append(map[int(subitem)])
 * <p>
 * return int(''.join(res))
 * <p>
 * if __name__ == "__main__":
 * num = int(input())
 * arr = input().split()
 * end = replace(num, arr)
 * print(end)
 * <p>
 * <p>
 * public int replace(int num, List<Integer> arr) {
 * Map<Integer, Integer> map = new HashMap<>();
 * StringBuilder sb = new StringBuilder();
 * for (int i = 0; i < arr.size(); i++) {
 * map.put(i + 1, arr.get(i));
 * }
 * if(num < 0) {
 * sb.append('-');
 * num = Math.abs(num);
 * }
 * String temp = String.valueOf(num);
 * for (int i = 0; i < temp.length(); i++) {
 * sb.append(map.get(Integer.valueOf(temp.substring(i, i+1))));
 * }
 * return Integer.valueOf(sb.toString());
 * }
 */

/**
 Scanner sc = new Scanner(System.in);
 int nums = sc.nextInt();
 int[] arrR = new int[nums];
 for (int i = 0; i < arrR.length; i++) {
 arrR[i] = sc.nextInt();
 }

 float area;
 if (nums == 0) {
 System.out.println(0.00000);
 } else {  // 至少有一个 nums >= 1
 area = (float) Math.PI * arrR[0] * arrR[0];  // 第一个
 if (nums % 2 == 0) {  // 偶数个
 if (nums > 2) {
 for (int i = 2; i < nums - 1; i += 2) {
 area += (float) (Math.PI * arrR[i] * arrR[i] - Math.PI * arrR[i - 1] * arrR[i - 1]);
 }
 }
 } else {  // 奇数个
 if (nums >= 3) {
 for (int i = 2; i < nums; i += 2) {
 area += (float) (Math.PI * arrR[i] * arrR[i] - Math.PI * arrR[i - 1] * arrR[i - 1]);
 }
 }
 }
 System.out.println(new DecimalFormat("#,##0.00000").format(new Float(area)));
 //            System.out.println((float) Math.round(area * 100000) / 100000 );
 }
 */
//    }
//}
/**
 def replace(num, arr):
 map = dict()
 res = []
 for key, val in enumerate(arr):
 map[key + 1] = val
 if num < 0:
 res.append('-')
 num = abs(num)
 num = str(num)
 for subitem in num:
 res.append(map[int(subitem)])

 return int(''.join(res))

 if __name__ == "__main__":
 num = int(input())
 arr = input().split()
 end = replace(num, arr)
 print(end)

 */

/**
 public int replace(int num, List<Integer> arr) {
 Map<Integer, Integer> map = new HashMap<>();
 StringBuilder sb = new StringBuilder();
 for (int i = 0; i < arr.size(); i++) {
 map.put(i + 1, arr.get(i));
 }
 if(num < 0) {
 sb.append('-');
 num = Math.abs(num);
 }
 String temp = String.valueOf(num);
 for (int i = 0; i < temp.length(); i++) {
 sb.append(map.get(Integer.valueOf(temp.substring(i, i+1))));
 }
 return Integer.valueOf(sb.toString());
 }
 */