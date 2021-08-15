package designmode.structure.flyweight;

/**
 * 树类，作为享元模式中的客户端使用
 *
 * @author Defu Li
 * @since 2021/7/28 0:09
 */
public class Tree {
    public String x;
    public String y;
    public TreeType treeType;

    Tree(String x, String y, TreeType treeType) {
        this.x = x;
        this.y = y;
        this.treeType = treeType;
    }

    public void draw() {
        System.out.println("画了一棵树，特征有：" + treeType.name + treeType.color + treeType.texture + x + y);
    }

}
