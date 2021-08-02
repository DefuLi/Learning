package designmode.structure.decorator.house;

/**
 * 测试粘钩装饰器模式
 * 主要是新增了功能
 *
 * @author Defu Li
 * @date 2021/7/26 8:30
 */
public class Main {
    public static void main(String[] args) {
        IHouse house = new House();
        house.live();

        IStickyHookHouse stickyHookHouse = new StickyHookDecorator(house);
        stickyHookHouse.live();
        stickyHookHouse.hangThings();
    }
}
