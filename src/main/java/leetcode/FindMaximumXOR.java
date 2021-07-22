package leetcode;

// 数组中两个数的最大异或值

/**
 * 两种方法可以实现，第一种方法是注释掉的方法，基于贪心算法的。
 * 从第一种方法里我学到了可以利用与或非异或等操作获取想要的数据。
 *
 * 第二种方法是基于Trie树的，先构建一颗深度为33的字典树，
 * 然后再对数组中每个数进行取反，查找Trie树。
 */
public class FindMaximumXOR {
    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        FindMaximumXOR obj = new FindMaximumXOR();
        System.out.println(obj.findMaximumXOR(nums));  // 28
    }

    XorNode head = new XorNode();  // 前缀树的头节点

    public int findMaximumXOR(int[] nums) {
        // 构建二叉树
        for (int i = 0; i < nums.length; i++) {
            buildTrie(nums[i]);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, search(nums[i]));
        }
        return res;
    }

    // 构建一颗前缀树 0或1
    public void buildTrie(int val) {
        XorNode node = head;
        for (int i = 31; i >= 0 ; i--) {  // 获取最高位至最低位的每个数值
            int bit = val>>i & 1;
            if(node.children[bit] == null) {  // 证明node节点不存在子节点，该子节点是bit
                XorNode bitNode = new XorNode();
                node.children[bit] = bitNode;
                node = node.children[bit];
            }else {  // node节点存在bit为值的子节点
                node = node.children[bit];
            }
        }
    }

    // 在前缀树中获取和val异或的最大值
    public int search(int val) {
        XorNode node = head;
        int res = 0;
        for (int i = 31; i >= 0 ; i--) {
            int bit = (val >> i & 1) ^ 1;  // 对当前位取反
            if(node.children[bit] == null) {
                node = node.children[bit ^ 1];
            }else {  // 可以保留当前值为1
                res = res | (1 << i);
                node = node.children[bit];
            }
        }
        return res;
    }

    /**
    // 先确定高位，再确定低位（有点贪心算法的意思），才能保证这道题的最大性质
    // 一位接着一位去确定这个数位的大小
    // 利用性质：a ^ b = c ，则 a ^ c = b，且 b ^ c = a

    public int findMaximumXOR(int[] nums) {
        int res = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            // 注意点1：注意保留前缀的方法，mask 是这样得来的
            // 用异或也是可以的 mask = mask ^ (1 << i);
            mask = mask | (1 << i);

            // System.out.println(Integer.toBinaryString(mask));
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                // 注意点2：这里使用 & ，保留前缀的意思（从高位到低位）
                set.add(num & mask);
            }  // set里存储着每个数的前缀

            // 这里先假定第 n 位为 1 ，前 n-1 位 res 为之前迭代求得
            int temp = res | (1 << i);
            for (Integer prefix : set) {
                if (set.contains(prefix ^ temp)) {
                    res = temp;
                    break;
                }
            }
        }
        return res;
    }
    */
}

// 构建字典树所需的节点
class XorNode{
    XorNode[] children = new XorNode[2];  // 只有0和1
}