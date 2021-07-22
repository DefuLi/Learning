package leetcode;

// 各位相加
// 38 -> 11 -> 2
public class AddDigits {
    public static void main(String[] args) {
        int input = 101;
        AddDigits a = new AddDigits();
        int output = a.addDigits(input);
        System.out.println(output);
    }
    public int addDigits(int num){
        String string = String.valueOf(num);
        if (string.length() == 1){
            return Integer.parseInt(string);
        }
        int output = 0;
        for(int i=0; i<string.length(); i++){
            output = output +  Integer.parseInt(String.valueOf(string.charAt(i)));
        }

        output = addDigits(output);
        return output;
    }
}
