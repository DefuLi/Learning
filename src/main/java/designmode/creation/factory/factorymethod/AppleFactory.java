package designmode.creation.factory.factorymethod;

import designmode.creation.factory.simplefactory.Fruit;
import designmode.creation.factory.simplefactory.Apple;

/**
 * 苹果工厂类
 *
 * @author Defu Li
 * @since 2021/7/31 0:27
 */
public class AppleFactory {
    public Fruit create() {
        return new Apple();
    }
}
