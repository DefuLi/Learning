package swordoffer;

/*
import leetcode.ListNode;

// 剑指offer 52题 两个链表的第一个公共节点
public class GetIntersectionNodeII {
    public static void main(String[] args) {
        GetIntersectionNodeII obj = new GetIntersectionNodeII();
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(0);
        ListNode node8 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node6.next = node7;
        node7.next = node8;
        node8.next = node3;

        System.out.println(obj.getIntersectionNode(node1, node6).val);

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int lenA = 0;
        int lenB = 0;
        ListNode copyA = headA;
        ListNode copyB = headB;
        while (copyA != null) {
            lenA++;
            copyA = copyA.next;
        }
        while (copyB != null) {
            lenB++;
            copyB = copyB.next;
        }

        if(lenA > lenB) {
            int sub = lenA - lenB;
            for (int i = 0; i < sub; i++) {
                headA = headA.next;
            }
        }else {
            int sub = lenB - lenA;
            for (int i = 0; i < sub; i++) {
                headB = headB.next;
            }
        }

        while (headA != null) {
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
*/
