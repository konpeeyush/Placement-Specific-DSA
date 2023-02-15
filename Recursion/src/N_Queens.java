import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class N_Queens {
    public static void main(String[] args) {
        System.out.println(N_Queens(4));
    }

    private static List<List<String>> N_Queens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        helper(ans, board, 0, board.length);
        return ans;
    }

    private static void helper(List<List<String>> ans, char[][] board, int col, int n) {
        if (col == n) {
            ans.add(constructBoard(board));
            return;
        }
        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                helper(ans, board, col + 1, n);
                board[row][col] = '.';
            }
        }
    }
    private static boolean isSafe(int row, int col, char[][] board, int n) {
        int duplRow = row;
        int duplCol = col;

//        Diagonal Upwards Movement towards left
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        col = duplCol;
        row = duplRow;
//        Vertical Movement towards left
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }
//        Diagonal Downwards Movement towards left
        col = duplCol;
        row = duplRow;
        while (row < n && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row++;
            col--;
        }
        return true;
    }

    private static List<String> constructBoard(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}
