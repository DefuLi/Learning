package designmode.structure.adapter;

/**
 * 用户充电
 *
 * @author Defu Li
 * @since 2021/7/25 13:28
 */
public class User {
    public static void main(String[] args) {
        HomeBattery homeBattery = new HomeBattery();
        int homeVolt = homeBattery.supply();
        USBLine usbLine = new USBLine();
        usbLine.charge(Adapter.convert(homeVolt));
    }
}