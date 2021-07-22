package leetcode;

// 填充每个节点的下一个右侧节点指针
public class Connect {
    public static void main(String[] args) {
        CNode node4 = new CNode(4);
        CNode node5 = new CNode(5);
        CNode node6 = new CNode(6);
        CNode node7 = new CNode(7);
        CNode node2 = new CNode(2, node4, node5, null);
        CNode node3 = new CNode(3, node6, node7, null);
        CNode root = new CNode(1, node2, node3, null);

        Connect obj = new Connect();
        CNode res = obj.connect(root);
        System.out.println(res.left.next.val);

    }

    public CNode connect(CNode root) {
        if(root == null) return null;
        if(root.left != null) {
            root.left.next = root.right;
        }
        if(root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}

// 二叉树有右侧节点
class CNode {
    public int val;
    public CNode left;
    public CNode right;
    public CNode next;

    public CNode() {
    }

    public CNode(int _val) {
        val = _val;
    }

    public CNode(int _val, CNode _left, CNode _right, CNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
