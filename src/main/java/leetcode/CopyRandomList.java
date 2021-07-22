package leetcode;

import java.util.HashMap;
import java.util.Map;

// 复制带随机指针的链表
public class CopyRandomList {
    public static void main(String[] args) {
        RandomList node1 = new RandomList(7);
        RandomList node2 = new RandomList(13);
        RandomList node3 = new RandomList(11);
        RandomList node4 = new RandomList(10);
        RandomList node5 = new RandomList(1);

        node1.next = node2;
        node1.random = null;
        node2.next = node3;
        node2.random = node1;
        node3.next = node4;
        node3.random = node5;
        node4.next = node5;
        node4.random = node3;
        node5.next = null;
        node5.random = node1;

        CopyRandomList obj = new CopyRandomList();
        RandomList res = obj.copyRandomList(node1);
        while (res != null) {
            System.out.println(res.val);
            if(res.random != null) {
                System.out.println(res.random.val);
            }else {
                System.out.println(res.random);
            }
            res = res.next;
        }
    }

    // 巧妙方法
    public RandomList copyRandomList1(RandomList head) {
        if(head == null) return null;
        RandomList node = head;
        while (node != null) {
            RandomList temp = new RandomList(node.val);
            RandomList nodeNext = node.next;
            node.next = temp;
            temp.next = nodeNext;
            node = node.next.next;
        }
        node = head;
        while (node != null) {
            if(node.random == null) {
                node.next.random = null;
            }else {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        node = head;
        RandomList res = head.next;
        while (node.next.next != null) {
            RandomList nodeNext = node.next;
            node.next = node.next.next;
            nodeNext.next = node.next.next;
            nodeNext = nodeNext.next;
            node = node.next;
        }
        node.next = null;
        return res;
    }
    // 使用HashMap<Node1, Node2>进行映射的维护。
    public RandomList copyRandomList(RandomList head) {
        if (head == null) return null;
        Map<RandomList, RandomList> map = new HashMap<>();
        RandomList node1 = head;  // 原链表
        RandomList node2 = new RandomList(head.val);  // 拷贝链表
        map.put(node1, node2);
        RandomList res = node2;
        while (node1 != null) {
            if (map.containsKey(node1.next)) {
                node2.next = map.get(node1.next);
            } else {
                if (node1.next != null) {
                    node2.next = new RandomList(node1.next.val);
                    map.put(node1.next, node2.next);
                } else {
                    node2.next = null;
                }
            }
            if (node1.random == null) {
                node2.random = null;
            } else {
                if (map.containsKey(node1.random)) {
                    node2.random = map.get(node1.random);
                } else {
                    node2.random = new RandomList(node1.random.val);
                    map.put(node1.random, node2.random);
                }
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return res;
    }

}

// 随机指针链表
class RandomList {
    int val;
    RandomList next;
    RandomList random;

    RandomList(int val) {
        this.val = val;
    }
}
