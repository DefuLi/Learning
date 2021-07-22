package leetcode;

import java.util.ArrayList;
import java.util.List;

//杨辉三角Ⅱ
public class GetRow {
    public static void main(String[] args) {
        int rowIndex = 6;
        GetRow obj = new GetRow();
        List<Integer> list = obj.getRow(rowIndex);
        System.out.println(list.toString());
    }

    /**
     * 对于第k行的每一个数，有以下的规律
     *1,k,1*k*[(k-1)2]
     * 后一个数和前一个数有以下的递推
     * f(i+1) = (k-i)(i+1)f(i)
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex < 0) return null;
        double temp = 1;
        double temp2 = 1;
        list.add(1);
        for (int i = 0; i < rowIndex; i++) {
            temp2 = temp2 * (rowIndex-i) / (i+1);
            Integer temp3  = (int)temp2;
            list.add(temp3);
        }
        return list;
    }
}
