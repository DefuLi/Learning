package designmode.structure.bridge.impl.shape;

import designmode.structure.bridge.IColor;
import designmode.structure.bridge.IShape;

/**
 * 三角形
 *
 * @author Defu Li
 * @date 2021/7/25 19:12
 */
public class Triangle implements IShape {
    private IColor color;

    public Triangle(IColor color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("绘制" + color.getColor() + "色的三角形");
    }
}
