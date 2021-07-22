package leetcode;

import java.util.HashMap;
import java.util.Map;

// 宝石与石头
public class NumJewelsInStones {
    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        NumJewelsInStones obj = new NumJewelsInStones();
        System.out.println(obj.numJewelsInStones(J, S));
    }

    public int numJewelsInStones(String J, String S) {
        if (J.length() == 0 || S.length() == 0) return 0;
        char[] charJ = J.toCharArray();
        char[] charS = S.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < charJ.length; i++) {
            map.put(charJ[i], 1);
        }
        for (int i = 0; i < charS.length; i++) {
            if (map.containsKey(charS[i])) {
                map.put(charS[i], map.get(charS[i]) + 1);
            }
        }
        int res = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1) {
                res += entry.getValue() - 1;
            }
        }
        return res;
    }
}
