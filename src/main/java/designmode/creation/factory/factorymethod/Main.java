package designmode.creation.factory.factorymethod;

import designmode.creation.factory.simplefactory.Fruit;

/**
 * 工厂方法设计模式
 *
 * @author Defu Li
 * @date 2021/7/31 0:28
 */
public class Main {
    public static void main(String[] args) {
        // 苹果工厂生产苹果
        AppleFactory factory = new AppleFactory();
        Fruit apple = factory.create();
        apple.eat();
    }
}
