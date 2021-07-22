package leetcode;

import java.util.HashSet;
import java.util.Set;

// 有效的数独
public class IsValidSudoku {
    public static void main(String[] args) {
        char[][] board = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        IsValidSudoku obj = new IsValidSudoku();
        System.out.println(obj.isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        if(board.length != board[0].length || board == null) return false;
        Set<Character>[] row = new HashSet[9];
        Set<Character>[] col = new HashSet[9];
        Set<Character>[] sub = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            sub[i] = new HashSet<>();
        }

        for (int i = 0; i < board.length; i++) {  // 行
            for (int j = 0; j < board[0].length; j++) {  // 列
                if(board[i][j] == '.') {
                    continue;
                }else {  // 不为'.'
                    int temp = (i/3)*3+j/3;
                    if(!row[i].contains(board[i][j]) && !col[j].contains(board[i][j]) && !sub[(i/3)*3+j/3].contains(board[i][j])) {
                        row[i].add(board[i][j]);
                        col[j].add(board[i][j]);
                        sub[(i/3)*3+j/3].add(board[i][j]);
                    }
                    else {
                        return false;
                    }
                }

            }
        }
        return true;
    }
}
