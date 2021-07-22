package leetcode;

// 合并两个有序链表
public class MergeTwoLists {
    public static void main(String[] args) {
         ListNode head1 = new ListNode(-2);
         ListNode node1 = new ListNode(5);

         ListNode head2 = new ListNode(-9);
         ListNode node7 = new ListNode(-6);
         ListNode node8 = new ListNode(-3);
         ListNode node9 = new ListNode(-1);
         ListNode node10 = new ListNode(1);
         ListNode node11 = new ListNode(6);

         head1.next = node1;
         node1.next = null;
         head2.next = node7;
         node7.next = node8;
         node8.next = node9;
         node9.next = node10;
         node10.next = node11;
         node11.next = null;

        MergeTwoLists obj = new MergeTwoLists();
        ListNode res = obj.mergeTwoLists(head1, head2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    /**
     * 递归的方法
     * list1[0] + mergeTwoLists(list1[1:], list2) 当list1[0] < list2[0]
     * list2[0] + mergeTwoLists(list1, list2[1:]) 其它条件
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 迭代的方法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode flag1 = l1;
        ListNode flag2 = l2;
        ListNode head;
        if (l1.val <= l2.val) head = l1;
        else head = l2;
        while (flag1 != null && flag2 != null) {
            if (flag1.val <= flag2.val) {
                ListNode temp = flag1;
                while (flag1.val <= flag2.val) {
                    temp = flag1;
                    flag1 = flag1.next;
                    if (flag1 == null) break;
                }
                if (flag1 == null) {
                    temp.next = flag2;
                    break;
                }
                temp.next = flag2;
                ListNode temp1 = flag2.next;
                flag2.next = flag1;
                flag1 = temp.next;
                flag2 = temp1;

            } else {
                ListNode temp = flag2;
                while (flag2.val < flag1.val) {
                    temp = flag2;
                    flag2 = flag2.next;
                    if (flag2 == null) break;
                }
                if (flag2 == null) {
                    temp.next = flag1;
                    break;
                }
//                ListNode temp1 = flag2.next;
                temp.next = flag1;
//                flag2 = temp1.next;
            }
        }
        return head;
    }
}
