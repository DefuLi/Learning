package designmode.structure.bridge.impl.shape;

import designmode.structure.bridge.IColor;
import designmode.structure.bridge.IShape;

/**
 * 圆形
 *
 * @author Defu Li
 * @since 2021/7/25 19:11
 */
public class Round implements IShape {
    private IColor color;

    public Round(IColor color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("绘制" + color.getColor() + "色的圆形");
    }
}
