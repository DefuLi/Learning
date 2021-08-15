package designmode.structure.decorator.beauty;

/**
 * 戒指装饰类
 *
 * @author Defu Li
 * @since 2021/7/26 0:05
 */
public class RingDecorator implements IBeauty {
    private final IBeauty me;

    public RingDecorator(IBeauty me) {
        this.me = me;
    }

    /**
     * 通过戒指装饰类，提升Me类20点的颜值
     *
     * @return 颜值
     */
    @Override
    public int getBeautyValue() {
        return me.getBeautyValue() + 20;
    }
}
