package leetcode;

// 环形链表Ⅱ
public class DetectCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        DetectCycle obj = new DetectCycle();
        System.out.println(obj.detectCycle(head).val);
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        slow = head.next;
        if(head.next == null) return null;
        fast = head.next.next;
        if(slow == null || fast == null) return null;
        if (slow == fast) return slow;
        while (slow != fast){
            if(slow == null || fast == null) return null;
            slow = slow.next;
            if(slow.next == null || fast.next == null) return null;

            fast = fast.next.next;
        }
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
