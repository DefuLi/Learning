package designmode.behavior.chain;

/**
 * 中等程序员
 *
 * @author Defu Li
 * @since 2021/8/4 0:28
 */
public class NormalProgrammer extends Programmer {
    @Override
    public void handler(Bug bug) throws Exception {
        if (bug.value > 20 && bug.value <= 50) {
            solve();
            return;
        }
        next.handler(bug);
    }

    public void solve() {
        System.out.println("中等程序员可以解决该问题");
    }
}
