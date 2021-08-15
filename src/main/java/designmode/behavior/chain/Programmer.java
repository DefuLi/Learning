package designmode.behavior.chain;

/**
 * 责任链模式
 *
 * @author Defu Li
 * @since 2021/7/28 22:55
 */
public abstract class Programmer {
    protected Programmer next;

    protected void setNext(Programmer programmer) {
        this.next = programmer;
    }

    /**
     * 子类实现，处理bug的具体逻辑
     */
    public abstract void handler(Bug bug) throws Exception;
}
