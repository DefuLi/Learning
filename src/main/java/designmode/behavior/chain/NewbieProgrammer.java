package designmode.behavior.chain;

/**
 * 菜鸟程序员
 *
 * @author Defu Li
 * @since 2021/8/4 0:26
 */
public class NewbieProgrammer extends Programmer {
    @Override
    public void handler(Bug bug) throws Exception {
        if (bug.value > 0 && bug.value <= 20) {
            solve();
            return;
        }
        next.handler(bug);
    }

    public void solve() {
        System.out.println("菜鸟自己可以解决");
    }
}
