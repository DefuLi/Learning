package leetcode;

// 两两交换链表中的节点
public class SwapPairs {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        SwapPairs obj = new SwapPairs();
        ListNode head = obj.swapPairs(node1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    /** 递归
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode res =  helper(head);
        return res;
    }

    public ListNode helper(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head.next.next;
        ListNode res = head.next;
        head.next.next = head;
        head.next = helper(temp);
        return res;
    }

}
