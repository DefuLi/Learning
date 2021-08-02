package designmode.structure.proxy.staticproxy;

/**
 * Person类
 *
 * @author Defu Li
 * @date 2021/7/28 0:16
 */
public class Person implements IPerson {
    @Override
    public void eat() {
        System.out.println("我正在吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("我正在睡觉");
    }
}
