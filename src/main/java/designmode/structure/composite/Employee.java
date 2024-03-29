package designmode.structure.composite;

/**
 * 员工
 *
 * @author Defu Li
 * @since 2021/7/25 21:22
 */
public class Employee extends Component {
    public Employee(String position, String job) {
        super(position, job);
    }

    @Override
    void addComponent(Component component) {
        System.out.println("职员没有管理权限");
    }

    @Override
    void removeComponent(Component component) {
        System.out.println("职员没有管理权限");
    }

    @Override
    void check() {
        work();
    }
}
