package designmode.structure.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 生产TreeType的工厂
 *
 * @author Defu Li
 * @since 2021/7/28 0:02
 */
public class TreeFactory {
    public static Map<String, TreeType> treeTypeMap = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        if (treeTypeMap.containsKey(name)) {
            return treeTypeMap.get(name);
        }
        TreeType treeType = new TreeType(name, color, texture);
        treeTypeMap.put(name, treeType);
        return treeType;
    }
}
