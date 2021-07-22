package leetcode;

import java.util.List;

// Delete Node in a BST
public class DeleteNode {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        DeleteNode obj = new DeleteNode();
        TreeNode root = obj.deleteNode(node1, 3);
        PreOrderTraversal temp = new PreOrderTraversal();
        List<Integer> list = temp.preorderTraversal(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * 1. 如果目标节点没有子节点，我们可以直接移除该目标节点。
     * 2. 如果目标节只有一个子节点，我们可以用其子节点作为替换。
     * 3. 如果目标节点有两个子节点，我们需要用其中序后继节点或者前驱节点来替换，再删除该目标节点。
     *
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if(root.left == null && root.right == null) root = null;
            else if (root.right != null) {  // 有右子树
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }
            else if (root.left != null) {  // 有左子树 没有右子树
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    // 获得root节点的后继节点val值
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    // 获得root节点的前继节点val值
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }
}
