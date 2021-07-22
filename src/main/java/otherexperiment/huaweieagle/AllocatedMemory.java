package otherexperiment.huaweieagle;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Defu Li
 * @date 2021/3/3 17:59
 */
public class AllocatedMemory {
    /**
     * 模拟内存分配
     */

    // 优先从低地址分配内存

    int[] memory;
    Map<Integer, Integer> allocated;
    AllocatedMemory() {
        memory = new int[100];  // 默认为0
        allocated = new HashMap<>();  // key首地址 value size
        Map map = new HashMap();
    }

    // 返回分配的内存首地址(string)，失败返回字符串 "error"
    String request(int size) {
        // 在此补充你的代码
        if(size >100 || size <= 0) {
            return "error";
        }
        int start = findUsableStartAddress(memory, size);
        if(start == -1) {
            return "error";
        }else {
            for (int i = start; i < start + size; i++) {
                memory[i] = 1;
            }
            allocated.put(start, size);
            return String.valueOf(start);
        }
    }

    // 成功返回 true；失败返回 false，失败时框架会自动输出 "error"
    boolean release(int startAddress) {
        // 在此补充你的代码
        if(allocated.containsKey(startAddress)) {
            // 包括
            int size = allocated.get(startAddress);
            allocated.remove(startAddress);
            for (int i = startAddress; i < startAddress + size; i++) {
                memory[i] = 0;
            }
            return true;
        }else {
            return false;
        }
    }
    public int findUsableStartAddress(int[] memory, int size) {
        int i = 0;
        int start = 0;
        int end = 0;
        while (i < 100) {
            int current_size = end - start + 1;
            if(size == current_size) {
                return start;
            }
            if(memory[i] == 0) {
                i++;
                end = i;
            }else {
                start = i + 1;
                end = start;
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        AllocatedMemory allocatedMemory = new AllocatedMemory();
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int line = Integer.parseInt(cin.nextLine());
        String[][] ins = new String[line][2];
        for (int i = 0; i < line; i++) {
            ins[i] = cin.nextLine().split("=");
            if (ins[i][0].startsWith("REQUEST")) {
                System.out.println(allocatedMemory.request(Integer.parseInt(ins[i][1])));
            } else {
                boolean ret = allocatedMemory.release(Integer.parseInt(ins[i][1]));
                if (!ret) {
                    System.out.println("error");
                }
            }
        }
        cin.close();
    }

}
