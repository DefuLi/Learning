package otherexperiment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Defu Li
 * @date 2021/4/16 23:10
 */
public class TestListToString {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(); // 重写Object基类里的equals  String重写了
        List<Integer> list2 = new ArrayList<>();
        // == equals()
        // == 基本类型 值   引用类型 地址
        if (list1 == list2) {

        }
        // equals() Object基类的函数  ==
        if (list1.equals(list2)) {
            // 内容
        }
        System.out.println(list1.equals(list2)); // true

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        System.out.println(set1.equals(set2)); // true

        Object obj1 = new Object();
        Object obj2 = new Object();
        System.out.println(obj1.equals(obj2)); // false

    }
}
