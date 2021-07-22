package leetcode;

// Search in a Binary Search Tree
public class SearchBST {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        SearchBST obj = new SearchBST();
        System.out.println(obj.searchBST(node1, 5).left.val);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if(root.val == val) return root;
            if(root.val > val) {
                root = root.left;
                continue;
            }
            if(root.val < val) {
                root = root.right;
                continue;
            }
        }
        return null;
    }
}
