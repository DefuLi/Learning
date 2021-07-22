package leetcode;

// 将有序数组转换为二叉搜索树

/**
 * 递归的创建二叉搜索树，过程如下：
 * 当有个数组时，我们首先选择数组中间元素作为二叉搜索树的根节点
 * 同理，创建完根节点后，创建左子树的根节点，等到。
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        SortedArrayToBST obj = new SortedArrayToBST();
        obj.sortedArrayToBST(nums);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        TreeNode root = buildTree(nums, 0, nums.length - 1);
        return root;
    }

    public TreeNode buildTree(int[] nums, int start, int end) {
        if(start > end) return null;
        int mid = (end - start) / 2 + start;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, start, mid - 1);
        root.right = buildTree(nums, mid + 1, end);
        return root;
    }
}
