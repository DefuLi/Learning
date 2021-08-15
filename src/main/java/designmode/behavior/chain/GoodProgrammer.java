package designmode.behavior.chain;

/**
 * 优秀程序员
 *
 * @author Defu Li
 * @since 2021/8/4 0:30
 */
public class GoodProgrammer extends Programmer {
    @Override
    public void handler(Bug bug) throws Exception {
        if (bug.value > 50) {
            solve();
            return;
        }
        throw new Exception("最牛逼的程序员都搞不定");
    }

    public void solve() {
        System.out.println("优秀程序员完成了这个最困难的问题");
    }
}
