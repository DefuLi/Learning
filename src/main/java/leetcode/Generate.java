package leetcode;

import java.util.ArrayList;
import java.util.List;

// 杨辉三角
public class Generate {
    public static void main(String[] args) {
        int numRows = 5;
        Generate obj = new Generate();
        List<List<Integer>> res = obj.generate(numRows);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).toString());
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        if (numRows == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            res.add(list);
            return res;
        }
        if (numRows == 2) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            list1.add(1);
            list2.add(1);
            list2.add(1);
            res.add(list1);
            res.add(list2);
            return res;
        }
        if (numRows > 2) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            list1.add(1);
            list2.add(1);
            list2.add(1);
            res.add(list1);
            res.add(list2);
        }
        while (res.size() != numRows) {
            int size = res.size() + 1;  // 本次要生成的List尺寸
            List<Integer> list = new ArrayList<>();
            list.add(1);
            List<Integer> prior = res.get(res.size() - 1);  // 获取res列表中最后一个子列表
            while (list.size() != size) {
                for (int i = 0; i < prior.size() - 1; i++) {
                    list.add(prior.get(i) + prior.get(i + 1));
                }
                list.add(1);
            }
            res.add(list);
        }
        return res;
    }
}
