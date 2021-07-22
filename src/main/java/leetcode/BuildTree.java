package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 从中序与后序遍历序列构造二叉树
public class BuildTree {
    public static void main(String[] args) {
        int[] inorder = {3, 2, 1};
        int[] postorder = {3, 2, 1};
        BuildTree obj = new BuildTree();

        // 输出构建好的二叉树前序序列
        PreOrderTraversal tra = new PreOrderTraversal();
        List<Integer> list = tra.preorderTraversal(obj.buildTree(inorder, postorder));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = comeOn(postorder, 0, postorder.length - 1, -1, map);
        return root;
    }

    public TreeNode comeOn(int[] postorder, int startPost, int endPost, int indexOrder, Map<Integer, Integer> map) {
        if (startPost > endPost) return null;
        TreeNode root = new TreeNode(postorder[endPost]);
        int index = map.get(root.val);
        if (index <= indexOrder) return root;
        int leftLen = index - indexOrder - 1;  // 左子树个数
        int sumLen = endPost - startPost + 1;
        int rightLen = sumLen - leftLen - 1;  // 右子树个数
        root.right = comeOn(postorder, startPost + leftLen, endPost - 1, index, map);
        root.left = comeOn(postorder, startPost, startPost + leftLen - 1, indexOrder, map);

        return root;
    }
}
