package otherexperiment.huaweieagle;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author Defu Li
 * @since 2021/3/3 17:11
 */
public class DhcpServer {
    /**
     * 模拟小型DHCP服务器
     */

    int current_index = 0;  // 记录当前分配的位置
    Map<String, String> allocated;
    Map<String, String> released;
    Map<String, String> ip2mac;
    DhcpServer(){
        allocated = new HashMap<>();
        released = new HashMap<>();
        ip2mac = new HashMap<>();
    }

    String request(String mac) {
        if(allocated.containsKey(mac)) {
            // 重复申请
            return allocated.get(mac);
        }else if(released.containsKey(mac)) {
            // 已经申请，并已释放
            allocated.put(mac, released.get(mac));
            released.remove(mac);
            return allocated.get(mac);
        } else if(current_index > 255) {
            // 地址池资源枯竭
            String ip = getMinValue(released);
            String mac_temp = ip2mac.get(ip);
            released.remove(mac_temp);
            ip2mac.remove(ip);
            allocated.put(mac, ip);
            return ip;
        }else if(current_index <= 255 && current_index >= 0) {
            // 还没有枯竭
            String head = "192.168.0.";
            String tail = String.valueOf(current_index);
            String ip = head + tail;
            current_index++;
            allocated.put(mac, ip);
            return ip;
        }else {
            return "NA";
        }
    }

    void release(String mac) {
        if(allocated.containsKey(mac)) {
            released.put(mac, allocated.get(mac));
            ip2mac.put(allocated.get(mac), mac);
            allocated.remove(mac);
        }
    }

    public String getMinValue(Map map) {
        Collection<Object> values = map.values();
        Object[] obj=values.toArray();
        Arrays.sort(obj);
        return (String)obj[0];
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        DhcpServer dhcpServer = new DhcpServer();
        int operationCnt = cin.nextInt();
        for (int i = 0; i < operationCnt; i++) {
            String[] operation = cin.next().split("=");
            if("REQUEST".equals(operation[0])) {
                System.out.println(dhcpServer.request(operation[1]));
            }else {
                dhcpServer.release(operation[1]);
            }
        }
        cin.close();
    }
}
