package otherexperiment;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.*;

public class UsingLock {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        LockSupport.park();  // 线程工具类

        Semaphore semaphore = new Semaphore(5);
    }
}
