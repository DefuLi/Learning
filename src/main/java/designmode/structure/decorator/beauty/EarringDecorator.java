package designmode.structure.decorator.beauty;

/**
 * 耳环装饰类
 *
 * @author Defu Li
 * @date 2021/7/26 0:11
 */
public class EarringDecorator implements IBeauty {
    private final IBeauty me;

    public EarringDecorator(IBeauty me) {
        this.me = me;
    }

    /**
     * 通过耳环装饰类，提升Me类30点的颜值
     * @return 颜值
     */
    @Override
    public int getBeautyValue() {
        return me.getBeautyValue() + 30;
    }
}
