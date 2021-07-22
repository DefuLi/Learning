package leetcode;

import java.util.ArrayList;
import java.util.List;

// 回文链表
public class IsPalindrome {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode nodeTemp = new ListNode(5);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(1);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = nodeTemp;
        nodeTemp.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;


        IsPalindrome obj = new IsPalindrome();
        System.out.println(obj.isPalindrome(head));
        /**
        List<ListNode> list = obj.getReversedList(head);
        ListNode res1 = list.get(0);
        ListNode res2 = list.get(1);
        while (res1 != null) {
            System.out.println(res1.val);
            res1 = res1.next;
        }
        while (res2 != null) {
            System.out.println(res2.val);
            res2 = res2.next;
        }
         */
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        List<ListNode> list = getReversedList(head);
        ListNode res1 = list.get(0);
        ListNode res2 = list.get(1);
        while (res1 != null){
            if(res1.val != res2.val){
                return false;
            }
            res1 = res1.next;
            res2 = res2.next;
        }
        return true;
    }

    // 获取链表长度
    public int getLen(ListNode head) {
        int nums = 0;
        ListNode temp = head;
        while (temp != null) {
            nums++;
            temp = temp.next;
        }
        return nums;
    }

    // 对一半的链表进行逆序操作
    public List<ListNode> getReversedList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        int len = getLen(head);

        ListNode flag = head;
        ListNode temp;
        int i = 1;
        if (len % 2 == 0) {
            while (i < len / 2) {
                temp = flag.next.next;
                flag.next.next = head;
                head = flag.next;
                flag.next = temp;
                i++;
            }
            temp = flag.next;
            flag.next = null;
            list.add(head);
            list.add(temp);
        }else {
            while (i < len / 2) {
                temp = flag.next.next;
                flag.next.next = head;
                head = flag.next;
                flag.next = temp;
                i++;
            }
            temp = flag.next.next;
            flag.next = null;
            list.add(head);
            list.add(temp);
        }
        return list;
    }
}
