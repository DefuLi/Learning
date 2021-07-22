package leetcode;

// 删除链表的节点
public class DeleteNodeII {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        DeleteNodeII obj = new DeleteNodeII();
        ListNode res = obj.deleteNode(node1, 4);  // 4 -> 5 -> 9
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next;  // 要删除的是头节点
        ListNode res = head;
        ListNode pre = head;
        head = head.next;
        while (head != null) {
            if(head.val == val) {
                pre.next = head.next;
                return res;
            }
            pre = head;
            head = head.next;
        }
        return res;
    }
}
