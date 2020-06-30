package designmode.simplefactory;

public class CashRebate extends CashSuper {
    private double moneyRebate;

    public CashRebate(double moneyRebate){
        this.moneyRebate = moneyRebate;
    }

    /**
     * 初始化时必须要输入折扣率
     * 八折就是0.8
     * @param money
     * @return
     */
    @Override
    public double acceptCash(double money) {
        return money * moneyRebate;
    }
}
