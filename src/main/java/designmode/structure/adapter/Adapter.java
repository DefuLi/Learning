package designmode.structure.adapter;

/**
 * 电源适配器
 *
 * @author Defu Li
 * @since 2021/7/25 13:26
 */
public class Adapter {
    public static int convert(int homeVolt) {
        // 使用电阻、电容等器件降低电压
        int volt = homeVolt - 215;
        return volt;
    }
}
