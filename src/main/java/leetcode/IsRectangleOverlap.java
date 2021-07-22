package leetcode;


// 矩阵重叠
public class IsRectangleOverlap {
    public static void main(String[] args) {
        int[] rec1 = {0, 0, 2, 2};
        int[] rec2 = {1, 1, 3, 3};
        IsRectangleOverlap obj = new IsRectangleOverlap();
        System.out.println(obj.isRectangleOverlap(rec1, rec2));  // true
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] ||   // left
                rec1[3] <= rec2[1] ||   // bottom
                rec1[0] >= rec2[2] ||   // right
                rec1[1] >= rec2[3]);    // top
    }
}
