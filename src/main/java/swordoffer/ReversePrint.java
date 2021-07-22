package swordoffer;

import java.util.Arrays;

// 剑指offer 面试题06 从尾到头打印链表
public class ReversePrint {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        ReversePrint obj = new ReversePrint();
        System.out.println(Arrays.toString(obj.reversePrint(head)));
    }

    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        int len = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            len++;
        }
        int[] res = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            res[i] = head.val;
            head = head.next;
        }
        return res;
    }
}


/**
 * 链表节点数据结构
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
