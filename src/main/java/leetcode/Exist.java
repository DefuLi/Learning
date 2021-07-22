package leetcode;

import java.util.ArrayList;
import java.util.List;


// 矩阵中的路径
public class Exist {
    public static void main(String[] args) {
        char[][] board = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
        String word = "abcced";
        Exist obj = new Exist();
        System.out.println(obj.exist(board, word));  // true
    }

    /**
     * DFS 回溯算法
     * 对于以访问的元素，一开始我使用的是Set<String>集合，但是超时了，因为每次往set中add的时候，需要开辟字符串对象空间 耗时
     * 后来参考了题解，可以将访问过的字符改为'.'，然后再改回来
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        if (row * col < word.length()) return false;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    char temp = board[i][j];
                    board[i][j] = '.';
                    boolean res = helper(board, word, i, j, 1);
                    if (res == true) return true;
                    board[i][j] = temp;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, String word, int x, int y, int currindex) {
        if (currindex == word.length()) return true;
        List<XYPos> list = getNei(board, x, y);
        for (int i = 0; i < list.size(); i++) {
            if (board[list.get(i).x][list.get(i).y] == word.charAt(currindex)) {
                char temp = board[list.get(i).x][list.get(i).y];
                board[list.get(i).x][list.get(i).y] = '.';
                if (helper(board, word, list.get(i).x, list.get(i).y, currindex + 1)) return true;
                board[list.get(i).x][list.get(i).y] = temp;
            }
        }
        return false;

//        if (board[x][y] == word.charAt(currindex)) {
//            if (currindex == word.length() - 1) return true;
//
//            char temp = board[x][y];
//            board[x][y] = '.';
//            boolean res = false;
//            List<XYPos> list = getNei(board, x, y);
//            for (int i = 0; i < list.size(); i++) {
//                res = helper(board, word, list.get(i).x, list.get(i).y, currindex + 1);
//                if (res == true) return res;
//            }
//            board[x][y] = temp;
//            return res;
//        } else return false;
    }

    public List<XYPos> getNei(char[][] board, int x, int y) {
        List<XYPos> list = new ArrayList<>();
        int[] r = {-1, 1, 0, 0};
        int[] c = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            XYPos curr = new XYPos(x + r[i], y + c[i]);
            if (0 <= x + r[i] && x + r[i] < board.length && 0 <= y + c[i] && y + c[i] < board[0].length && board[curr.x][curr.y] != '.') {
                list.add(curr);
            }
        }
        return list;
    }

    // 坐标类
    public class XYPos {
        int x;
        int y;

        XYPos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
