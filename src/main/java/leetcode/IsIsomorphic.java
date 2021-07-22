package leetcode;

import java.util.HashMap;
import java.util.Map;

// 同构字符串
public class IsIsomorphic {
    public static void main(String[] args) {
        String s = "ab";
        String t = "ca";
        IsIsomorphic obj = new IsIsomorphic();
        System.out.println(obj.isIsomorphic(s, t));
    }

    /**
     * 该方法建立了两个Map，分别从两个方向上确保映射的唯一性。
     * 还有一个方法，分别将s和t中每个字符按顺序映射为序号，判断序号是否一致即可。
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> map1 = new HashMap<>();
        for (int i = 0; i < charS.length; i++) {
            if(map.containsKey(charS[i])){
                if(map.get(charS[i]).equals(charT[i])) continue;
                else return false;
            }else{
                if(map1.containsKey(charT[i])) {
                    if(map1.get(charT[i]).equals(charS[i])) continue;
                    else return false;
                }
                map.put(charS[i], charT[i]);
                map1.put(charT[i], charS[i]);
            }
        }
        return true;
    }
}
