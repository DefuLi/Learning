package interview;

import java.util.*;

/**
 * 第二题 烦恼的小D
 */
public class BytedanceInterview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int count = sc.nextInt();
        sc.nextLine();
        Set<String> dict = new HashSet<>();
        for (int i = 0; i < count; i++) {
            dict.add(sc.nextLine());
        }
        BytedanceInterview obj = new BytedanceInterview();
        System.out.println(obj.allCount(text, dict));
    }

    List<String> list = new ArrayList<>();
    boolean[][] dp = null;
    int min = Integer.MAX_VALUE;

    public int allCount(String text, Set<String> dict) {
        if (text == null || text.trim().equals("") || dict == null || dict.isEmpty() || !ok(text, dict)) {
            return list.size();
        }
        dp = new boolean[text.length()][text.length() + 1];
        for (int i = 0; i < text.length(); ++i) {
            for (int j = i + 1; j <= text.length(); ++j) {
                if (dict.contains(text.substring(i, j))) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }
        for (String item : dict) {
            if (min > item.length()) min = item.length();
        }
        helper1(text, 0, 0, "");
        return list.size();
    }

    public void helper1(String text, int sum, int start, String temp) {
        if (temp.length() == temp.length() + sum) list.add(temp.trim());
        else {
            for (int i = start + 1; i <= temp.length(); i++) {
                if (dp[start][i] && helper2(temp.length() - i)) {
                    helper1(text, sum + 1, i, temp + temp.substring(start, i) + " ");
                }
            }
        }
    }

    public boolean helper2(int len) {
        if(len == 0) return true;
        if(len >= min) return true;
        return false;
    }
    public boolean ok(String text, Set<String> dict) {
        text = "#" + text;
        boolean[] isOk = new boolean[text.length()];
        isOk[0] = true;
        for (int i = 1; i < text.length(); i++) {
            for (int j = 0; j < i; j++) {
                isOk[i] = isOk[j] && dict.contains(text.substring(j + 1, i + 1));
                if (isOk[i]) break;
            }
        }
        return isOk[text.length() - 1];
    }
}

/**
 * 第一题 简单的文本编辑器
 */

/**
package interview;
 import java.util.Scanner;
 import java.util.Stack;

public class MainI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String[] common = new String[count];
        sc.nextLine();
        for (int i = 0; i < count; i++) {
            common[i] = sc.nextLine();
        }
        MainI obj = new MainI();
        obj.textEdit(common);
    }

    public void textEdit(String[] common) {
        StringBuilder sb = new StringBuilder();
        // 栈里存操作1 2的记录 方便操作4的回滚
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < common.length; i++) {
            String[] splitCom = common[i].split(" ");
            if(splitCom[0].equals("1")) {
                sb.append(splitCom[1]);
                stack.push("1" + " " + splitCom[1].length());
            }else if(splitCom[0].equals("2")) {
                int deleteCount = Integer.valueOf(splitCom[1]);
                String temp = sb.substring(sb.length() - deleteCount, sb.length());
                sb.delete(sb.length() - deleteCount, sb.length());
                stack.push("2" + " " + temp);
            }else if(splitCom[0].equals("3")) {
                System.out.println(sb.charAt(Integer.parseInt(splitCom[1]) - 1));
            }else {  // 回滚
                String redo = stack.pop();
                String[] splitRedo = redo.split(" ");
                if(splitRedo[0].equals("1")) {  // 需要在sb中删除
                    sb.delete(sb.length() - Integer.valueOf(splitRedo[1]), sb.length());
                }else {  // 需要重新append到sb中
                    sb.append(splitRedo[1]);
                }
            }
        }
    }
}
*/