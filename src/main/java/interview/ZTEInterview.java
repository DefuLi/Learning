package interview;

import java.util.List;

public class ZTEInterview {
    public static void main(String[] args) {
        int a = 15;
        int b = a;
        int temp = 0;
        int num = 0;
        for (int i = 0; i < 31; i++) {
            int c = b & 1;
            b = b >> 1;
            if(c == 1){
                num = i;
            }
        }
        for (int i = 0; i < num + 1; i++) {
            temp = 1 << i;
            temp = temp & a;
            if(temp == 0) {
                a = a | (1 << i);
            }else {
                a = a & ~(1 << i);
            }
        }
        System.out.println(a);
    }
}
