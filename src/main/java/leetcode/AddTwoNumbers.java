package leetcode;

// 两数相加
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);
        ListNode node1 = new ListNode(8);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(8);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(5);
        ListNode node8 = new ListNode(7);

        ListNode head2 = new ListNode(6);
        ListNode node21 = new ListNode(7);
        ListNode node22 = new ListNode(8);
        ListNode node23 = new ListNode(0);
        ListNode node24 = new ListNode(8);
        ListNode node25 = new ListNode(5);
        ListNode node26 = new ListNode(8);
        ListNode node27 = new ListNode(9);
        ListNode node28 = new ListNode(7);

        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = null;

        head2.next = node21;
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;
        node24.next = node25;
        node25.next = node26;
        node26.next = node27;
        node27.next = node28;
        node28.next = null;

        AddTwoNumbers obj = new AddTwoNumbers();
        ListNode res = obj.addTwoNumbers(head1, head2);
        obj.printList(res);
    }

    // 打印链表
    public void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0 && getLen(l1) == 1) return l2;
        if (l2.val == 0 && getLen(l2) == 1) return l1;
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode head3 = new ListNode(-100);
        ListNode res = head3;
        int len1 = getLen(l1);
        int len2 = getLen(l2);
        int len = len1;
        int nums = len1 - len2;
        if (nums < 0) {  // 补l1
            head1 = padList(l1, -nums);
            len = len2;
        } else if (nums > 0) {  // 补l2
            head2 = padList(l2, nums);
            len = len1;
        }
//        printList(head1);
        int carry = 0;
        int mod;
        for (int i = 0; i < len; i++) {
            int add = head1.val + head2.val;  // 10
            mod = (add + carry) % 10;  // 2
            carry = (add + carry) / 10;  // 1
            ListNode temp = new ListNode(mod);
            head3.next = temp;
            head3 = head3.next;

            head1 = head1.next;
            head2 = head2.next;
        }
        if (carry == 1) {
            ListNode temp = new ListNode(1);
            head3.next = temp;
        }

        return res.next;
    }

    // 获取链表长度
    public int getLen(ListNode l1) {
        int len = 0;
        while (l1 != null) {
            len++;
            l1 = l1.next;
        }
        return len;
    }

    // 尾部补0
    public ListNode padList(ListNode l1, int nums) {
        ListNode head = l1;
        while (l1.next != null) {
            l1 = l1.next;
        }
        for (int i = 0; i < nums; i++) {
            ListNode temp = new ListNode(0);
            l1.next = temp;
            l1 = l1.next;
        }
        l1.next = null;
        return head;
    }
}
