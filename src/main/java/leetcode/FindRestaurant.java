package leetcode;

import java.util.*;

// 两个列表的最小索引总和
public class FindRestaurant {
    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        FindRestaurant obj = new FindRestaurant();
        System.out.println(Arrays.toString(obj.findRestaurant(list1, list2)));
    }

    /**
     * 可以在HashMap<Index, List<String>>中存储。这样比较好。
     * @param list1
     * @param list2
     * @return
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();  // 存储list1和index
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);  // val值存储索引
        }
        Map<String, Integer> map2 = new HashMap<>();  // 存储list1和list2相同餐馆，和索引和
        for (int i = 0; i < list2.length; i++) {
            if (map1.containsKey(list2[i])) {  // list1和list2中有相同餐馆
                map2.put(list2[i], map1.get(list2[i]) + i);
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map2.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        int head = list.get(0).getValue();
        int nums = 1;
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i).getValue() != head) {
                break;
            }else {
                head = list.get(i).getValue();
                nums++;
            }
        }
        String[] res = new String[nums];
        for (int i = 0; i < nums; i++) {
            res[i] = list.get(i).getKey();
        }
        return res;
    }
}
