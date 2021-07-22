package leetcode;

// 奇偶链表
public class OddEvenList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        OddEvenList obj = new OddEvenList();
        ListNode res = obj.oddEvenList(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return head;
        ListNode odd = head;
        ListNode even = odd.next;
        ListNode oddHead = head;
        ListNode evenHead = odd.next;
        while (true){
            odd.next = odd.next.next;
            if(odd.next == null) {
                even.next = null;
                odd.next = evenHead;
                return oddHead;
            }
            if(odd.next.next == null){
                even.next = odd.next.next;
                odd = odd.next;
                odd.next = evenHead;
                return oddHead;
            }else even.next = odd.next.next;

            odd = odd.next;
            even = even.next;
        }
    }
}
