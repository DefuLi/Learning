package otherexperiment;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UsingHashMap {
    public static void main(String[] args) {

        /**
         * 查看源码
         *
         * 具体解释参考《Java笔记》124页
         */
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("username", "defuli");
        map.get("username");
    }
}
