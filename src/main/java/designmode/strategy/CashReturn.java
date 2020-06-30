package designmode.strategy;

public class CashReturn extends CashSuper {
    private double moneyCondition;
    private double moneyReturn;
    public CashReturn(double moneyCondition, double moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    /**
     * 满 moneyCondition 减 moneyReturn
     * @param money
     * @return
     */
    @Override
    public double acceptCash(double money) {
        if(money >= moneyCondition) {
            money = money - Math.floor(money / moneyCondition) * moneyReturn;
        }
        return money;
    }
}
