package leetcode;


import java.util.ArrayList;
import java.util.List;

// 二叉树中和为某一值的路径
public class PathSum {
    public static void main(String[] args) {
        int sum = 7;
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;

        PathSum obj = new PathSum();
        List<List<Integer>> res = obj.pathSum(node1, sum);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.println(res.get(i).get(j));
            }
            System.out.println("*************************");
        }
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    /**
     * 递归
     * 使用sum -= root.val  如果sum == 0 && root.left == null && root.right == null
     * 可以说明该路径就是符合要求的
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return res;
        helper(root, sum);
        return res;
    }

    public void helper(TreeNode root, int sum) {
        sum -= root.val;
        list.add(root.val);
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        if (root.left == null && root.right == null) {
            list.remove(list.size() - 1);
            return;
        }
        if (root.left != null) {
            helper(root.left, sum);
        }
        if (root.right != null) {
            helper(root.right, sum);
        }
        list.remove(list.size() - 1);
    }
}
