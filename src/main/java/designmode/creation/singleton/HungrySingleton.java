package designmode.creation.singleton;

/**
 * 饿汉单例
 *
 * @author Defu Li
 * @since 2021/8/2 0:07
 */
public class HungrySingleton {
    private HungrySingleton() {

    }

    private static HungrySingleton instance = new HungrySingleton();

    public HungrySingleton getInstance() {
        return instance;
    }
}
