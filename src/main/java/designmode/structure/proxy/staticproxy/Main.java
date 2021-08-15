package designmode.structure.proxy.staticproxy;

/**
 * 静态代理类的测试
 *
 * @author Defu Li
 * @since 2021/7/28 0:19
 */
public class Main {
    public static void main(String[] args) {
        IPerson person = new Person();
        IPerson personProxy = new PersonProxy(person);
        personProxy.eat();
        personProxy.sleep();
    }
}
