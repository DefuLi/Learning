package leetcode;

import java.util.LinkedList;

// 替换空格
public class ReplaceSpace {

    public static void main(String[] args) {

        StringBuffer str = new StringBuffer("hello  world");
        ReplaceSpace rep = new ReplaceSpace();
        String result = rep.replaceSpace(str);
        System.out.println(result);
        LinkedList<String> linkedList = new LinkedList<>();
    }

    public String replaceSpace(StringBuffer str){
        for (int i=0; i<str.length(); i++){
            Character ch = str.charAt(i);
            if (ch.toString().equals(" ")){
                str.insert(i, "%20");
                i = i+3;
                str.deleteCharAt(i);
                i--;
            }
        }
        String result = str.toString();
        return result;
    }
}
