package designmode.creation.factory.simplefactory;

/**
 * 简单工厂模式
 *
 * @author Defu Li
 * @since 2021/7/29 23:57
 */
public class Main {
    public static void main(String[] args) {
        Fruit fruit = FruitFactory.create("苹果");
        fruit.eat();

        fruit = FruitFactory.create("梨");
        fruit.eat();
    }
}
