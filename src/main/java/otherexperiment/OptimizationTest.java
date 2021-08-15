package otherexperiment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Defu Li
 * @since 2021/6/20 0:33
 */
public class OptimizationTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayListCustomizeSize();
        for (int i = 0; i < 100000000; i++) {
            list.add(1);
        }

        OptimizationTest.loopIneffective(list);
    }

    /**
     * 消除循环的低效率
     *
     * @param list 整数大集合
     */
    public static void loopIneffective(List<Integer> list) {
        // 优化前
        long start = System.nanoTime();
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        long end = System.nanoTime();
        System.out.println(end - start);

        // 优化后
        start = System.nanoTime();
        sum = 0;
        int len = list.size();
        for (int i = 0; i < len; i++) {
            sum += list.get(i);
        }
        end = System.nanoTime();
        System.out.println(end - start);

    }

    static class ArrayListCustomizeSize extends ArrayList<Integer> {
        @Override
        public int size() {
            int length = 0;
            for (int i = 0; i < super.size(); i++) {
                length++;
            }
            return length;
        }
    }
}
