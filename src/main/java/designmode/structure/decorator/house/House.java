package designmode.structure.decorator.house;

/**
 * 房屋类
 *
 * @author Defu Li
 * @since 2021/7/26 0:26
 */
public class House implements IHouse {
    @Override
    public void live() {
        System.out.println("房屋原有的功能-居住");
    }
}
