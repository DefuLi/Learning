package designmode.simplefactory;

public class CashNormal extends CashSuper {
    /**
     * 正常收费 原价返回
     * @param money
     * @return
     */
    @Override
    public double acceptCash(double money) {
        return money;
    }
}
