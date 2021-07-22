package leetcode;

// 链表中倒数第K个节点
public class GetKthFromEnd {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        GetKthFromEnd obj = new GetKthFromEnd();
        ListNode res = obj.getKthFromEnd(node1, 2);
        while (res != null) {  // 4 -> 5
            System.out.println(res.val);
            res = res.next;
        }
    }

    /**
     * 设置一个大小为k-1的窗口 一直往后滑
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null) return null;
        if(k == 0) return null;
        ListNode start = head;
        ListNode end = head;
        for (int i = 0; i < k - 1; i++) {
            if(end == null) return null;
            end = end.next;
        }
        while (end.next != null) {
            start = start.next;
            end = end.next;
        }
        return start;
    }
}
