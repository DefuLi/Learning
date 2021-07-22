package leetcode;

// 二叉树的序列化与反序列化

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对于一棵二叉树，我一开始的思路是使用前序遍历，null节点用#表示，这样就可以表示为-10##1#1
 * 但是问题是在解码的时候，无法识别出-1，或者多位一起。
 * 所以使用空格，这样就变成了-1 0 # # 1 # #
 *
 * 加上空格，不然没法识别50，有可能会识别成5和0
 */
public class SerializeAndDeserialize {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(-1);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        SerializeAndDeserialize obj = new SerializeAndDeserialize();

//        Integer i = 0;
//        obj.re(i);
//        System.out.println(i);

        String encodeStr = obj.serialize(node1);
        System.out.println(encodeStr);  // 12##34##5##  前序遍历序列化
        System.out.println(obj.deserialize(encodeStr).val);  // -1
    }

//    public void re(Integer i) {
//        if(i > 100) return;
//        i++;
//        re(i);
//    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        ser(root, stringBuilder);
        return stringBuilder.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strSplit = data.split(" ");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < strSplit.length; i++) {
            queue.offer(strSplit[i]);
        }
        TreeNode root = deser(queue);
        return root;
    }

    // 序列化辅助函数
    public StringBuilder ser(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append("#" + " ");
            return stringBuilder;
        }
        stringBuilder.append(String.valueOf(root.val)+" ");
        ser(root.left, stringBuilder);
        ser(root.right, stringBuilder);
        return stringBuilder;
    }

    public TreeNode deser(Queue<String> encode) {
        if(encode.size() == 0) return null;
        String curr = encode.poll();
        if(curr.equals("#")) return null;

        TreeNode node = new TreeNode(Integer.valueOf(curr));
        node.left = deser(encode);
        node.right = deser(encode);
        return node;
    }
}
