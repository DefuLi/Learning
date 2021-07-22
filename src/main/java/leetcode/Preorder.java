package leetcode;
import java.util.ArrayList;
import java.util.List;

// N-ary Tree Preorder Traversal
/**
 * N叉树前序遍历
 */
public class Preorder {
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

        Preorder obj = new Preorder();
        List<Integer> list = obj.preorder(node1);
        for (Integer num: list) {
            System.out.println(num);  // 1 3 5 6 2 4
        }
    }

    public List<Integer> preorder(NTree root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        tra(root, list);
        return list;
    }
    public void tra(NTree root, List<Integer> list) {
        list.add(root.val);
        List<NTree> children = root.children;
        if(children == null) return;
        for (int i = 0; i < children.size(); i++) {
            tra(children.get(i), list);
        }
    }
}

// N叉树节点的数据结构
class NTree {
    public int val;
    public List<NTree> children;
    public NTree() { }
    public NTree(int _val) {
        val = _val;
    }
    public NTree(int _val, List<NTree> _children) {
        val = _val;
        children = _children;
    }
}
