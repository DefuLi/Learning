package leetcode;

import java.util.*;

// 01矩阵
public class UpdateMatrix {
    public static void main(String[] args) {
        UpdateMatrix obj = new UpdateMatrix();
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] res = obj.updateMatrix(matrix);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        for (int i = 2; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    Queue<XYClass01> queue = new LinkedList<>();
                    Set<String> set = new HashSet<>();
                    XYClass01 root = new XYClass01(i, j);
                    queue.offer(root);
                    set.add(String.valueOf(root.x) + String.valueOf(root.y));
                    int nums = 0;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        while (size > 0) {
                            XYClass01 curr = queue.poll();
                            if (matrix[curr.x][curr.y] == 0) {
                                matrix[i][j] = nums;
                                int temp = queue.size();
                                for (int k = 0; k < temp; k++) {
                                    queue.poll();
                                }
                                break;
                            } else {
                                List<XYClass01> list = getAllState(curr, matrix);
                                for (int k = 0; k < list.size(); k++) {
                                    if (!set.contains(String.valueOf(list.get(k).x) + String.valueOf(list.get(k).y))) {
                                        queue.offer(list.get(k));
                                        set.add(String.valueOf(list.get(k).x) + String.valueOf(list.get(k).y));
                                    }
                                }
                            }
                            size--;
                        }
//                        if (queue.isEmpty()) break;
                        nums++;
                    }

                } else {  // matrix[i][j]  == 0 不进行任何操作
                    continue;
                }
            }
        }
        return matrix;
    }

    // 获取每个坐标的4个状态
    public List<XYClass01> getAllState(XYClass01 xyClass01, int[][] matrix) {
        List<XYClass01> list = new ArrayList<>();
        XYClass01 xyClass1 = new XYClass01(xyClass01.x + 1, xyClass01.y);
        XYClass01 xyClass2 = new XYClass01(xyClass01.x - 1, xyClass01.y);
        XYClass01 xyClass3 = new XYClass01(xyClass01.x, xyClass01.y + 1);
        XYClass01 xyClass4 = new XYClass01(xyClass01.x, xyClass01.y - 1);
        if (isBoundary(xyClass1, matrix)) list.add(xyClass1);
        if (isBoundary(xyClass2, matrix)) list.add(xyClass2);
        if (isBoundary(xyClass3, matrix)) list.add(xyClass3);
        if (isBoundary(xyClass4, matrix)) list.add(xyClass4);
        return list;

    }

    // 判断该节点是否在矩阵边界内
    public boolean isBoundary(XYClass01 xyClass01, int[][] matrix) {
        return xyClass01.x >= 0 && xyClass01.x < matrix.length && xyClass01.y >= 0 && xyClass01.y < matrix[0].length;
    }
}

class XYClass01 {
    public int x;
    public int y;

    XYClass01(int x, int y) {
        this.x = x;
        this.y = y;
    }
}