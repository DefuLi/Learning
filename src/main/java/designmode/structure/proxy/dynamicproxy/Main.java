package designmode.structure.proxy.dynamicproxy;

import designmode.structure.proxy.staticproxy.IPerson;
import designmode.structure.proxy.staticproxy.Person;

/**
 * 动态代理模式的测试类
 *
 * @author Defu Li
 * @since 2021/7/28 22:45
 */
public class Main {
    public static void main(String[] args) {
        PersonProxy proxy = new PersonProxy();
        IPerson person = proxy.getInstance(new Person());
        person.eat();
//        person.sleep();
    }
}
