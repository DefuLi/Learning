package leetcode;

import java.util.ArrayList;
import java.util.List;

// N-ary Tree Postorder Traversal

/**
 * N叉树后序遍历
 */
public class Postorder {
    public static void main(String[] args) {
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

        Postorder obj = new Postorder();
        List<Integer> list = obj.postorder(node1);
        for (Integer num : list) {
            System.out.println(num);  // 5 6 3 2 4 1
        }
    }

    public List<Integer> postorder(NTree root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        tra(root, list);
        return list;
    }

    public void tra(NTree root, List<Integer> list) {
        if (root == null) return;
        int size = root.children == null ? 0 : root.children.size();
        for (int i = 0; i < size; i++) {
            tra(root.children.get(i), list);
        }
        list.add(root.val);
    }
    /**
     public void tra(NTree root, List<Integer> list) {
     List<NTree> children = root.children;
     if(children == null) {
     list.add(root.val);
     return;
     }
     for (int i = 0; i < children.size(); i++) {
     tra(children.get(i), list);
     }
     list.add(root.val);
     }
     */
}
