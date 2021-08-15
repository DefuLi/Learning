package designmode.creation.singleton;

/**
 * 静态内部类单例
 *
 * @author Defu Li
 * @since 2021/8/2 0:34
 */
public class StaticInnerSingleton {
    private StaticInnerSingleton() {

    }

    // 静态内部类
    private static class SingletonHolder {
        public static StaticInnerSingleton instance = new StaticInnerSingleton();
    }

    public StaticInnerSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
