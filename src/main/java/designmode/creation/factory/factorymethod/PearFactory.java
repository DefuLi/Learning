package designmode.creation.factory.factorymethod;

import designmode.creation.factory.simplefactory.Fruit;
import designmode.creation.factory.simplefactory.Pear;

/**
 * 梨工厂类
 *
 * @author Defu Li
 * @date 2021/7/31 0:28
 */
public class PearFactory {
    public Fruit create() {
        return new Pear();
    }
}
