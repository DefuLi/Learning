package designmode.creation.prototype;

/**
 * 用户类 测试原型设计模式
 *
 * @author Defu Li
 * @since 2021/8/3 0:23
 */
public class User {
    public static void main(String[] args) {
        MilkTea joyMilkTea = new MilkTea();
        joyMilkTea.sugar = "1";
        joyMilkTea.tasteType = "香蕉";

        MilkTea cloneMilkTea = joyMilkTea.clone();
        System.out.println(cloneMilkTea.sugar + "," + cloneMilkTea.tasteType);
        if (joyMilkTea == cloneMilkTea) {
            System.out.println("yes");
        }
    }
}
