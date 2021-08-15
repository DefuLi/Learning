package designmode.structure.composite;

/**
 * 组件类
 *
 * @author Defu Li
 * @since 2021/7/25 21:06
 */
public abstract class Component {
    // 职位
    private String position;
    // 工作内容
    private String job;

    public Component(String position, String job) {
        this.position = position;
        this.job = job;
    }

    // 自己的本职工作
    public void work() {
        System.out.println("我是" + position + "我正在" + job);
    }

    abstract void addComponent(Component component);

    abstract void removeComponent(Component component);

    abstract void check();

}
