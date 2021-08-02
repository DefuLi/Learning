package designmode.creation.factory.abstractfactory;

import designmode.creation.factory.simplefactory.Fruit;

/**
 * 工厂接口
 *
 * @author Defu Li
 * @date 2021/7/31 0:32
 */
public interface IFactory {
    Fruit create();
}
