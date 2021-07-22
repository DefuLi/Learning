package leetcode;

import java.util.Arrays;

// 被围绕的区域
public class Solve {
    public static void main(String[] args) {
        char[][] board = {{'O', 'X', 'X', 'O', 'X'}, {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'}, {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'}};
        Solve obj = new Solve();
        obj.solve(board);
//        for (int i = 0; i < board.length; i++) {
//            System.out.println(Arrays.toString(board[i]));
//        }
    }

    //并查集做法
    int[] parent;
    int rows, cols;
    final int manx = 100005;

    int find(int x) {
        while (x != parent[x]) {
            x = parent[x];
        }
        return x;
    }

    void Union(int x, int y) {
        parent[find(y)] = find(x);
    }

    boolean same(int x, int y) {
        int xFather = find(x);
        int yFather = find(y);
        return xFather == yFather;
    }

    public void solve(char[][] board) {
        rows = board.length;
        if (rows == 0) return;
        cols = board[0].length;
        parent = new int[manx];
        for (int i = 0; i < manx; i++) {
            parent[i] = i;
        }
        int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i == 0 || i == rows - 1 || j == 0 || j == cols - 1) && board[i][j] == 'O') {
                    Union(i * rows + j, rows * cols);
                } else if (board[i][j] == 'O') {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (board[x][y] == 'O') {
                            Union(i * rows + j, x * rows + y);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!same(i * rows + j, rows * cols)) board[i][j] = 'X';
            }
        }
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}

/**
 * class UnionFind1{
 * int[] pre;  // 存储每个节点的老大
 * UnionFind1(char[][] board){
 * int row = board.length;
 * int col = board[0].length;
 * pre = new int[row * col];
 * for (int i = 0; i < row; i++) {
 * for (int j = 0; j < col; j++) {
 * pre[i * col + j] = i * col + j;
 * }
 * }
 * <p>
 * }
 * public int Find(int val) {
 * <p>
 * }
 * <p>
 * public void Union()
 * }
 */