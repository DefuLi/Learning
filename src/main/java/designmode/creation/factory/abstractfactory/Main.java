package designmode.creation.factory.abstractfactory;

import designmode.creation.factory.simplefactory.Fruit;

/**
 * 抽象工厂设计模式
 *
 * @author Defu Li
 * @date 2021/7/31 0:36
 */
public class Main {
    public static void main(String[] args) {
        IFactory factory = new AppleFactory();
        Fruit apple = factory.create();
        apple.eat();
    }

}
