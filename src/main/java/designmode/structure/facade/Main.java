package designmode.structure.facade;

/**
 * 测试外观模式
 *
 * @author Defu Li
 * @date 2021/7/26 23:49
 */
public class Main {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.open();
        facade.close();
    }
}
