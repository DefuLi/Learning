package leetcode;

import java.util.Stack;

// 字符串解码
public class DecodeString {
    public static void main(String[] args) {
        DecodeString obj = new DecodeString();
//        String s = "3[a2[c]]";
//        String s = "3[a]2[bc]";
        String s = "100[leetcode]";
        System.out.println(obj.decodeString(s));  // aaabcbc
    }

    public String decodeString(String s){
        char[] charArr = s.toCharArray();
        String[] sArr = new String[charArr.length];
        for (int i = 0; i < charArr.length; i++) {
            sArr[i] = String.valueOf(charArr[i]);
        }
        Stack<String> stack = new Stack<>();
        String encodedString = "";
        String tempStr = "";
        for (int i = 0; i < charArr.length; i++) {
            if(charArr[i] == ']'){
                while (!stack.peek().equals("[")){
                    encodedString = stack.pop() + encodedString;
                }
                stack.pop();
                String tempNums = "";
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))){
                    tempNums = stack.pop() + tempNums;
                }
                int nums = Integer.parseInt(tempNums);
//                int nums = Integer.parseInt(stack.pop());
                for (int j = 0; j < nums; j++) {
                    tempStr += encodedString;
                }
                stack.push(tempStr);
                encodedString = "";
                tempStr = "";
            }else {
                stack.push(sArr[i]);
            }
        }
        String res = "";
        while (!stack.isEmpty()){
            res = stack.pop() + res;
        }
        return res;
    }
}
