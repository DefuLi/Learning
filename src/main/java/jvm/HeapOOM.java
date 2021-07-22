package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试堆内存溢出
 */
public class HeapOOM {
    public static class OOM{
    }

    /**
     * Java.lang.OutOfMemoryError: Java heap space
     * @param args
     */
    public static void main(String[] args) {
        List<OOM> list = new ArrayList<>();
        while (true) {
            list.add(new OOM());
        }
    }
}