package designmode.creation.factory.simplefactory;

/**
 * 水果工厂
 *
 * @author Defu Li
 * @date 2021/7/28 23:00
 */
public class FruitFactory {
    public static Fruit create(String type) {
        switch (type) {
            case "苹果":
                return new Apple();
            case "梨":
                return new Pear();
            default:
                break;
        }
        return null;
    }
}
