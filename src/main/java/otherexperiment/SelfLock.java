package otherexperiment;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 实现一个显示锁 基于AQS
 * 类似于ReentrantLock
 * ReentrantLock是一个独占锁 所以需要覆盖AQS中的独占锁的流程方法
 */
public class SelfLock implements Lock {

    private static class Sync extends AbstractQueuedSynchronizer {

        /**
         * 在独占模式下 判断当前锁是否被占用
         * 独占模式 也就是排它模式
         *
         * @return
         */
        @Override
        protected boolean isHeldExclusively() {
            
            return getState() == 1;
        }

        /**
         * 独占式获取锁 子类需要重写的流程方法(这是模板设计模式)
         * 不可重入
         *
         * @param arg
         * @return
         */
        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, arg)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        /**
         * 独占式释放锁 字类需要重写的流程方法
         *
         * @param arg
         * @return
         */
        @Override
        protected boolean tryRelease(int arg) {
            // 没锁还释放 那就抛异常
            if (getState() == 0) throw new UnsupportedOperationException();
            setState(0);
            setExclusiveOwnerThread(null);
            return true;
        }

        public Condition newCondition() {
            return new ConditionObject();
        }
    }

    private final Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    /**
     * 可以实现等待通知机制
     * @return
     */
    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
