package otherexperiment;

public class TryCatch {
    public static void main(String[] args) {
        int a = 1;
        if(a == 1) {
            try {
                System.out.println("1");
                return;
            }catch (Exception e) {
                System.out.println("2");
            }
        }
        System.out.println("3");
    }
}
