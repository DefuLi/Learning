package designmode.structure.adapter;

/**
 * USB线
 *
 * @author Defu Li
 * @since 2021/7/25 13:13
 */
public class USBLine {
    public void charge(int volt) {
        // 如果电压不是5V，抛出异常
        if (volt != 5) {
            throw new IllegalArgumentException("只能接收5V的电压");
        }
        // 正常充电
        System.out.println("正在充电");
    }
}
