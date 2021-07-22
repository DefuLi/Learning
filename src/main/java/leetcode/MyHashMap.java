package leetcode;

import java.util.ArrayList;
import java.util.List;

// 设计哈希映射
public class MyHashMap {
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));  // 返回 1
        System.out.println(hashMap.get(3));  // 返回 -1 (未找到)
        hashMap.put(2, 1);  // 更新已有的值
        System.out.println(hashMap.get(2));  // 返回 1
        hashMap.remove(2);  // 删除键为2的数据
        System.out.println(hashMap.get(2));  // 返回 -1 (未找到)
    }

    List<MapList> list;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(null);
        }
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int index = getIndex(key);
        if (this.list.get(index) == null) {
            this.list.set(index, new MapList(key, value));
        } else {
            MapList head = this.list.get(index);
            while (head.next != null) {
                if (head.kVal == key) {
                    head.vVal = value;
                    return;
                } else {
                    head = head.next;
                }
            }
            if (head.kVal == key) {
                head.vVal = value;
                return;
            }
            head.next = new MapList(key, value);
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int index = getIndex(key);
        if (this.list.get(index) == null) return -1;
        MapList head = this.list.get(index);
        while (head != null) {
            if (head.kVal == key) return head.vVal;
            head = head.next;
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int index = getIndex(key);
        if (this.list.get(index) == null) return;
        MapList head = this.list.get(index);
        if (head.kVal == key) {  // 如果为头节点
            this.list.set(index, head.next);
            return;
        }
        MapList pre = head;
        while (head != null) {
            if (head.kVal == key) {  // 需要移除该节点
                pre.next = head.next;
                return;
            }
            pre = head;
            head = head.next;
        }
    }

    public int getIndex(int key) {
        return key % 10000;
    }
}

class MapList {
    public int kVal;
    public int vVal;
    public MapList next;

    MapList(int kVal, int vVal) {
        this.kVal = kVal;
        this.vVal = vVal;

    }
}