package designmode.structure.bridge;

import designmode.structure.bridge.impl.color.Blue;
import designmode.structure.bridge.impl.color.Red;
import designmode.structure.bridge.impl.shape.Rectangle;
import designmode.structure.bridge.impl.shape.Round;

/**
 * 测试绘制不同颜色的形状
 *
 * @author Defu Li
 * @since 2021/7/25 19:40
 */
public class Main {
    public static void main(String[] args) {
        IShape shape = new Rectangle(new Red());
        shape.draw();

        IShape shape1 = new Round(new Blue());
        shape1.draw();
    }
}
