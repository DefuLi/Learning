package leetcode;

// 删除链表中的节点
public class DeleteNodeIII {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        DeleteNodeIII obj = new DeleteNodeIII();
        obj.deleteNode(node2);
    }

    /**
     * 用node节点后面的节点  覆盖掉node节点 并且node节点直接指向后后面的节点
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
