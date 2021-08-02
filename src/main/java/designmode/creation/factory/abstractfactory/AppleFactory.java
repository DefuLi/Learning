package designmode.creation.factory.abstractfactory;

import designmode.creation.factory.simplefactory.Apple;
import designmode.creation.factory.simplefactory.Fruit;

/**
 * 苹果工厂
 *
 * @author Defu Li
 * @date 2021/7/31 0:33
 */
public class AppleFactory implements IFactory {
    @Override
    public Fruit create() {
        return new Apple();
    }
}
