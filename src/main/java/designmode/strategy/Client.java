package designmode.strategy;

public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        System.out.println(client.order("满300减100", 300));
    }

    public double order(String type, double money) {
        CashContext cashContext = null;
        switch (type){
            case "正常收费":
                cashContext = new CashContext(new CashNormal());
                break;
            case "满300减100":
                cashContext = new CashContext(new CashReturn(300, 100));
                break;
            case "打八折":
                cashContext = new CashContext(new CashRebate(0.8));
                break;
        }
        return cashContext.getResult(money);
    }
}
