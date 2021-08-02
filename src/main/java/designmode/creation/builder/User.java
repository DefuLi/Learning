package designmode.creation.builder;

/**
 * 用户类 测试建造者设计模式
 *
 * @author Defu Li
 * @date 2021/8/3 0:12
 */
public class User {
    public static void main(String[] args) {
        MilkTea milkTea = new MilkTea.Builder("草莓味").setIce(false).setSugar("2分").build();
        System.out.println(milkTea.getIce());
        System.out.println(milkTea.getSugar());
        System.out.println(milkTea.getTasteType());
    }
}
