package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheII {

    // 自定义链表节点
    class Node {
        Node pre;
        Node next;
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    LRUCacheII(int capacity) {
        map = new HashMap<>();
        head = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToLast(node);
            return node.value;
        } else return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // 删除并移动最后
            if(map.get(key).value != value) {
                map.get(key).value = value;
            }
            Node node = map.get(key);
            moveToLast(node);
            map.put(key, node);
        } else {
            Node node = new Node(key, value);
            if (map.size() == capacity) {
                // lru清除一个
                int keyFirst = deleteFirst();
                addLast(node);
                map.remove(keyFirst);
                map.put(key, node);
            } else {
                addLast(node);
                map.put(key ,node);
            }
        }
    }

    public void moveToLast(Node node) {
        if (node.next == tail) {
            return;
        } else {
            Node temp = node.next;
            node.pre.next = temp;
            temp.pre = node.pre;

            tail.pre.next = node;
            node.pre = tail.pre;
            tail.pre = node;
            node.next = tail;
        }
    }

    public int deleteFirst() {
        int res = head.next.key;
        head.next = head.next.next;
        head.next.pre = head;
        return res;
    }

    public void addLast(Node node) {
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
    }

    public static void main(String[] args) {
        LRUCacheII lruCache = new LRUCacheII(2);
        lruCache.put(2,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(2));
        lruCache.put(1,1);
        lruCache.put(4,1);
        System.out.println(lruCache.get(2));
    }
}
