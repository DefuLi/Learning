package cleancode.leetcode;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

/**
 * 打开转盘锁
 *
 * @author Defu Li
 * @since 2021/8/5 0:23
 */
public class LeetCode752 {
    public static void main(String[] args) {
        LeetCode752 obj = new LeetCode752();
        String[] deadends = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        String target = "8888";

//        String[] deadends = {"8888"};
//        String target = "0002";
        System.out.println(obj.openLock(deadends, target));
    }

    public int openLock(String[] deadends, String target) {
        int result = bfs(deadends, target);
        return result == 0 ? -1 : result;
    }

    public int bfs(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        Set<String> visited = new HashSet<>();
        putStringToSet(deadends, set);

        String head = "0000";
        Queue<String> queue = new LinkedList<>();
        queue.offer(head);

        int count = 1;
        while (!queue.isEmpty()) {
            int currSize = queue.size();
            for (int i = 0; i < currSize; i++) {
                String currStr = queue.poll();
                if (set.contains(currStr)) {
                    continue;
                }
                List<String> list = genUpAndDown(currStr);
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).equals(target)) {
                        return count;
                    }
                    if (!visited.contains(list.get(j))) {
                        queue.offer(list.get(j));
                    }
                }
            }
            count++;
            System.out.println(count);
        }
        return count;
    }

    public void putStringToSet(String[] deadends, Set<String> set) {
        for (int i = 0; i < deadends.length; i++) {
            set.add(deadends[i]);
        }
    }

    /**
     * 问题出在了这个函数
     * @param currString
     * @return
     */
    public List<String> genUpAndDown(String currString) {
        List<String> list = new ArrayList<>();
        char[] chars = currString.toCharArray();
        String str;
        for (int i = 0; i < chars.length; i++) {
            chars[i] = chars[i] + 1 > '9' ? '0' : (char) (chars[i] + 1);
            str = String.valueOf(chars);
            list.add(str);
            chars[i] = chars[i] - 2 < '0' ? '9' : (char) (chars[i] - 2);
            str = String.valueOf(chars);
            list.add(str);
            chars[i] = chars[i] + 1 > '9' ? '0' : (char) (chars[i] + 1);
        }
        return list;
    }
}
