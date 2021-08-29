package cleancode.leetcode;

/**
 * 填充每个节点的下一个右侧节点指针
 *
 * @author Defu Li
 * @since 2021/8/15 15:48
 */
public class LeetCode116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        leftRightConnect(root.left, root.right);
        return root;
    }

    public void leftRightConnect(Node node1, Node node2) {
        if (node1 == null) {
            return;
        }
        node1.next = node2;

        leftRightConnect(node1.left, node1.right);
        leftRightConnect(node2.left, node2.right);
        leftRightConnect(node1.right, node2.left);
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
