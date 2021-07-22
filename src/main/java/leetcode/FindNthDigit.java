package leetcode;

// 数字序列中某一位的数字
public class FindNthDigit {
    public static void main(String[] args) {
        FindNthDigit obj = new FindNthDigit();  // 默认的已序列化的字符串是01234567891011121314...
        System.out.println(obj.findNthDigit(1000000000));  // 7
    }

    /**
     * 参考剑指offer 44题
     * 每次循环place++; index -= tatalCount;
     * @param index
     * @return
     */
    public int findNthDigit(int index) {
        if(index < 0) return -1;
        int place = 1;
        while (true) {
            long countAtPlace = getCountAtPlace(place);
            long totalCount = place * countAtPlace;  // 这里一定要用long类型 用int会超限变为负数
            if(index < totalCount) {
                return findNthDigit(index, place);
            }else {
                index -= totalCount;
                place++;
            }
        }
    }

    /**
     * place位的数字，共有多少个
     * @param place
     * @return
     */
    private int getCountAtPlace(int place) {
        if(place == 1) return 10;  // 0123456789
        return (int)Math.pow(10, place) - (int)Math.pow(10, place - 1);
    }

    /**
     *
     * @param index
     * @param place
     * @return
     */
    public int findNthDigit(int index, int place) {
        int startIntegerAtPlace = getStartIntegerAtPlace(place);
        int in = index / place;  // 取整
        int re = index % place;  // 取余
        int res = startIntegerAtPlace + in;
        String resS = String.valueOf(res);
        return resS.charAt(re) - '0';
    }

    /**
     * 如果place == 1 返回0; 如果place == 2 返回10
     * @param place
     * @return
     */
    private int getStartIntegerAtPlace(int place) {
        if(place == 1) return 0;
        return (int)Math.pow(10, place - 1);
    }
}
