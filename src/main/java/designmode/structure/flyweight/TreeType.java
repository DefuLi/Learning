package designmode.structure.flyweight;

/**
 * 享元类，拥有一棵树的部分状态
 *
 * @author Defu Li
 * @date 2021/7/27 8:25
 */
public class TreeType {
    public String name;
    public String color;
    public String texture;
    TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }


}
