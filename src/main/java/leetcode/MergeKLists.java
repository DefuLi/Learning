package leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// 合并K个排序链表
public class MergeKLists {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;

        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);
        node7.next = node8;

        ListNode[] lists = {node1, node4, node7};
        MergeKLists obj = new MergeKLists();
        ListNode res = obj.mergeKLists(lists);
        while (res != null) {  // 输出
            System.out.println(res.val);
            res = res.next;
        }
    }

    /**
     * 使用优先队列来解决
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;  // 共有len条链
        if(len == 0) return null;
        Queue<ListNode> comeon = new PriorityQueue<>(len, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });  // 小顶堆优先队列 哈哈

        for (int i = 0; i < len; i++) {
            if(lists[i] != null) comeon.offer(lists[i]);
        }
        ListNode rootPre = new ListNode(-1);
        ListNode currNode = rootPre;
        while (!comeon.isEmpty()) {
            currNode.next = comeon.poll();
            currNode = currNode.next;
            if(currNode.next != null) comeon.offer(currNode.next);

        }
        return rootPre.next;
    }
    /** 这是分治算法，其实就是对lists数组分而治之，先折半处理，然后处理
     *     public ListNode mergeKLists(ListNode[] lists) {
     *         int len = lists.length;
     *         if (len == 0) {
     *             return null;
     *         }
     *         return mergeKLists(lists, 0, len - 1);
     *     }
     *
     *     public ListNode mergeKLists(ListNode[] lists, int l, int r) {
     *          // 思考这里为什么取等于？这是因为根据下文对 mergeKLists 的递归调用情况，区间最窄的时候，只可能是左右端点重合
     *         if (l == r) {
     *             return lists[l];
     *         }
     *         int mid = (r - l) / 2 + l;
     *         ListNode l1 = mergeKLists(lists, l, mid);
     *         ListNode l2 = mergeKLists(lists, mid + 1, r);
     *         return mergeTwoSortedListNode(l1, l2);
     *     }
     *
     *       private ListNode mergeTwoSortedListNode(ListNode l1, ListNode l2) {
     *         if (l1 == null) {
     *             return l2;
     *         }
     *         if (l2 == null) {
     *             return l1;
     *         }
     *         if (l1.val < l2.val) {
     *             l1.next = mergeTwoSortedListNode(l1.next, l2);
     *             return l1;
     *         }
     *         l2.next = mergeTwoSortedListNode(l1, l2.next);
     *         return l2;
     *     }
     */
}
