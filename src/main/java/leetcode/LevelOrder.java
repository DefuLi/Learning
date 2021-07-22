package leetcode;

// 二叉树的层次遍历
public class LevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        root.left = node2;
        root.right = node3;
        node3.left = node4;
        node3.right = node5;
        LevelOrder obj = new LevelOrder();
//        List<List<Integer>> list = obj.levelOrder(root);
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = 0; j < list.get(i).size(); j++) {
//                System.out.println(list.get(i).get(j));
//            }
//            System.out.println("*********");
//        }
    }

    /**
     * 该解法对应于剑指offer 32-I 题
     public int[] levelOrder(TreeNode root) {
     List<Integer> list = new ArrayList<>();
     if (root == null) return new int[0];
     Queue<TreeNode> queue = new LinkedList<>();
     queue.offer(root);
     while (!queue.isEmpty()) {
     TreeNode node = queue.poll();
     list.add(node.val);
     // 填入队列中
     if (node.left != null) queue.offer(node.left);
     if (node.right != null) queue.offer(node.right);
     }
     int[] res = new int[list.size()];
     for (int i = 0; i < list.size(); i++) {
     res[i] = list.get(i);
     }
     return res;
     }
     */

    /**
     * 该解法对应于剑指offer 32-II 题
     public List<List<Integer>> levelOrder(TreeNode root) {
     List<List<Integer>> list = new ArrayList<>();
     if (root == null) return list;
     Queue<TreeNode> queue = new LinkedList<>();
     queue.offer(root);
     while (!queue.isEmpty()) {
     int size = queue.size();
     List<Integer> level = new ArrayList<>();
     while (size-- > 0) {
     TreeNode node = queue.poll();
     level.add(node.val);
     // 填入队列中
     if (node.left != null) queue.offer(node.left);
     if (node.right != null) queue.offer(node.right);
     }
     list.add(level);
     }
     return list;
     }
     */

    /**
     * 该解法对应于剑指offer 32-III 题
     * 两个栈交替使用 栈1存储奇数层节点 并且往栈2中存储该节点的左右子节点
     *              栈2存储偶数层节点 并且往栈1中存储该节点的右左子节点
     public List<List<Integer>> levelOrder(TreeNode root) {
     List<List<Integer>> list = new ArrayList<>();
     if(root == null) return list;
     Stack<TreeNode> stack1 = new Stack<>();  // 存储奇数层
     Stack<TreeNode> stack2 = new Stack<>();  // 存储偶数层
     stack1.push(root);
     while (!stack1.isEmpty() || !stack2.isEmpty()) {
     int size = 0;
     while (!stack1.isEmpty()) {
     List<Integer> level = new ArrayList<>();
     size = stack1.size();
     while (size-- > 0) {
     TreeNode node = stack1.pop();
     level.add(node.val);
     if(node.left != null) stack2.push(node.left);
     if(node.right != null) stack2.push(node.right);
     }
     list.add(level);
     }
     while (!stack2.isEmpty()) {
     List<Integer> level = new ArrayList<>();
     size = stack2.size();
     while (size-- > 0) {
     TreeNode node = stack2.pop();
     level.add(node.val);
     if(node.right != null) stack1.push(node.right);
     if(node.left != null) stack1.push(node.left);
     }
     list.add(level);
     }
     }
     return list;
     }
     */
}
