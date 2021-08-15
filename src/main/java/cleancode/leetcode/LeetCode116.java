package cleancode.leetcode;

/**
 * 填充每个节点的下一个右侧节点指针
 *
 * @author Defu Li
 * @since 2021/8/15 15:48
 */
public class LeetCode116 {
    public Node connect(Node root) {


        return root;
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
