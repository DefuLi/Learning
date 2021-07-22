package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 寻找重复子树
public class FindDuplicateSubtrees {
    public static void main(String[] args) {
        FindDuplicateSubtrees obj = new FindDuplicateSubtrees();

        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        obj.findDuplicateSubtrees(root);
    }

    /**  对树进行序列化
     * String res = "";
     * public String serialize(TreeNode node) {
     * if(node == null) {
     * res += "#";
     * return res;
     * }else {
     * res += node.val;
     * serialize(node.left);
     * serialize(node.right);
     * }
     * return res;
     * }
     */

    Map<String, Integer> count;
    List<TreeNode> ans;

    /**
     * 对各个子树进行序列化，然后存在Map中
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap();
        ans = new ArrayList();
        collect(root);
        return ans;
    }

    public String collect(TreeNode node) {
        if (node == null) return "#";
        String serial = node.val + "," + collect(node.left) + "," + collect(node.right);
        System.out.println(serial);
        count.put(serial, count.getOrDefault(serial, 0) + 1);
        if (count.get(serial) == 2)
            ans.add(node);
        return serial;
    }
}
