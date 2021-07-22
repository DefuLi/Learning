package swordoffer;

// 剑指offer 面试题25 合并两个排序的链表
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        node5.next = node6;
        MergeTwoLists obj = new MergeTwoLists();
        ListNode res = obj.mergeTwoLists(node1, node4);
        ReverseList.printListNode(res);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode fakeHead = new ListNode(666);
        ListNode res = fakeHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                fakeHead.next = l1;
                l1 = l1.next;
            } else {
                fakeHead.next = l2;
                l2 = l2.next;
            }
            fakeHead = fakeHead.next;
        }
        fakeHead.next = l1 != null ? l1 : l2;
        return res.next;
    }
}
