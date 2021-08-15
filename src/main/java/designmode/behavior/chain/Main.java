package designmode.behavior.chain;

/**
 * 责任链设计模式 测试类
 *
 * @author Defu Li
 * @since 2021/8/4 0:31
 */
public class Main {
    public static void main(String[] args) throws Exception {
        NewbieProgrammer newbieProgrammer = new NewbieProgrammer();
        NormalProgrammer normalProgrammer = new NormalProgrammer();
        GoodProgrammer goodProgrammer = new GoodProgrammer();

        Bug bug1 = new Bug(15);
        Bug bug2 = new Bug(45);
        Bug bug3 = new Bug(75);

        newbieProgrammer.setNext(normalProgrammer);
        normalProgrammer.setNext(goodProgrammer);

        newbieProgrammer.handler(bug1);
        newbieProgrammer.handler(bug2);
        newbieProgrammer.handler(bug3);

    }
}
