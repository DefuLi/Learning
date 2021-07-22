package leetcode;
// 相交链表
/**
 * 好的解决方案是先算出来两条链表的长度，
 * 较长的链表从头节点去除多出来的部分，
 * 然后两个链表同步遍历。
 */
public class GetIntersectionNode {
    public static void main(String[] args) {
        ListNode headA = new ListNode(0);
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode headB = new ListNode(3);
        headA.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        headB.next = node3;
        GetIntersectionNode obj = new GetIntersectionNode();
        System.out.println(obj.getIntersectionNode(headA, headB).val);
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode slow = headA;
        ListNode fast = headB;
//        ListNode flag = headB;
        while (slow != fast){
            if(slow == null) return null;
            if(fast == null) {
                slow = slow.next;
//                flag = flag.next;
                fast = headB;
            }else {
                fast = fast.next;
            }
        }
        return slow;
    }
}
