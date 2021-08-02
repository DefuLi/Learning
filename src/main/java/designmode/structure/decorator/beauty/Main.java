package designmode.structure.decorator.beauty;

/**
 * 测试颜值装饰器模式
 *
 * @author Defu Li
 * @date 2021/7/26 0:08
 */
public class Main {
    public static void main(String[] args) {
        IBeauty me = new Me();
        System.out.println("我原本的颜值" + me.getBeautyValue());

        IBeauty meWithRing = new RingDecorator(me);
        System.out.println("带上戒指的颜值" + meWithRing.getBeautyValue());

//        IBeauty meWithEarring = new EarringDecorator(me);
//        System.out.println("带上耳环的颜值" + meWithEarring.getBeautyValue());

        IBeauty meWithAll = new EarringDecorator(meWithRing);
        System.out.println("带上戒指和耳环的颜值" + meWithAll.getBeautyValue());
    }
}
