package designmode.creation.singleton;

/**
 * 懒汉单例
 *
 * @author Defu Li
 * @date 2021/8/2 0:21
 */
public class LazySingleton {
    private LazySingleton() {

    }

    private static LazySingleton instance;

    // 线程不安全
    public LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
