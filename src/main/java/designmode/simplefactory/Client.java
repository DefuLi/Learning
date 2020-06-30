package designmode.simplefactory;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        double total = client.order("满300减100", 300);
        System.out.println(total);
    }

    /**
     * money为原价(总价)
     * @param type
     * @param money
     * @return
     */
    public double order(String type, double money) {
        CashSuper cs = CashFactory.createCashAcceptObj(type);
        double total = cs.acceptCash(money);
        return total;
    }
}
