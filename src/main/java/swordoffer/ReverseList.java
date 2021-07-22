package swordoffer;

// 剑指offer 面试题24 反转链表
public class ReverseList {
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
        ReverseList obj = new ReverseList();
        ListNode res = obj.reverseList(node1);
        printListNode(res);
    }

    /**
     * 静态方法
     * 打印链表
     * @param head
     */
    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode node;
        ListNode pre = head;
        ListNode back = head.next;
        while (back != null) {
            node = back.next;
            back.next = pre;
            pre = back;
            back = node;
        }
        head.next = null;
        return pre;
    }
}
