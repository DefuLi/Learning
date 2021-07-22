package leetcode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    Map<Integer, Integer> map;
    LinkedList<Integer> list;
    Integer capacity;
    public LRUCache(int capacity) {
        map = new HashMap();
        list = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            list.remove(new Integer(key));
            list.addLast(key);
            return map.get(key);
        } else return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            list.remove(new Integer(key));
            list.addLast(key);
            map.put(key, value);
        }else {
            if(map.size() == capacity) {
                // lru清除一个缓存
                lruClear(key, value);
            }else {
                list.addLast(key);
                map.put(key, value);
            }
        }
    }

    private void lruClear(int key, int value) {
        Integer first = list.removeFirst();
        list.addLast(key);
        map.remove(first);
        map.put(key ,value);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
