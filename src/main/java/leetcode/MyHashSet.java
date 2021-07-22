package leetcode;

import java.util.ArrayList;
import java.util.List;

// 设计哈希集合
public class MyHashSet {
    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));  // true
        System.out.println(hashSet.contains(3));  // false
        hashSet.add(2);
        System.out.println(hashSet.contains(2));  // true
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));  // false

    }
    List<List<Integer>> list;
    /** Initialize your data structure here. */
    public MyHashSet() {
        this.list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            this.list.add(null);
        }
    }

    public void add(int key) {
        int index = getIndex(key);
        List<Integer> subList = this.list.get(index);
        if(subList == null) {
            this.list.set(index, new ArrayList<>());
            this.list.get(index).add(key);
        }else {
            if(!subList.contains(key)) {
                subList.add(key);
            }
        }
    }

    public void remove(int key) {
        int index = getIndex(key);
        List<Integer> subList = this.list.get(index);
        if(subList == null) return;
        else {
            for (int i = 0; i < subList.size(); i++) {
                if(subList.get(i) == key) {
                    subList.remove(i);
                    return;
                }
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = getIndex(key);
        List<Integer> subList = this.list.get(index);
        if(subList == null) return false;
        else {
            if(subList.contains(key)) return true;
        }
        return false;
    }

    public int getIndex(int key) {
        return key % 10000;
    }
}
