package leetcode;

// 第K个语法符号
public class KthGrammar {
    public static void main(String[] args) {
        int N = 4;
        int k = 5;
        KthGrammar obj = new KthGrammar();
        System.out.println(obj.kthGrammar(N, k));  // 1
    }

    /**
     * 递归
     * @param N
     * @param k
     * @return
     */
    public int kthGrammar(int N, int k) {
        if (N == 1 && k == 1) return 0;
        if (kthGrammar(N - 1, k / 2 + k % 2) == 1) {
            if (k % 2 == 1) return 1;
            else return 0;
        } else {
            if (k % 2 == 1) return 0;
            else return 1;
        }
    }
}
