package leetcode;

import java.util.ArrayList;
import java.util.List;

// 二叉搜索树的第K大节点

/**
 * 递归 右子树 -> 根节点 ->左子树遍历
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/solution/javaji-bai-100de-xiang-xi-jie-da-di-gui-he-die-dai/
 */
public class KthLargestII {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node5.left = node3;
        node5.right = node6;
        node3.left = node2;
        node3.right = node4;
        node2.left = node1;

        KthLargestII obj = new KthLargestII();
        System.out.println(obj.kthLargest(node5, 3));  // 4

    }

    int res = 0;
    List<Integer> list = new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        recursion(root, k);
        return res;
    }

    public void recursion(TreeNode root, int k) {
        if(root == null) return;
        recursion(root.right, k);
        list.add(root.val);
        if(list.size() == k) {
            res = list.get(k - 1);
        }
        recursion(root.left, k);
    }


    /* Leetcode题解
    int count;
    int result = -1;

    public int kthLargest(TreeNode root, int k) {
        count = k;
        kthLargest(root);
        return result;
    }

    public void kthLargest(TreeNode root) {
        if (Objects.nonNull(root)) {
            kthLargest(root.right);
            if (count == 1) {
                result = root.val;
                count--;
                return;
            }
            count--;
            kthLargest(root.left);
        }
    }
    */
}
