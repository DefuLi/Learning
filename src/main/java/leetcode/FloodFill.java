package leetcode;

import java.util.*;

// 图像渲染
public class FloodFill {
    public static void main(String[] args) {
        FloodFill obj = new FloodFill();
        int[][] image = {{0, 0, 0}, {0, 1, 1}};
        int[][] res = obj.floodFill(image, 1, 1, 1);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<XYClass> queue = new LinkedList<>();
        Set<XYClass> set = new HashSet<>();
        queue.offer(new XYClass(sr, sc));
        set.add(new XYClass(sr, sc));
        int currColor = image[sr][sc];
        if(image[sr][sc] == newColor) return image;
        while (!queue.isEmpty()) {
            XYClass curr = queue.poll();
            if (image[curr.x][curr.y] == currColor) image[curr.x][curr.y] = newColor;
            List<XYClass> list = getAllState(curr, image);
            for (int i = 0; i < list.size(); i++) {
                if (image[list.get(i).x][list.get(i).y] == currColor && !set.contains(list.get(i))) {
                    queue.offer(list.get(i));
                    set.add(list.get(i));
                }
            }
        }
        return image;
    }

    // 获取每个坐标的4个状态
    public List<XYClass> getAllState(XYClass xyClass, int[][] image) {
        List<XYClass> list = new ArrayList<>();
        XYClass xyClass1 = new XYClass(xyClass.x + 1, xyClass.y);
        XYClass xyClass2 = new XYClass(xyClass.x - 1, xyClass.y);
        XYClass xyClass3 = new XYClass(xyClass.x, xyClass.y + 1);
        XYClass xyClass4 = new XYClass(xyClass.x, xyClass.y - 1);
        if (isBoundary(xyClass1, image)) list.add(xyClass1);
        if (isBoundary(xyClass2, image)) list.add(xyClass2);
        if (isBoundary(xyClass3, image)) list.add(xyClass3);
        if (isBoundary(xyClass4, image)) list.add(xyClass4);
        return list;

    }

    // 判断是否在图片边界内
    public boolean isBoundary(XYClass xyClass, int[][] image) {
        return xyClass.x >= 0 && xyClass.x < image.length && xyClass.y >= 0 && xyClass.y < image[0].length;
    }
}

// 坐标类
class XYClass {
    public int x;
    public int y;

    XYClass(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
