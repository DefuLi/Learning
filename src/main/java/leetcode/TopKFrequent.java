package leetcode;

import java.util.*;

// 前k个高频元素
// 除了我写的这两种方法外，还有一种和第一个优先队列相似的方法
// 维护一个k数目的最小堆，判断新元素和堆顶元素的频率大小  (这里一定是最小堆，不能是最大堆)
// 如果新元素频率大，删除堆顶，并插入新元素
// 最终堆中元素均为前k个频率最高的元素
public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 3};
        TopKFrequent obj = new TopKFrequent();
        System.out.println(obj.topKFrequent(nums, 2));
    }

    /**
     * 建立值-索引的Map
     * 创建基于最大堆的优先队列
     * 获取k次优先队列堆顶的值
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (int i = 0; i < nums.length; i++) {  // 值-索引 存到map中
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            queue.offer(entry);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(queue.poll().getKey());
        }
        return list;
    }

    /**
     * 该方法用冒泡排序前k个HashMap的值和索引数据。
     * <p>
     * 还有一个好方法，就是对HashMap的数据进行桶排序。
     * 具体操作是让HashMap的索引当作数组的下标，HashMap的值当作数组的值。
     * 然后对数组进行倒序输出k个即可。
     * <p>
     * 还有一个好方法，是利用HashMap的数据建立最小堆。
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int topK = 0;
        int topV = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (topV < entry.getValue()) {
                    topK = entry.getKey();
                    topV = entry.getValue();
                }
            }
            map.put(topK, 0);
            list.add(topK);
            topK = 0;
            topV = 0;
        }
        return list;
    }
}




