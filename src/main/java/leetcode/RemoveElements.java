package leetcode;

// 移除链表元素
public class RemoveElements {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
//        ListNode head = new ListNode(1);
//        ListNode node1 = new ListNode(2);
//        ListNode node2 = new ListNode(6);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(6);
//        head.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = null;

        RemoveElements obj = new RemoveElements();
        ListNode res = obj.removeElements(head, 2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        while (head.val == val) {
            head = head.next;
            if (head == null) return head;
        }
        ListNode flag = head;
        while (flag != null) {
            if (flag.next == null) return head;
            if (flag.next.val == val) {  // 需要删除该节点
                flag.next = flag.next.next;
            } else {
                flag = flag.next;
            }
        }
        return head;
    }
}
