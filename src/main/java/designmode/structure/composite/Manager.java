package designmode.structure.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 管理者
 *
 * @author Defu Li
 * @since 2021/7/25 21:11
 */
public class Manager extends Component {
    private List<Component> components = new ArrayList<>();

    public Manager(String position, String job) {
        super(position, job);
    }

    @Override
    void addComponent(Component component) {
        components.add(component);
    }

    @Override
    void removeComponent(Component component) {
        components.remove(component);
    }

    @Override
    void check() {
        // 首先做好自己的本职工作
        work();
        for (Component component: components) {
            component.check();
        }
    }
}
