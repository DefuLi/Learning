package designmode.structure.composite;

/**
 * 测试组合模式
 * 该模式的具体实现和字典树数据结构比较像
 *
 * @author Defu Li
 * @date 2021/7/25 23:28
 */
public class Main {
    public static void main(String[] args) {
        Component boss = new Manager("老板", "唱怒放的生命");
        Component hr = new Manager("人力资源", "聊微信");
        Component pm = new Manager("产品经理", "不知道干啥");
        Component ui = new Employee("设计师", "画画");
        Component secretary = new Employee("hr的小秘书", "招新员工");
        Component programmer = new Employee("程序员", "写代码");

        boss.addComponent(hr);
        boss.addComponent(pm);

        hr.addComponent(secretary);
        pm.addComponent(programmer);
        pm.addComponent(ui);

        boss.check();
    }
}
