package otherexperiment;
import java.util.Stack;

public class QQExtraMoney {
    public static void main(String[] args) {
        QQExtraMoney obj = new QQExtraMoney();

        Node node1 = new Node(null);
        Node node2 = new Node('a');
        Node node3 = new Node('b');
        Node node4 = new Node('b');
        Node node5 = new Node('a');

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Stack<Node> stack = new Stack<>();
        obj.storageStack(stack, node1);
        boolean res = obj.isPalindrome(stack, node1);
        if(res == true) System.out.println("是回文数");
        else System.out.println("不是回文数");
    }

    public void storageStack(Stack<Node> stack, Node head) {
        Node temp = head.next;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
    }

    public boolean isPalindrome (Stack<Node> stack, Node head) {
        Node temp = head.next;
        while (!stack.empty()) {
            if(stack.pop().c != temp.c) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

}

// 单链表节点
class Node{
    Character c;
    Node next;
    public Node(Character c) {
        this.c = c;
    }
}