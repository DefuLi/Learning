package designmode.structure.bridge.impl.shape;

import designmode.structure.bridge.IColor;
import designmode.structure.bridge.IShape;

/**
 * 矩形类
 *
 * @author Defu Li
 * @since 2021/7/25 19:10
 */
public class Rectangle implements IShape {

    private IColor color;

    public Rectangle(IColor color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("绘制" + color.getColor() + "色的矩形");
    }
}
