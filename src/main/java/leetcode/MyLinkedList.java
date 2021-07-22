package leetcode;

// 设计链表
public class MyLinkedList {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(4);
        linkedList.get(1);
        linkedList.addAtHead(1);
        linkedList.addAtHead(5);
        linkedList.deleteAtIndex(3);
        linkedList.addAtHead(7);
        linkedList.get(3);
        linkedList.get(3);
        linkedList.get(3);
        linkedList.addAtHead(1);
        linkedList.deleteAtIndex(4);
    }

    public ListNode head;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= getLen(head)) return -1;
        ListNode temp = head;
        for (int i = 0; i < index; i++) {
            if (temp == null) return -1;
            temp = temp.next;
        }
        return temp.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        ListNode temp = head;
        head = node;
        head.next = temp;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = new ListNode(val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            ListNode temp = new ListNode(val);
            temp.next = head;
            head = temp;
        }
        int len = getLen(head);
        if (index == len) {  // 在链表末尾添加
            addAtTail(val);
        } else if (index < 0) {
            addAtHead(val);
        } else {
            ListNode temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            ListNode temp1 = temp.next;
            temp.next = new ListNode(val);
            temp = temp.next;
            temp.next = temp1;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        int len = getLen(head);
        if (index < len && index >= 0) {
            if (index == 0) {
                head = head.next;
            } else {
                ListNode temp = head;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
                ListNode temp1 = temp.next.next;
                temp.next = temp1;
            }
        }
    }

    // 获取链表的长度
    public int getLen(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        return len;
    }
}
