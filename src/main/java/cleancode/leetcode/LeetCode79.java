package cleancode.leetcode;

/**
 * 单词搜索
 *
 * @author Defu Li
 * @since 2021/8/22 13:36
 */
public class LeetCode79 {
    public static void main(String[] args) {
        char[][] board = {{'A'}};
        String word = "A";
        LeetCode79 obj = new LeetCode79();
        System.out.println(obj.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = 1;
                if (dfs(board, i, j, visited, word, 0)) {
                    return true;
                }
                visited[i][j] = 0;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, int[][] visited, String word, int indexStr) {
        if (board[i][j] != word.charAt(indexStr)) {
            return false;
        }
        if (indexStr == word.length() - 1) {
            return true;
        }
        int[][] position = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = board.length;
        int n = board[0].length;
        for (int k = 0; k < 4; k++) {
            int[] pos = position[k];
            i += pos[0];
            j += pos[1];
            if (!(i >= 0 && i < m && j >= 0 && j < n) || visited[i][j] == 1) {
                i -= pos[0];
                j -= pos[1];
                continue;
            }
            visited[i][j] = 1;
            if (dfs(board, i, j, visited, word, indexStr + 1)) {
                return true;
            }
            visited[i][j] = 0;
            i -= pos[0];
            j -= pos[1];
        }
        return false;
    }
}
