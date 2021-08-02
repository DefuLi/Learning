package designmode.creation.prototype;

/**
 * 奶茶 原型设计模式
 *
 * @author Defu Li
 * @date 2021/8/3 0:20
 */
public class MilkTea {
    public String sugar;
    public String tasteType;

    public MilkTea clone() {
        MilkTea milkTea = new MilkTea();
        milkTea.sugar = sugar;
        milkTea.tasteType = tasteType;
        return milkTea;
    }
}
