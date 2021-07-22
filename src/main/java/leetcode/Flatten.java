package leetcode;

import java.util.Stack;

// 扁平化多级双向链表
public class Flatten {
    public static void main(String[] args) {
        DoubleList node1 = new DoubleList(1);
        DoubleList node2 = new DoubleList(2);
        DoubleList node3 = new DoubleList(3);
        DoubleList node4 = new DoubleList(4);
        DoubleList node5 = new DoubleList(5);
        DoubleList node6 = new DoubleList(6);
        DoubleList node7 = new DoubleList(7);
        DoubleList node8 = new DoubleList(8);
        DoubleList node9 = new DoubleList(9);
        DoubleList node10 = new DoubleList(10);
        DoubleList node11 = new DoubleList(11);
        DoubleList node12 = new DoubleList(12);

        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node3.child = node7;
        node4.next = node5;
        node5.prev = node4;
        node5.next = node6;
        node6.prev = node5;

        node7.next = node8;
        node8.prev = node7;
        node8.next = node9;
        node9.prev = node8;
        node8.child = node11;
        node9.next = node10;
        node10.prev = node9;
        node11.next = node12;
        node12.prev = node11;
        Flatten obj = new Flatten();
        DoubleList res = obj.flatten(node1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public DoubleList flatten(DoubleList head) {
        if (head == null || (head.next == null && head.child == null)) return head;
        Stack<DoubleList> stack = new Stack();
        DoubleList node = head;
        while (!stack.isEmpty() || node.next != null || node.child != null) {
            if (node.child != null) {
                if (node.next != null) stack.push(node.next);
                node.next = node.child;
                node.child.prev = node;
                node.child = null;
                node = node.next;
            } else {
                if (node.next == null && !stack.isEmpty()) {
                    DoubleList nextDoubleList = stack.pop();
                    node.next = nextDoubleList;
                    nextDoubleList.prev = node;
                    node = node.next;
                } else {
                    node = node.next;
                }
            }
        }
        return head;
    }
}

// 扁平化多级双向链表
class DoubleList {
    public int val;
    public DoubleList prev;
    public DoubleList next;
    public DoubleList child;

    DoubleList(int val) {
        this.val = val;
    }
}