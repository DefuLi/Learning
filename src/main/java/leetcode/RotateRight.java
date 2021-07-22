package leetcode;

// 旋转链表
public class RotateRight {
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
        RotateRight obj = new RotateRight();
        ListNode res = obj.rotateRight(head, 2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int len = getLen(head);
        int nums = k % len;
        if(nums == 0) return head;
        int startNums = len - nums - 1;
        int endNums = len - 1;
        ListNode start = head;  // 双指针技巧
        ListNode end = head;
        for (int i = 0; i < startNums; i++) {
            start = start.next;
        }
        for (int i = 0; i < endNums; i++) {
            end = end.next;
        }
        ListNode res = start.next;
        start.next = null;
        end.next = head;
        return res;
    }

    // 获取长度
    public int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
