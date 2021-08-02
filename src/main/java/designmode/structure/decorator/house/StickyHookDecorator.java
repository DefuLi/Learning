package designmode.structure.decorator.house;

/**
 * 粘钩装饰类
 *
 * @author Defu Li
 * @date 2021/7/26 0:30
 */
public class StickyHookDecorator implements IStickyHookHouse {
    private IHouse house;

    public StickyHookDecorator(IHouse house) {
        this.house = house;
    }

    @Override
    public void hangThings() {
        System.out.println("有了粘钩后，新增了挂东西的功能");
    }

    @Override
    public void live() {
        house.live();
    }
}
