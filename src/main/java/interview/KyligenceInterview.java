package interview;

public class KyligenceInterview {

}
/**
    // 1. 归并排序
    public int[] mergeSort(int[] origin) {
        if(origin.length < 2) return origin;
        int middle = array.length / 2;
        int[] leftArr = Arrays.copyOfRange(origin, 0, middle);
        int[] rightArr = Arrays.copyOfRange(origin, middle, origin.length);
        return mergeLeftAndRight(mergeSort(leftArr), mergeSort(rightArr));
    }

    public int[] mergeLeftAndRight(int[] leftArr, int[] rightArr) {
        int[] res = new int[leftArr.length + rightArr.length];
        int i = 0;
        int j = 0;
        for(int index = 0; index < res.length; index++) {
            if(i >= leftArr.length) res[index] = rightArr[j++];  // 左边遍历完
            else if(j >= right.length) res[index] = leftArr[i++];  // 右边遍历完
            else if(leftArr[i] > rightArr[j]) res[index] = rightArr[j++];
            else res[index] = leftArr[i++];
        }
        return res;
    }


// 2. 反转单向连表
// intput: 1->2->3
// output: 3->2->1

    Class Node {
        int v;
        Node next;
    }

    public Node reverseLinkedList(Node head) {
        if(head == null || head.next == null) return head;
        Node pre, next;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


// 3. 大整数相加 BigInt add

// 35 + 42 = 77

    class BigInt {
        int[] data;
        public BigInt(int[] data) {
            this.data = data;
        }

        public BigInt add(BigInt other) {
            int len1 = data.length;
            int len2 = other.data.length;
            int[] res = new int[Math.max(len1, len2) + 1];  // 保存相加的结果
            int carry = 0;
            int index = res.length - 1;
            while(len1 >= 0 || len2 >= 0) {
                int in1 = len1 >= 0 ? data[len1] : 0;
                int in2 = len2 >= 0 ? other.data[len2] : 0;
                int temp = in1 + in2 + carry;
                carry = temp / 10;
                res[index--] = temp % 10;
                len1--;
                len2--;
            }
            if(carry == 1) {
                res[index] = 1;
                return new BigInt(res);
            }else {
                return new BigInt(Arrays.copyOfRange(res, 1, res.length));
            }
        }

        BigInt thritytwo = new BigInt(32);
        BigInt seventy = thritytwo.add(new BigInt(42));
    }

 */