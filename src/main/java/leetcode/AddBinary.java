package leetcode;

import java.io.IOException;

// 二进制求和
public class AddBinary {
    public static void main(String[] args) throws IOException {
        String a = "1";
        String b = "11";
        AddBinary obj = new AddBinary();
        System.out.println(obj.addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        char[] achars = a.toCharArray();
        char[] bchars = b.toCharArray();
        char[] maxchars;
        char[] minchars;
        int alen = achars.length;
        int blen = bchars.length;
        int maxlen;
        int minlen;

        int flag = -100;
        String res;
        if (alen > blen) {
            maxlen = alen;
            minlen = blen;
            maxchars = achars;
            minchars = bchars;
        } else {
            maxlen = blen;
            minlen = alen;
            maxchars = bchars;
            minchars = achars;
        }
        for (int i = 0; i < maxlen; i++) {
            if (minlen - i > 0) {
                int temp = Integer.parseInt(String.valueOf(maxchars[maxlen - i - 1])) + Integer.parseInt(String.valueOf(minchars[minlen - i - 1]));
                if (temp == 2) {
                    maxchars[maxlen - i - 1] = '0';
                    if(maxlen - i - 2 < 0 ){
                        flag = 1;
                    }else {
                        maxchars[maxlen - i - 2] = (char) ('0' + (Integer.parseInt(String.valueOf(maxchars[maxlen - i - 2])) + 1));
                    }
                } else if(temp == 3){
                    maxchars[maxlen - i - 1] = '1';
                    if(maxlen - i - 2 < 0){
                        flag = 1;
                    }else {
                        maxchars[maxlen - i - 2] = (char) ('0' + (Integer.parseInt(String.valueOf(maxchars[maxlen - i - 2])) + 1));
                    }
                } else {
                    maxchars[maxlen - i - 1] = (char)('0' + temp);
                }
            }else{
                int temp = Integer.parseInt(String.valueOf(maxchars[maxlen - i - 1]));
                if (temp == 2) {
                    maxchars[maxlen - i - 1] = '0';
                    if(maxlen - i - 2 < 0 ){
                        flag = 1;
                    }else {
                        maxchars[maxlen - i - 2] = (char) ('0' + (Integer.parseInt(String.valueOf(maxchars[maxlen - i - 2])) + 1));
                    }
                }
            }
        }
        if(flag == 1){
            char[] temp = new char[maxlen+1];
            temp[0] = '1';
            for (int i = 0; i < maxlen; i++) {
                temp[i+1] = maxchars[i];
            }
            return String.valueOf(temp);
        }
        return String.valueOf(maxchars);
    }
}
