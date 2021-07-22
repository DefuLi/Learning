package leetcode;


// 二叉搜索树与双向链表
public class TreeToDoublyList {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//
//        node4.left = node2;
//        node4.right = node5;
//        node2.left = node1;
//        node2.right = node3;

        TreeToDoublyList obj = new TreeToDoublyList();
        TreeNode res = obj.treeToDoublyList(node1);
        while (res.right != null) {
            System.out.println(res.val);
            res = res.right;
        }
        System.out.println(res.val);

        System.out.println("========================");
        while (res.left != null) {
            System.out.println(res.val);
            res = res.left;
        }
        System.out.println(res.val);
    }

    /**
    public TreeNode pre;
    public TreeNode head, tail;
    public void process(TreeNode root){
        if(root == null){
            return;
        }
        process(root.left);
        root.left = pre;
        if(pre == null){
            head = root;
        }else{
            pre.right = root;
        }
        pre = root;
        tail = root;
        process(root.right);
    }
    public TreeNode treeToDoublyList(TreeNode root) {
        if(root == null){
            return null;
        }
        process(root);
        tail.right = head;
        head.left = tail;
        return head;
    }
     */

    TreeNode head, tail;

    /**
     * 递归
     * 首先递归找到左子树的左节点 以及 找到右子树的左节点
     * 使用findRight函数找到左子树的最右节点
     *
     * 递归的执行  root.left = 左子树的最右节点
     *            root.right = 右子树的左节点
     * @param root
     * @return
     */
    public TreeNode treeToDoublyList(TreeNode root) {
        if(root == null) return null;
        TreeNode res = helper(root);
        head.left = tail;
        tail.right = head;
        return res;
    }

    public TreeNode helper(TreeNode root) {
        if(root == null) return null;
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);

        TreeNode res = left;

        if(left != null) {
            left = findRight(left);
        } else {
            res = root;
        }

        root.left = left;
        root.right = right;

        if(left != null) {
            left.right = root;
        }
        if(right != null) {
            right.left = root;
        }

        head = res;
        if(findRight(right) == null) {
            tail = root;
        }else {
            tail = findRight(right);
        }
        return res;
    }

    // 找到最右侧节点
    public TreeNode findRight(TreeNode root) {
        if(root == null) return null;
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }
}
