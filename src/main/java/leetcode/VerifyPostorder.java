package leetcode;

// 二叉搜索树的后序遍历序列
public class VerifyPostorder {
    public static void main(String[] args) {
        int[] postorder = {1, 3, 2, 6, 5};
        VerifyPostorder obj = new VerifyPostorder();
        System.out.println(obj.verifyPostorder(postorder));  // true
    }

    /**
     * 递归分治
     * 数组最后一个值为根节点
     * 数组前面一部分为左子树 全部小于根节点
     * 数组后面一部分为右子树 全部大于根节点
     * 以此规律进行判断
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) return false;
        if (postorder.length == 1) return true;
        return helper(postorder, 0, postorder.length - 1);
    }

    public boolean helper(int[] postorder, int start, int end) {
        if (start > end) return true;
        int root = postorder[end];
        int i = start;
        while (postorder[i] < root) {
            i++;
        }
        int j = i - 1;
        while (postorder[i] > root) {
            i++;
        }
        if (i != end) return false;
        boolean left = helper(postorder, start, j);
        boolean right = helper(postorder, ++j, end - 1);

        return left && right;
    }
}
