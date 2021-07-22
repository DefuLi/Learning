package leetcode;

// 填充每个节点的下一个右侧节点指针 II
// https://blog.csdn.net/qq_43387999/article/details/88020393
public class ConnectII {
    public static void main(String[] args) {
        CNode node14 = new CNode(14);
        CNode node15 = new CNode(15);
        CNode node8 = new CNode(8, node14, node15, null);
        CNode node9 = new CNode(9);
        CNode node10 = new CNode(10);
        CNode node11 = new CNode(11);
        CNode node12 = new CNode(12);
        CNode node13 = new CNode(13);
        CNode node4 = new CNode(4, node8, node9, null);
        CNode node5 = new CNode(5, node10, node11, null);
        CNode node6 = new CNode(6, node12, node13, null);
        CNode node7 = new CNode(7);
        CNode node2 = new CNode(2, node4, node5, null);
        CNode node3 = new CNode(3, node6, node7, null);
        CNode node1 = new CNode(1, node2, node3, null);

        ConnectII obj = new ConnectII();
        CNode root = obj.connect(node1);
        System.out.println(root.left.left.right.next.val);  // 10
    }

    public CNode connect(CNode root) {
        if (root == null || (root.right == null && root.left == null)) {
            return root;
        }
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            root.right.next = getNextNoNullChild(root);
        }
        if (root.left == null) {
            root.right.next = getNextNoNullChild(root);
        }
        if (root.right == null) {
            root.left.next = getNextNoNullChild(root);
        }

        //这里要注意：先递归右子树，否则右子树根节点next关系没建立好，左子树到右子树子节点无法正确挂载
        root.left = connect(root.left);
        root.right = connect(root.right);


        return root;
    }

    /**
     * 一路向右找到有子节点的根节点
     */
    private static CNode getNextNoNullChild(CNode root) {
        while (root.next != null) {
            if (root.next.left != null) {
                return root.next.left;
            }
            if (root.next.right != null) {
                return root.next.right;
            }
            root = root.next;
        }
        return null;
    }
}
