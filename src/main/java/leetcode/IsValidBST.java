package leetcode;

import java.util.ArrayList;
import java.util.List;

// 验证二叉搜索树

/**
 * 使用中序遍历得到list，如果是二叉搜索树，应该是递增序列
 */
public class IsValidBST {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        IsValidBST obj = new IsValidBST();
        System.out.println(obj.isValidBST(node1));  // true
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        List<Integer> list = new ArrayList<>();
        inorderTra(root, list);
        long head = list.get(0) - 1;  // 比最小的还小
        for (Integer num: list) {
            if(head < num) head = num;
            else return false;
        }
        return true;
    }

    public void inorderTra(TreeNode root, List<Integer> list) {
        if(root == null) return;
        inorderTra(root.left, list);
        list.add(root.val);
        inorderTra(root.right, list);
    }
}
