package leetcode;

import java.util.ArrayList;
import java.util.Stack;

// 从尾到头打印链表
public class PrintListFromTailToHead {
    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        PrintListFromTailToHead prclass = new PrintListFromTailToHead();
        ArrayList<Integer> list = new ArrayList<>();
        list = prclass.printListFromTailToHead(listNode1);
        for (Integer integer: list) {
            System.out.println(integer);
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
//        递归
//        ArrayList<Integer> list = new ArrayList<>();
//        if(listNode == null){
//            return list;
//        }
//        if(listNode.next == null){
//            list.add(listNode.val);
//            return list;
//        }
//        list = printListFromTailToHead(listNode.next);
//        list.add(listNode.val);
//        return list;

//        栈
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        if(listNode == null){
            return list;
        }
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (stack.size() > 0){
            list.add(stack.pop());
        }
        return list;
    }

}

class ListNode{
    int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}



