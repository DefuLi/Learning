package leetcode;

import java.util.*;

// 常数时间插入、删除和获取随机元素
// 题目说不存在val时才进行插入
// 采用动态数组+哈希方法
public class RandomizedSet {
    public static void main(String[] args) {


        // 初始化一个空的集合。
        RandomizedSet randomSet = new RandomizedSet();
        // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        boolean temp1 = randomSet.insert(1);
        // 返回 false ，表示集合中不存在 2 。
        boolean temp2 = randomSet.remove(2);
        // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        boolean temp3 = randomSet.insert(2);
        // getRandom 应随机返回 1 或 2 。
        int temp4 = randomSet.getRandom();
        // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        boolean temp5 = randomSet.remove(1);
        // 2 已在集合中，所以返回 false 。
        boolean temp6 = randomSet.insert(2);
        // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
        int temp7 = randomSet.getRandom();

        System.out.println(temp1);
        System.out.println(temp2);
        System.out.println(temp3);
        System.out.println(temp4);
        System.out.println(temp5);
        System.out.println(temp6);
        System.out.println(temp7);
    }

    List<Integer> list;
    Map<Integer, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            int end = list.get(list.size() - 1);
            list.set(list.size() - 1, list.get(index));  // 要删除的元素放置在最后
            list.set(index, end);  // 最后元素放置在要删除元素的位置
            map.put(end, index);
            list.remove(list.size() - 1);  // 删除最后一位
            map.remove(val);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
