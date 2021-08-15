package otherexperiment;

/**
 * @author Defu Li
 * @since 2021/2/9 16:35
 */
public class TestStatic {
    public static int count = 100;
    public static void tests(){
        int a = 1;
    }

    public void test(){
        count--;
        tests();
    }
}

class Demo{
    public static void main(String[] args) {
        TestStatic demo1 = new TestStatic();
        TestStatic demo2 = new TestStatic();
        demo1.test();
        System.out.println(TestStatic.count);
    }
}
