package leetcode;

import java.util.Stack;

// 二叉搜索树迭代器

/**
 * 使用一个栈，先把二叉树左子树中所有左节点存入stack中
 * 然后弹出栈顶元素，这就是next要返回的值
 * 但是在弹出栈顶元素后，需要将该元素右子树中所有左节点存入stack中
 */
public class BSTIterator {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(20);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        BSTIterator iterator = new BSTIterator(node1);
        System.out.println(iterator.next());  // 3
        System.out.println(iterator.next());  // 7
        System.out.println(iterator.hasNext());  // true
        System.out.println(iterator.next());  // 9
        System.out.println(iterator.hasNext());  // true
        System.out.println(iterator.next());  // 15
        System.out.println(iterator.hasNext());  // true
        System.out.println(iterator.next());  // 20
        System.out.println(iterator.hasNext());  // false
    }

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();  // 将根节点的所有左子树的左节点装入stack
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode currNode = stack.pop();
        int res = currNode.val;
        if (currNode.right == null) return res;
        currNode = currNode.right;
        while (currNode != null) {
            stack.push(currNode);
            currNode = currNode.left;
        }
        return res;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        if (stack.isEmpty()) return false;
        else return true;
    }

}
