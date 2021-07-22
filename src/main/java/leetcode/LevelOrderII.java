package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// N叉树的层序遍历
public class LevelOrderII {
    public static void main(String[] args) {
        NTree node1 = new NTree(1);
        NTree node2 = new NTree(3);
        NTree node3 = new NTree(2);
        NTree node4 = new NTree(4);
        NTree node5 = new NTree(5);
        NTree node6 = new NTree(6);
        List<NTree> children1 = new ArrayList<>();
        children1.add(node2);
        children1.add(node3);
        children1.add(node4);
        node1.children = children1;
        List<NTree> children2 = new ArrayList<>();
        children2.add(node5);
        children2.add(node6);
        node2.children = children2;

        LevelOrderII obj = new LevelOrderII();
        List<List<Integer>> res = obj.levelOrder(node1);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.println(res.get(i).get(j));
            }
            System.out.println("************************");
        }

    }

    public List<List<Integer>> levelOrder(NTree root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<NTree> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        res.add(list);
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> listCurr = new ArrayList<>();
            while (size-- > 0) {
                NTree curr = queue.poll();
                List<NTree> children = curr.children;
                int childrenSize = children == null ? 0 : children.size();
                for (int i = 0; i < childrenSize; i++) {
                    queue.offer(children.get(i));
                    listCurr.add(children.get(i).val);
                }
            }
            if(listCurr.size() != 0) res.add(listCurr);
        }
        return res;
    }


}
