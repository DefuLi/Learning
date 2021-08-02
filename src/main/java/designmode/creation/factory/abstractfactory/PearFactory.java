package designmode.creation.factory.abstractfactory;

import designmode.creation.factory.simplefactory.Fruit;
import designmode.creation.factory.simplefactory.Pear;

/**
 * 梨工厂
 *
 * @author Defu Li
 * @date 2021/7/31 0:35
 */
public class PearFactory implements IFactory {
    @Override
    public Fruit create() {
        return new Pear();
    }
}
