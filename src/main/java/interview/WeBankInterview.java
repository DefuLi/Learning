package interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 微众银行
public class WeBankInterview {
    public static void main(String[] args) {
        WeBankInterview obj = new WeBankInterview();
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[][] arr = new int[count][2];
        for (int i = 0; i < count; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
//        int[][] arr = {{0,2}, {1,1}, {1,0}, {1,0}, {2,0}};
        System.out.println(obj.getMaxMoney(arr));
    }


    /**
     * 第一题、分礼物
     *
     * 有n位小朋友去小明家里拜年，小明准备了m份礼物。小明想把所有礼物平均分给每个小朋友，每个小朋友得到相同个数的礼物。但是m未必能被n整除，小明可以使用以下两种操作任意多次（两种操作可以同时使用）。
     *
     * 1、 给其中一个小朋友发红包，收到红包的小朋友会离开小明家。每个红包需要花费a元。
     *
     * 2、 购买一个新礼物，每个礼物价值为b元。
     *
     * 问小明最少花费多少元，才能使得所有礼物可以被剩下的小朋友平分
     */



    public int getMinMoney(int n, int m, int a, int b) {
        if(m >= n && m % n == 0) return 0;
        int min = Math.min(a, b) * Math.abs(n - m);
        return min;
    }
    /** 一开始的想法是用dfs，后来放弃了。
    int min = Integer.MAX_VALUE;
    public int dfs(int n, int m, int a, int b, int money) {
        if (n == 0 || m % n == 0) return Math.min(min, money);
        dfs(n - 1, m, a, b, money + a);  // 第一种情况 给小朋友发红包
        dfs(n, m + 1, a, b, money + b);  // 第二种情况 花b元去购买礼物
        return min;
    }
     */


    /**
     * 第二题、回文游戏
     *
     * Cassidy和Eleanore是一对好朋友，她们经常会一起玩游戏。某一天她们玩了一个回文游戏。游戏规则是这样的：给出一个仅包含小写字母的字符串S，在每一个人的回合中，她们会进行两个操作：
     *
     * 1. 尝试重新排列这个字符串，如果可以把这个字符串排列成回文字符串，则立即获胜。
     *
     * 2. 否则，她们必须删掉字符串中的一个字符。
     *
     * 已知，Cassidy先手，在两个人都采取最佳策略的情况下，谁可以获胜。
     * @param
     * @return 0代表Cassidy胜；1代表Eleanore胜
     */
    public String[] isWin(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if(isZeroOne(strArr[i]) == 0) strArr[i] = "Cassidy";
            else strArr[i] = "Eleanore";
        }
        return strArr;
    }

    public int isZeroOne(String str) {
        int flag = isPlalindrome(str);
        if(flag <= 1) return 0;
        if(flag % 2 == 0) return 1;
        return 0;
    }

    public int isPlalindrome (String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        int flag = 0;
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if(entry.getValue() % 2 != 0) flag++;
        }
        return flag;
    }

    /**
     * 第三题、抽卡
     *
     * 抽卡是一类类似于博弈的游戏。现在有一种抽卡方式，描述如下：
     *
     * 初始你只有一次抽卡机会。每次抽卡浪费一次抽卡机会，获得一张卡片。这张卡片上有两个数字，第一个数字代表你能获得的钱，第二个数字代表你能获得的额外抽卡次数。额外的抽卡次数是可以累计的。
     *
     * 现在，你知道了卡片的数量，所有的卡片上的数字，以及所有卡片的顺序。你只需要安排一种抽卡顺序，使得你能获得钱数最多。
     * @param arr
     * @return
     */
    int max = Integer.MIN_VALUE;
    public int getMaxMoney(int[][] arr) {
        // 第0列是金额  第1列是数量
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, dfs1(arr, i, arr[i][1], 0));
        }
        return max;
    }
    public int dfs1(int[][] arr, int row, int count, int money) {
        if(count == 0) return max = Math.max(max, money);
        for (int i = 0; i < arr.length; i++) {

            int temp = arr[i][1];
            arr[i][1] = 0;
            dfs1(arr, i, count - 1 + arr[i][1], money + arr[i][0]);
            arr[i][1] = temp;
        }
        return max;
    }
}


