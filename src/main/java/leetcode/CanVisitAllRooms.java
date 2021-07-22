package leetcode;

import java.util.*;

// 钥匙和房间
public class CanVisitAllRooms {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(list1);
        CanVisitAllRooms obj = new CanVisitAllRooms();
        System.out.println(obj.canVisitAllRooms(rooms));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int N = rooms.size();
        // for (int i = 0; i < rooms.size(); i++) {
        //     if(rooms.get(i).size() == 0) N--;
        // }
        for (int i = 0; i < rooms.get(0).size(); i++) {
            queue.offer(rooms.get(0).get(i));
            set.add(rooms.get(0).get(i));
        }
        if(rooms.size() == 1) return true;
        if(queue.isEmpty()) return false;
        set.add(0);
        while (!queue.isEmpty()) {
            if (set.size() == N) {
                return true;
            }
            int i = queue.poll();
            int size = rooms.get(i).size();
            for (int j = 0; j < size; j++) {
                if (!set.contains(rooms.get(i).get(j))) {
                    queue.offer(rooms.get(i).get(j));
                    set.add(rooms.get(i).get(j));
                }
            }
        }
        return false;
    }
}
