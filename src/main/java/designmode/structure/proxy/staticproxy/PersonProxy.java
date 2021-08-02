package designmode.structure.proxy.staticproxy;

/**
 * Person代理类
 *
 * @author Defu Li
 * @date 2021/7/28 0:17
 */
public class PersonProxy implements IPerson {
    IPerson person;

    PersonProxy(IPerson person) {
        this.person = person;
    }

    @Override
    public void eat() {
        System.out.println("马上就会打印我正在吃饭");
        person.eat();
    }

    @Override
    public void sleep() {
        System.out.println("马上就会打印我正在睡觉");
        person.sleep();
    }
}
