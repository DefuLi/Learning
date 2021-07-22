package leetcode;

import java.util.*;

// 有效的括号
public class IsValid {
    public static void main(String[] args) {
        IsValid obj = new IsValid();
        System.out.println(obj.isValid("{[]}"));  // true
        System.out.println(obj.isValid("([)]"));  // false
    }

    public boolean isValid(String s) {
        if (s.equals("")) return true;
        Map<Character, Character> hashMap = getMap();
        Stack<Character> stack = new Stack<>();  // 存储s的分割出的字符
        char[] charArr = s.toCharArray();
        stack.push(charArr[0]);
        for (int i = 1; i < charArr.length; i++) {
            if(stack.isEmpty()) stack.push(charArr[i]);
            else if(hashMap.get(stack.peek()).equals(charArr[i])){  // 相等
                stack.pop();
                continue;
            }
            else {
                stack.push(charArr[i]);
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }

    public Map<Character, Character> getMap(){
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        map.put(')', 'N');
        map.put('}', 'N');
        map.put(']', 'N');
        return map;
    }
}
