package interview;

import java.util.*;
import java.util.List;

// 微软面试
public class MicrosoftInterview {
    public static void main(String[] args) throws CloneNotSupportedException {
        MicrosoftInterview microsoftInterview = new MicrosoftInterview();
//        int[] temp = {-2,0,-1};
//        int aa = test.getMaxProduct(temp);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ArrayList<Integer> list = new ArrayList<>();
        list = microsoftInterview.reverseList(listNode1);
        for (Integer integer: list) {
            System.out.println(integer);
        }



    }
    // 倒序生成链表
    public ArrayList<Integer> reverseList(ListNode listNode){
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        if(listNode == null){
            return list;
        }
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (stack.size() > 0){
            list.add(stack.pop());
        }

        ListNode listNode1 = new ListNode(list.get(0));
        for (Integer i :list) {
            listNode1.next = new ListNode(list.get(i+1));
        }
        return list;
    }
    // 计算最大连续字串的乘积
    public int getMaxProduct(int[] nums){
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<len; i++){
            int start = nums[i];
            for(int j=i+1; j<len; j++){
                int pro = start*nums[j];
                start = pro;
                list.add(pro);
            }
        }
        for (Integer i:list) {
            System.out.println(i);
        }
        Collections.sort(list);
        for (Integer i:list) {
            System.out.println(i);
        }
        System.out.println(list.get(list.size()-1));
    return 1;
    }
}

class ListNode{
    int val;
    public ListNode next = null;
    public ListNode(int val){
        this.val = val;
    }
}

