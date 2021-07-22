package leetcode;

// 二进制中1的个数
public class HammingWeight {
    public static void main(String[] args) {
        System.out.println(1 << 3);
        System.out.println(1 << 31);
        int n = 3;
        HammingWeight obj = new HammingWeight();
        System.out.println(obj.hammingWeight(n));  // 2
    }

    /**
     * 让flag = 1 不断的左移 由于java中没有无符号整数 所有移到最左边时 就是0 本来要得到的是100000000.....，但是在java中这是0
     * 如果n小于0 那么dis+1 可以解决上述问题
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int dis = 0;
        if(n < 0 ) dis++;
        int flag = 1;
        while (flag > 0) {
            if((n & flag) > 0 ) dis++;
            flag = flag << 1;
        }
        return dis;
    }

}
