package leetcode;

// Maximum Depth of N-ary Tree

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * N叉树的最大深度
 */
public class MaxDepthII {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = null;

        System.out.println(list1.isEmpty());  // true
        System.out.println(list1 == null);  // false

        System.out.println(list2 == null);  // true
        System.out.println(list2.isEmpty());  // 空指针异常



        /**
        NTree node1 = new NTree(1);
        NTree node2 = new NTree(3);
        NTree node3 = new NTree(2);
        NTree node4 = new NTree(4);
        NTree node5 = new NTree(5);
        NTree node6 = new NTree(6);
        List<NTree> children1 = new ArrayList<>();
        children1.add(node2);
        children1.add(node3);
        children1.add(node4);
        node1.children = children1;
        List<NTree> children2 = new ArrayList<>();
        children2.add(node5);
        children2.add(node6);
        node2.children = children2;

        MaxDepthII obj = new MaxDepthII();
        System.out.println(obj.maxDepth(node1));  // 3
         */
    }

    List<Integer> list = new ArrayList<>();

    public int getDepth(NTree root, int h) {
        if (root.children.isEmpty()) return h;
        List<NTree> children = root.children;
//        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < children.size(); i++) {
            int currH = getDepth(children.get(i), h + 1);
            list.add(currH);
        }
        int temp = Collections.max(list);
//        Collections.sort(list);
//        int temp = list.get(list.size() - 1);
        list.clear();
        return temp;
    }

    public int maxDepth(NTree root) {
        if (root == null) return 0;
        int maxH = getDepth(root, 1);
        return maxH;
    }

    /** 这是官方题解的方法，可以运行
     * 区别就是判断root.children是否为空时，官方的用例需要使用isEmpty()函数
     * 而我的用例，需要使用==null判断。
     * 这两种的区别可以在我的Java笔记中查看
     public int maxDepth(NTree root) {
     if (root == null) {
     return 0;
     } else if (root.children.isEmpty()) {
     return 1;
     } else {
     List<Integer> heights = new ArrayList<>();
     for (NTree item : root.children) {
     heights.add(maxDepth(item));
     }
     return Collections.max(heights) + 1;
     }
     }
     */
}
