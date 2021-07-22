package leetcode;

// 反转链表
public class ReverseList {
    // 迭代
    public ListNode fun(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode flag = head;
        ListNode temp;
        while (flag != null && flag.next != null) {
            temp = flag.next.next;
            flag.next.next = head;
            head = flag.next;
            flag.next = temp;
        }
        return head;
    }
    /**
     //递归
     public ListNode fun(ListNode head){
     if(head == null || head.next == null){
     return head;
     }
     ListNode root = fun(head.next);
     head.next.next = head;
     head.next = null;
     return root;
     }
     */

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ReverseList reverseList = new ReverseList();
        ListNode node = reverseList.fun(node1);
        for(int i=0; i<5; i++){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
